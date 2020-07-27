(ns clj-codewars.7kyu-alternate-capitlization
  (:require [clojure.string :as str]))

;; Alternate capitalization
; Given a string, capitalize the letters that occupy even indexes and odd indexes separately,
; and return as shown below. Index 0 will be considered even.
;
; For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.
;
; The input will be a lowercase string with no spaces.

(defn solve-alternate-capitalization [s]
  [(apply str (map-indexed (fn [i c] (if (odd? i) c (str/upper-case c))) s))
   (apply str (map-indexed (fn [i c] (if (even? i) c (str/upper-case c))) s))])
