(ns adventura.graph
  (:require
   [ubergraph.core :as uber]
   )
  )

(def game-graph (uber/graph))

(def game-graph
  (uber/add-nodes-with-attrs*
 game-graph
 [
  [:entry-hall
   {:description "The room is carpeted and has a high ceiling with stained glass windows"
    :dangerous true
    :visited false}]
  [:salon
   {:description "Filled with comfortable furniture and shelves full of dusty books"}]
  [:study
   {:description "A small room ocupied mostly by a large desk littered with books and a fancy leather chair"}]
  [:laboratory
   {:description "White wall and experimental benches covered with beakers and viles of chemicals.  The room smells of strong santitizing chemicals."}
   ]
  ]))

(def opposites {
                :n :s
                :s :n
                :e :w
                :w :e
                :nw :se
                :ne :sw
                :se :nw
                :sw :ne
                })

(defn gen-edges
  [node1 node2 node1->node2]
  (let
      [
       cardinal (if (keyword? node1->node2) node1->node2 (keyword node1->node2))
       opposite (cardinal opposites)]
    [
     [node1 node2 {:cardinal-direction cardinal}]
     [node2 node1 {:cardinal-direction opposite}]
     ]
    ))


(defn link-rooms
  [game-graph node1 node2 cardinal]
  (let [
        [a b] (gen-edges node1 node2 cardinal)
        ]
    (uber/add-directed-edges game-graph
                             a
                             b
                             )))


(defn initialize-player
  [g start]
  (->
   g
   (uber/add-nodes :player)
   (uber/add-edges [:player start {:type :location}])))


(def game-graph
  (->
   game-graph
   (link-rooms :entry-hall :salon :e)
   (link-rooms :entry-hall :laboratory :s)
   (link-rooms :study :salon :e)
   (initialize-player :salon)
   ))

(defn get-player-location-edge
  [g]
  (uber/find-edge g {:src :player :type :location})
  )

(defn player-location-node
  [game-graph]
  (let
      [edge (get-player-location-edge game-graph)]
    (second (uber/node-with-attrs game-graph (:dest edge)))))

(defn move-player
  [destination]
  (let
      [current-location-edge (get-player-location-edge game-graph)
       ]
    (-> game-graph
        (uber/remove-edges current-location-edge)
        (uber/add-edges [:player destination {:type :location}])
      )))


(defn print-story
  [g]
  (let
      [location (player-location-node g)]
    (prn (:description location))))


(uber/viz-graph game-graph)

