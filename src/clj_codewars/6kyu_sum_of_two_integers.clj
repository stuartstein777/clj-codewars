(ns clj-codewars.6kyu-sum-of-two-integers)

;; Task
;
;Given Two integers a , b , find The sum of them , BUT You are not allowed to use the operators + and -
;Notes
;
;    The numbers (a,b) may be positive , negative values or zeros .
;    Returning value will be an integer .
;    clojure: +, -, (inc), (dec), (range), (reduce), (eval), (map) are prohibited.

(defn add [x y]
  (if (zero? y)
    x
    (recur (bit-xor x y) (bit-shift-left (bit-and x y) 1))))