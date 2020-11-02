(ns clj-codewars.7kyu-simple-template
  (:require [clojure.string :as str]))

;; Simple template
;
; Implement function createTemplate which takes string with tags wrapped in {{brackets}} as input and returns closure,
; which can fill string with data (flat object, where keys are tag names).
;
; ((template "{{name}} likes {{animalType}}") {:name "John" :animalType "dogs"}) ;; John likes dogs
;
; When key doesn't exist in the map, put there empty string.


(defn template [s]
  (fn [k]
    (let [rgx         (re-seq #"\{\{(.*?)\}\}" s)
          replacements (map (fn [m] [(first m) (keyword (second m))]) rgx)]
      (prn replacements)
      (loop [i 0
             s s]
        (if (= i (count replacements))
          s
          (recur (inc i) (str/replace s (first (nth replacements i)) (get k (second (nth replacements i)) ""))))))))