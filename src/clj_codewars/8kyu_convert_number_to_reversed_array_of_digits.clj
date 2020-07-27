(ns clj-codewars.8kyu-convert-number-to-reversed-array-of-digits)

;; Convert number to reversed array of digits
; Convert number to reversed array of digits
; Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
; Example:
;       348597 => [7,9,5,8,4,3]

(defn digitize [n]
  (reverse (map #(Character/digit % 10) (str n))))
