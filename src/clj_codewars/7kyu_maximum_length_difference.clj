(ns clj-codewars.7kyu-maximum-length-difference)

;; Maximum Length Difference
; You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any string
; in the first array and y be any string in the second array.
;
; Find max(abs(length(x) − length(y)))
;
; If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).
;
; #Example:
;
; a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
; a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
; mxdiflg(a1, a2) --> 13

(defn mxdiflg [a1 a2]
  (if (or (empty? a1) (empty? a2))
    -1
    (let [max-diff-a1-a2 (- (apply max (map count a1)) (apply min (map count a2)))
          max-diff-a2-a1 (- (apply max (map count a2)) (apply min (map count a1)))]
      (if (> max-diff-a1-a2 max-diff-a2-a1)
        max-diff-a1-a2
        max-diff-a2-a1))))