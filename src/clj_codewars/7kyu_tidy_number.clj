(ns clj-codewars.7kyu-tidy-number)

;; Tidy Number (Special Numbers Series #9)
;
; Definition
; A Tidy number is a number whose digits are in non-decreasing order.
; Task
; Given a number. Find if it is Tidy or not.

(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn tidy-number [n]
  (apply <= (number->digits n)))