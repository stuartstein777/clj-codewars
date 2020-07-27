(ns clj-codewars.7kyu-most-valuable-character
  (:require [clojure.string :as str]))

;; Most valuable character
; In this Kata, you will be given a string and your task is to return the most valuable character. The value of a character is the difference between the index of its last occurrence and the index of its first occurrence. Return the character that has the highest value. If there is a tie, return the lexicographically lowest character. [For Golang return rune]
;
; All inputs will be lower case.
;
; For example:
;   solve('a') = 'a'
;   solve('ab') = 'a'. Last occurrence is equal to first occurrence of each character. Return lexicographically lowest.
;   solve("axyzxyz") = 'x'
;
; More examples in test cases. Good luck!

(defn distance-then-lexicography [[c1 v1] [c2 v2]]
  (let [c (compare v2 v1)]
    (if (zero? c)
      (compare c1 c2) c)))

(defn most-valuable-character [s]
  (->> (map (fn [x] [x (- (str/last-index-of s x) (str/index-of s x))]) s)
       (distinct)
       (sort distance-then-lexicography)
       (ffirst)))