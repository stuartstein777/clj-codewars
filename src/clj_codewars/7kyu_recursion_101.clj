(ns clj-codewars.7kyu-recursion-101)

;; Recursion 101
; In this Kata, you will be given two positive integers a and b and your task will be to apply the following operations:
;
; i) If a = 0 or b = 0, return [a,b]. Otherwise, go to step (ii);
; ii) If a ≥ 2*b, set a = a - 2*b, and repeat step (i). Otherwise, go to step (iii);
; iii) If b ≥ 2*a, set b = b - 2*a, and repeat step (i). Otherwise, return [a,b].

(defn recursion-101
  [a b]
  (cond (or (zero? a) (zero? b)) (list a b)
        (>= a (* 2 b)) (recur (- a (* 2 b)) b)
        (>= b (* 2 a)) (recur a (- b (* 2 a)))
        :else (list a b)))
