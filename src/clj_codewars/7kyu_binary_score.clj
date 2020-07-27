(ns clj-codewars.7kyu-binary-score)

;; Binary scORe
; Given a number n we will define its scORe to be 0 | 1 | 2 | 3 | ... | n, where | is the bitwise OR operator.
; Write a function that takes n and finds it's scORe.
; n 	      scORe n
; 0 	      0
; 1 	      1
; 49 	      63
; 1000000 	1048575

(defn score [n]
  (reduce + (take-while #(<= % n) (iterate #(* 2 %) 1N))))
