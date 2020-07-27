(ns clj-codewars.8kyu-calculate-average)

;; Calculate average
; Write function avg which calculates average of numbers in given list.

(defn find-average [numbers]
  (/ (reduce + numbers) (count numbers)))
