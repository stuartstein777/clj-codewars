(ns clj-codewars.6kyu-create-phone-number)

;; Create Phone Number
; Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the
; form of a phone number.
; Example:
;
; (create-phone-number [1 2 3 4 5 6 7 8 9 0]) ;; => returns "(123) 456-7890"
;
; The returned format must be correct in order to complete this challenge.
; Don't forget the space after the closing parentheses!

(defn create-phone-number [nums]
  (str  "(" (apply str (take 3 nums)) ") "
        (apply str (subvec nums 3 6)) "-"
        (apply str (subvec nums 6 10))))