(ns clj-codewars.7kyu-special-number)

;; Special Number (Special Numbers Series #5)
;
; Definition
;
; A number is a Special Number if it’s digits only consist 0, 1, 2, 3, 4 or 5
;
; Given a number determine if it special number or not .
; Warm-up (Highly recommended)
; Playing With Numbers Series
; Notes
;
;    The number passed will be positive (N > 0) .
;
;    All single-digit numbers with in the interval [0:5] are considered as special number.
;
; Input >> Output Examples
;
;   specialNumber(2) ==> return "Special!!"
;
; Explanation:
;
; It's a single-digit number within the interval [0:5] .
;
;   specialNumber(9) ==> return "NOT!!"
;
; Explanation:
;
; Although, it's a single-digit number but Outside the interval [0:5] .
;
;   specialNumber(23) ==> return "Special!!"
;
; Explanation:
;
; All the number's digits formed from the interval [0:5] digits .
;
;   specialNumber(39) ==> return "NOT!!"
;
; Explanation:
;
; Although, there is a digit (3) Within the interval But the second digit is not (Must be ALL The
; Number's Digits ) .
;
;    specialNumber(59) ==> return "NOT!!"
;
; Explanation:
;
; Although, there is a digit (5) Within the interval But the second digit is not (Must be ALL The Number's
; Digits ) .
;
;   specialNumber(513) ==> return "Special!!"
;   specialNumber(709) ==> return "NOT!!"

(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn valid-digit? [n]
  (not (nil? (#{0 1 2 3 4 5} n))))

(defn special-number [number]
  (if (every? valid-digit? (number->digits number))
    "Special!!"
    "NOT!!"))

