(ns clj-codewars.7kyu-powers-of-3)

;; Powers of 3
; Given a positive integer N, return the largest integer k such that 3^k < N.
; For example,
;   largest_power(3) == 0
;   largest_power(4) == 1
; You may assume that the input to your function is always a positive integer.

(defn largest-power [n]
  (if (= n 1)
    -1
    (loop [r 1]
      (if (>= (Math/pow 3 r) n)
        (dec r)
        (recur (inc r))))))
