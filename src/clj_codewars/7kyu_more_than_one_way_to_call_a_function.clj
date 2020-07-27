(ns clj-codewars.7kyu-more-than-one-way-to-call-a-function)

;; More than one way to call a function, or skin a cat.
; Write a single function that can be invoked by either
; (sum 2 3) ;; 5 ;; or ((sum 2) 3) ;; 5
; Both of these examples should return the sum of the 2 numbers.

(defn sum
  ([a b] (+ a b))
  ([a] (fn [b] (+ a b))))
