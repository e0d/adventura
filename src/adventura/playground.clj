(ns adventura.playground
  (:require
   [ubergraph.core :as uber]
   )
  )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(foo "1")

(type foo)

(type "henry")

(def y {:foo "bar"})

;; print("Hello, World!")
;; (print "Hello, World!")

(+ 12 10)

(def numbers [1 2 3 4 5 6 7 8 9])

(+ 1 2 3 4 5 6 7 8 9)

(reduce - numbers)

(def henry {:name "Henry" :age 11 :glasses? true :sex "male"})

(:sex henry)

(:name henry)

(keys henry)


(def lusi {:name "lusi" :color "black" :type "porty" :sex "female" :age 7})

(:type lusi)

(defn echo
  [x]
  x)

(echo "foo")

(defn say-something
  [something]
  (println something))

(defn simple-adder
  [number-one number-two]
  (+ number-one number-two))

(simple-adder 4 5)

(def answer (simple-adder 10 5))

(println answer)

(say-something "something else")

(str "my" "name" "is" "henry")

;; Create function named another-function
;; it should take 2 arguements
;; it should combing them with str command


(defn another-function
  [ting1 ting2 ting3]
  (str  ting1 ting2 ting3))

 (another-function "foo" " " "bar")

(println (another-function "foo" " " "bar"))

;; "foobar"
;; "foo bar"
