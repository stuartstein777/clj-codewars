(ns clj-codewars.7kyu-balanced-number-special-number-series-1
  (:require [clj-codewars.handy-functions :refer [number->digits]]))

;; Balanced Number (Special Numbers Series #1)
; Definition
;
; Balanced number is the number that * The sum of all digits to the left of the middle digit(s) and the sum of all
; digits to the right of the middle digit(s) are equal*.
; Task
;
; Given a number, Find if it is Balanced or not .

(defn balanced-num
  [num]
  (let [l (count (str num))
        digits (number->digits num)
        n (cond (even? l) (Math/ceil (/ l 2))
                :else (/ l 2))
        left (reduce + (take (dec n) digits))
        right (if (even? l)
                (reduce + (drop (inc n) digits))
                (reduce + (drop n digits)))]
      (if (= left right)
        "Balanced"
        "Not Balanced")))