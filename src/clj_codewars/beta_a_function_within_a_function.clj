(ns clj-codewars.beta-a-function-within-a-function)

;; A function within a function
; Given an input n, write a function always that returns a function which returns n. Ruby should return a lambda or a
; proc.

(defn always [n]
  (fn [] n))

