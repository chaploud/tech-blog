^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.hello-world
  (:require [nextjournal.clerk :as clerk]))

;; # Hello World with Clerk
;;
;; This is a sample notebook demonstrating Clerk functionality.

;; ## Basic Computation

(+ 1 2 3)

;; ## Data Visualization

(def sample-data
  [{:name "Alice" :age 30 :city "Tokyo"}
   {:name "Bob" :age 25 :city "Osaka"}
   {:name "Charlie" :age 35 :city "Kyoto"}])

sample-data

;; ## Interactive Code

(defn fibonacci [n]
  (if (<= n 1)
    n
    (+ (fibonacci (- n 1))
       (fibonacci (- n 2)))))

(map fibonacci (range 10))

;; ## Plot Example

(clerk/plotly
 {:data [{:x (range 10)
          :y (map #(* % %) (range 10))
          :type "scatter"
          :mode "lines+markers"
          :name "y = x²"}]
  :layout {:title "Simple Quadratic Function"
           :xaxis {:title "x"}
           :yaxis {:title "y"}}})