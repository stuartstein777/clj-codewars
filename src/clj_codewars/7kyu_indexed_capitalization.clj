(ns clj-codewars.7kyu-indexed-capitalization
  (:require [clojure.string :as str]))

;; Indexed capitalization
;  Given a string and an array of integers representing indices, capitalize all letters at the given indices.
;
; For example:
;    capitalize("abcdef",[1,2,5]) = "aBCdeF"
;    capitalize("abcdef",[1,2,5,100]) = "aBCdeF". There is no index 100.
; The input will be a lowercase string with no spaces and an array of digits.

(defn capitalize [s idx]
  (let [idxs (set idx)]
    (apply str (map-indexed (fn [ix i]
                              (if (idxs ix)
                                (str/upper-case (str i))
                                i)) s))))
