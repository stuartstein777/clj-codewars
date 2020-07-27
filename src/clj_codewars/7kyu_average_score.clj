(ns clj-codewars.7kyu-average-score)

;; Average Score
; Create a function that returns the average of an array of numbers ("scores"), rounded to the nearest whole number.
; You are not allowed to use any loops (including for, for/in, while, and do/while loops).

(defn average [data]
  (if (empty? data)
    0
    (quot (reduce + data) (count data))))
