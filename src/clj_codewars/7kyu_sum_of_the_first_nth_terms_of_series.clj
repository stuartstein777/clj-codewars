(ns clj-codewars.7kyu-sum-of-the-first-nth-terms-of-series)

;; Sum of the first nth term of Series
; Your task is to write a function which returns the sum of following series upto nth term(parameter).
; Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
; Rules:
;    You need to round the answer to 2 decimal places and return it as String.
;    If the given value is 0 then it should return 0.00
;    You will only be given Natural Numbers as arguments.
;
; Examples:
;
; SeriesSum(1) => 1 = "1.00"
; SeriesSum(2) => 1 + 1/4 = "1.25"
; SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"

(defn series-sum [n]
  (loop [total 0
         c 1
         d 1]
    (if (> c n)
      (format "%.2f"(double total))
      (recur (+ total (/ 1.0 d)) (inc c) (+ 3 d)))))