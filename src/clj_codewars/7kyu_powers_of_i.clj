(ns clj-codewars.7kyu-powers-of-i)

;; Powers of i
; i is the imaginary unit, it is defined by i² = -1, therefore it is a solution to x²+1=0.
; Your Task
; is to write a function pofi that returns i to the power of a given non-negative integer in its simplest form as
; a string (answer may contain i).

(defn pofi [n]
  (let [rem (mod n 4)]
    (cond (= 0 rem) "1"
          (= 1 rem) "i"
          (= 2 rem) "-1"
          (= 3 rem) "-i")))