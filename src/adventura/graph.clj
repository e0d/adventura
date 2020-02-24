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
   {:description "The room is carpeted and has a high ceiling with stained glass windows" :dangerous true}]
  [:salon
   {:description "Filled with comfortable furniture and shelves full of dusty books"}]
  [:study
   {:description "A small room ocupied mostly by a large desk littered with books and a fancy leather chair"}]
  [:laboratory
   {:description "White wall and experimental benches covered with beakers and viles of chemicals.  The room smells of strong santitizing chemicals."}
   ]
  ]))

(def game-graph
  (uber/add-directed-edges game-graph
                           [:entry-hall :salon {:cardinal-direction "e"}]
                           [:salon :entry-hall {:cardinal-direction "w"}]
                           [:entry-hall :laboratory {:cardinal-direction "s"}]
                           [:laboratory :entry-hall {:cardinal-direction "n"}]
                           [:salon :study {:cardinal-direction "e"}]
                           [:study :salon {:cardinal-direction "w"}]))

(def game-graph
  (uber/add-nodes game-graph
                  :player
                  ))

(def game-graph
  (uber/add-edges game-graph
                  [:player :entry-hall {:type :location}]))

(defn move-player
  [destination]
  (let
      [current-location-edge
       (uber/find-edge game-graph {:src :player :type :location})
       ]
    (-> game-graph
      (uber/add-edges [:player destination])
      (uber/remove-edges current-location-edge)
      )))


(uber/viz-graph (move-player :laboratory))

(uber/pprint game-graph)

(uber/viz-graph game-graph)

(uber/node-with-attrs game-graph :entry-hall)

(:description (second (uber/node-with-attrs game-graph :entry-hall)))

(map #(uber/node-with-attrs game-graph %) (map :dest (uber/out-edges game-graph :entry-hall)))



(uber/out-edges game-graph :entry-hall)
