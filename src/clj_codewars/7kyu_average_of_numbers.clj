(ns clj-codewars.7kyu-average-of-numbers)

;; Average of numbers
; #Get the averages of these numbers
; Write a method, that gets an array of integer-numbers and return an array of the averages of each integer-number and
; his follower, if there is one.
; Example:
; Input:  [ 1, 3, 5, 1, -10]
; Output:  [ 2, 4, 3, -4.5]
; If the array has 0 or 1 values or is null or None, your method should return an empty array.

(defn averages [ls]
  (if (< (count ls) 2)
    []
    (loop [xs ls
           a (first xs)
           b (second xs)
           avgs []]
      (if (= 1 (count xs))
        avgs
        (recur (rest xs) (first (rest xs)) (second (rest xs)) (conj avgs (/ (+ a b) 2.0)))))))
