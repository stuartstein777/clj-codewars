(ns clj-codewars.7kyu-square-n-sum)

;; Square(n) Sum
;
; Complete the square sum function so that it squares each number passed into it and then sums the results together.
; For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.

(defn square-sum [lst]
  (reduce (fn [a i] (+ a (* i i))) 0 lst))