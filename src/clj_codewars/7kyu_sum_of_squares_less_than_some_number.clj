(ns clj-codewars.7kyu-sum-of-squares-less-than-some-number)

;; Sum of squares less than some number
; Write a function getNumberOfSquares that will return how many integer (starting from 1, 2...) numbers raised to power
; of 2 and then summed up are less than some number given as a parameter.
;
; E.g 1: For n = 6 result should be 2 because 1^2 + 2^2 = 1 + 4 = 5 and 5 < 6 E.g 2: For n = 15 result should be 3
; because 1^2 + 2^2 + 3^2 = 1 + 4 + 9 = 14 and 14 < 15

(defn get-number-of-squares [n]
  (count (take-while #(> n (second %)) (iterate (fn [[a b]] [(inc a) (+ b (* (inc a) (inc a)))]) [1 1]))))