(ns clj-codewars.7kyu-sxore)

;; Binary sXORe
; Given a number n we will define it's sXORe to be 0 XOR 1 XOR 2 ... XOR n where XOR is the bitwise XOR operator.
;
; Write a function that takes n and returns it's sXORe.

(defn sxore [n]
  (if (= 0 n)
    0
    (let [r (rem (dec n) 4)]
      (cond (= r 0) 1
            (= r 1) (inc n)
            (= r 2) 0
            (= r 3) n))))
