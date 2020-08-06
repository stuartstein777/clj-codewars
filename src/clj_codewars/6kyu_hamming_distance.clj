(ns clj-codewars.6kyu-hamming-distance)

;; Hamming Distance
;
; The Hamming Distance is a measure of similarity between two strings of equal length. Complete the function so that it
; returns the number of positions where the input strings do not match.
;
; Examples (in JavaScript):
;
;   hamming("I like turtles","I like turkeys")  //returns 3
;   hamming("Hello World","Hello World")  //returns 0
;
; You can assume that the two input strings are of equal length.

(defn hamming [s1 s2]
  (loop [s1 s1 s2 s2 i 0]
    (if (empty? s1)
      i
      (if (not= (first s1) (first s2))
        (recur (rest s1) (rest s2) (inc i))
        (recur (rest s1) (rest s2) i)))))