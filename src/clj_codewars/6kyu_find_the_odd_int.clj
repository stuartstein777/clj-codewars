(ns clj-codewars.6kyu-find-the-odd-int)

;; Find the odd int
; Given an array, find the integer that appears an odd number of times.
; There will always be only one integer that appears an odd number of times.

(defn find-odd [xs]
  (first (first (filter #(odd? (second %)) (frequencies xs)))))
