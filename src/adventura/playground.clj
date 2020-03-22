(ns adventura.playground
  (:require
   [ubergraph.core :as uber]
   )
  )


(def my-vector [1 2 3])

;; Destructuring

(let
    [
     [a b c] my-vector
     ]
  (prn c))


(type my-vector)

(defn add-list
  [l]
  (reduce + l))

(add-list my-vector)

(conj my-vector 9)

(prn my-vector)

(conj my-vector )

(def ten 10)

(def my-vector (conj my-vector 9))

(conj my-vector ten)

 (def nested-map
  {:a :keyword
   "foo" 1
   :b 2
   :c {:d {:e 1 :f 2 :g 3}}
   })

("foo" nested-map)

((keyword "foo") nested-map)

(keyword "foo")

(get nested-map "foo")

(get nested-map :b)

(:b nested-map)

(:c nested-map)

(clojure.pprint/pprint nested-map)

(def sentence "The quick brown fox jumps over the lazy dog")

(def words
(clojure.string/split sentence #" "))


(println sentence)


(type words)
(count words)

(nth words 0)

(map makeywords words)

(makeywords (first words))
(makeywords (second words))
...


(defn makeywords
  [text]
 (println text))

(makeywords "foo")



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


(def input "This is my input")

;; types of things

(def n 1)
(def s "this is a string")
(def v [1 2 3 4])
(def l '(1 2 3 4))
(def m {:a "foo" :b "bar"})

(type m)

(def v (conj v 1))

(prn v)
