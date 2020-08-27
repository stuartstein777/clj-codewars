(ns clj-codewars.6kyu-Srot-the-inner-ctonnet-in-dsnnieedcg-oredr
  (:require [clojure.string :as str]))

;; Srot the inner ctnnoet in dsnnieedcg oredr
;
; You have to sort the inner content of every word of a string in descending order.
;The inner content is the content of a word without first and the last char.
;
;Some examples:
;
;"sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
;"wait for me" -> "wiat for me"
;"this kata is easy" -> "tihs ktaa is esay"
;
;The string will never be null and will never be empty.
;It will contain only lowercase-letters and whitespaces.

(defn sort-inner [text]
  (if (< (count text) 2)
    [text text]
    [text (str (first text)
               (apply str (reverse (sort (butlast (rest text)))))
               (last text))]))

(defn sort-the-inner-content [words]
  (->> (re-seq #"\w+" words)
       (map sort-inner)
       (reduce (fn [acc re] (str/replace acc (first re) (second re))) words)))