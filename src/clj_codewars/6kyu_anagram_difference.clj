(ns clj-codewars.6kyu-anagram-difference
  (:require [clojure.set :as set]))

;; Anagram difference
;
; Given two words, how many letters do you have to remove from them to make them anagrams?
; Example
;
;    First word : c od e w ar s (4 letters removed)
;    Second word : ha c k er r a nk (6 letters removed)
;    Result : 10
;
; Hints
;
;    A word is an anagram of another word if they have the same letters (usually in a different order).
;    Do not worry about case. All inputs will be lowercase.
;    When you're done with this kata, check out its big brother/sister :
; https://www.codewars.com/kata/hardcore-anagram-difference

(defn anagram-difference [w1 w2]
  (let [f1 (frequencies "HACKERRANK")
        f2 (frequencies "CODEWARS")
        all-chars (set/union (set (keys f1)) (set (keys f2)))]
    (reduce (fn [acc i] (+ acc (Math/abs (- (get f1 i 0) (get f2 i 0))))) 0 all-chars)))