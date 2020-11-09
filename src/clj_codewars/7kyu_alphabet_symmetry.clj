(ns clj-codewars.7kyu-alphabet-symmetry
  (:require [clojure.string :as str]))

;; Alphabet symmetry
;
; Consider the word "abode". We can see that the letter a is in position 1 and b is in position 2. In the alphabet,
; a and b are also in positions 1 and 2. Notice also that d and e in abode occupy the positions they would occupy in
; the alphabet, which are positions 4 and 5.
;
; Given an array of words, return an array of the number of letters that occupy their positions in the alphabet for each
; word. For example,
;
;   solve(["abode","ABc","xyzD"]) = [4, 3, 1]
;
; See test cases for more examples.
;
; Input will consist of alphabet characters, both uppercase and lowercase. No spaces.
;
; Good luck!

(defn find-matches [word]
  (let [alphabet (map identity "abcdefghijklmnopqrstuvwxyz")]
    (reduce (fn [acc i] (if (= (nth word i) (nth alphabet i))
                          (inc acc)
                          acc)) 0 (range (count word)))))

(defn solve [xs]
  (->> (map str/lower-case xs)
       (map find-matches)))