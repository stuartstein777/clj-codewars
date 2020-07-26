(ns clj-codewars.6kyu-which-are-in
  (:require [clojure.string :as str]))

;; Which are in?
; Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are
; substrings of strings of a2.
;
; Example 1: a1 = ["arp", "live", "strong"]
;     a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
;     returns ["arp", "live", "strong"]
; Example 2: a1 = ["tarp", "mice", "bull"]
;     a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
;     returns []

(defn in-array [coll1 coll2]
  (->>
    (filter (fn [x] (some (fn [y] (str/includes? y x)) coll2)) coll1)
    (distinct)
    (sort)))
