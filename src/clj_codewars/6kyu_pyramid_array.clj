(ns clj-codewars.6kyu-pyramid-array)

(ns clj-codewars.6kyu-pyramid-array
  (:require [clojure.test :refer :all]))

;; Pyramid Array
; Write a function that when given a number >= 0, returns an Array of ascending length subarrays.
;
; pyramid(0) => [ ]
; pyramid(1) => [ [1] ]
;pyramid(2) => [ [1], [1, 1] ]
; pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]
;
; Note: the sub arrays should be filled with 1s

(defn pyramid [n]
  (map #(vec (repeat % 1)) (range 1 (inc n))))
