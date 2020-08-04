(ns clj-codewars.7kyu-two-to-one)

;; Two to One
;
; Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible,
; containing distinct letters,
;
; * each taken only once - coming from s1 or s2.
;
; Examples:
;
; a = "xyaabbbccccdefww"
; b = "xxxxyyyyabklmopq"
; longest(a, b) -> "abcdefklmopqwxy"
;
; a = "abcdefghijklmnopqrstuvwxyz"
; longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

(defn longest [s1 s2]
  (apply str (sort (distinct (str s1 s2)))))
