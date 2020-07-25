(ns clj-codewars.6kyu-2
  (:require [clojure.string :as str]))


;; Ranger Parser
; In this Kata you are to implement a function that parses a string which is composed from tokens of the form
; 'n1-n2,n3,n4-n5:n6' where 'nX' is a positive integer. Each token represent a different range:
;
; 'n1-n2' represents the range n1 to n2 (inclusive in both ends).
; 'n3' represents the single integer n3.
; 'n4-n5:n6' represents the range n4 to n5 (inclusive in both ends) but only includes every other n6 integer.
; Notes:
;
; The input string doesn't not have to include all the token types.
; All integers are assumed to be positive.
; Tokens may be separated by ',', ', ' or ,.
;
; Some examples:
;
; '1-10,14, 20-25:2' -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 20, 22, 24]
; '5-10' -> [5, 6, 7, 8, 9, 10]
; '2' -> [2]
;
; The output should be a list of integers.

(defn get-range [r]
  (let [splits (str/split r #"-|:")]
    (if (= 1 (count splits))
      (Integer/parseInt (first splits))
      (range (Integer/parseInt (first splits))
             (inc (Integer/parseInt (second splits)))
             (Integer/parseInt (nth splits 2 "1"))))))

(defn range-parser [s]
  (->> (str/split s #",")
       (map str/trim)
       (map get-range)
       (flatten)))
;; -------------------------------------------END---

;; Split Strings
; Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number
; of characters then it should replace the missing second character of the final pair with an underscore ('_').
;
; Examples:
;   (solution "abc") ; => ["ab" "c_"]
;   (solution "abcd") ; => ["ab" "cd"]

(defn split-strings [s]
  (vec (if (not (zero? (mod (count s) 2)))
         (map (partial apply str) (partition-all 2 (str s "_")))
         (map (partial apply str) (partition-all 2 s)))))
;; -------------------------------------------END---

;;Basics 08: Find next higher number with same Bits (1's)
; Your task is to Find the next higher number (int) with same '1'- Bits.
;
; I.e. as much '1' bits as before and output next higher than input. Input is always an int >0 up to 1<<30. No bad
; cases or special tricks...
;
; Some easy examples:
;
; Input: 129  => Output: 130 (10000001 => 10000010)
; Input: 127 => Output: 191 (01111111 => 10111111)
; Input: 1 => Output: 2 (01 => 10)
; Input: 323423 => Output: 323439 (1001110111101011111 => 1001110111101101111)

(defn next-higher [x]
  (let [bin (Integer/toString x 2)
        one-count (count (filter #(= \1 %) bin))]
    (loop [n (inc x)]
      (let [bin-n (Integer/toString n 2)
            n-ones (count (filter #(= \1 %) bin-n))]
        (if (= n-ones one-count)
          n
          (recur (inc n)))))))
;; -------------------------------------------END---
