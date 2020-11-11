(ns clj-codewars.7kyu-jumping-number)

;; Jumping Number (Special Numbers Series #4)
;
; Definition
;
; Jumping number is the number that All adjacent digits in it differ by 1.
; Task
;
; Given a number, Find if it is Jumping or not .
; Notes
;
;    Number passed is always Positive .
;    Return the result as String .
;    The difference between ‘9’ and ‘0’ is not considered as 1 .
;    All single digit numbers are considered as Jumping numbers.
;
; Input >> Output Examples
;
; jumpingNumber(9) ==> return "Jumping!!"
;
; Explanation:
;
;    It's single-digit number
;
; jumpingNumber(79) ==> return "Not!!"
;
; Explanation:
;
;    Adjacent digits don't differ by 1
;
; jumpingNumber(23) ==> return "Jumping!!"
;
; Explanation:
;
;    Adjacent digits differ by 1
;
; jumpingNumber(556847) ==> return "Not!!"
;
; Explanation:
;
;    Adjacent digits don't differ by 1
;
; jumpingNumber(4343456) ==> return "Jumping!!"
;
; Explanation:
;
;    Adjacent digits differ by 1
;
; jumpingNumber(89098) ==> return "Not!!"
;
; Explanation:
;
;    Adjacent digits don't differ by 1
;
; jumpingNumber(32) ==> return "Jumping!!"
;
; Explanation:
;
;    Adjacent digits differ by 1

(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn jumping-number [n]
  (let [digits (number->digits n)
        jumping? (->> (map (fn [x y] (= 1 (Math/abs (- x y)))) digits (rest digits))
                      (every? true?))]
    (if jumping?
      "Jumping!!"
      "Not!!")))