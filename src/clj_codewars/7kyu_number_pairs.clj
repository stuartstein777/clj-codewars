(ns clj-codewars.7kyu-number-pairs)

;; NumberPairs
; In this Kata the aim is to compare each pair of integers from 2 arrays, and return a new array of large numbers.
; Note: Both arrays have the same dimensions.
; Example:
;   (= arr1 [13, 64, 15, 17, 88])
;   (= arr2 [23, 14, 53, 17, 80])
;   (= (getLargerNumbers arr1 arr2) [23 64 53 17 88])

(defn get-larger-numbers [a b]
  (if (empty? a)
    []
    (map #(if (>= %1 %2)
            %1
            %2) a b)))
