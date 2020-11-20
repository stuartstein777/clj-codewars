(ns clj-codewars.7kyu-alphabet-symmetry
  (require [clojure.string :as str]))

;; Alphabet symmetry
;
; Consider the word "abode". We can see that the letter a is in position 1 and b is in position 2. In the
; alphabet, a and b are also in positions 1 and 2. Notice also that d and e in abode occupy the positions
; they would occupy in the alphabet, which are positions 4 and 5.
;
; Given an array of words, return an array of the number of letters that occupy their positions in the
; alphabet for each word. For example,
;
;   solve(["abode","ABc","xyzD"]) = [4, 3, 1]
;
; Input will consist of alphabet characters, both uppercase and lowercase. No spaces.

(defn number-of-matches [s]
  (let [alphabet "abcdefghijklmnopqrstuvwxyz"
        s (str/lower-case s)]
    (->> (keep #(= (nth alphabet %) (nth s %)) (range 0 (count s)))
         (filter true?)
         (count))))

(defn solve [s]
  (map number-of-matches s))