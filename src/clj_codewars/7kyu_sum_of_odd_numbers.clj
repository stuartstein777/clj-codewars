(ns clj-codewars.7kyu-sum-of-odd-numbers)

;; Sum of odd numbers
; Given the triangle of consecutive odd numbers:
;
;             1
;          3     5
;       7     9    11
;   13    15    17    19
;21    23    25    27    29
;...
;
; Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
;
;     (row-sum-odd-numbers 1) # 1
;     (row-sum-odd-numbers 2) # 3 + 5 = 8

(defn row-sum-odd-numbers [x]
  (let [last (+ (* x x) (- x 1))
        start (- last (* 2 (dec x)))]
    (* (/ (+ start last) 2) x)))