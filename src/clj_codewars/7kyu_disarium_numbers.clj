(ns clj-codewars.7kyu-disarium-numbers)

;; Disarium Number (Special Numbers Series #3)
;
; Definition
;
; Disarium number is the number that The sum of its digits powered with their respective positions is
; equal to the number itself.
;
; Task
;
; Given a number, Find if it is Disarium or not .
;
; Notes
;
;    Number passed is always Positive .
;    Return the result as String
;
; Input >> Output Examples
;
; disariumNumber(89) ==> return "Disarium !!"
;
; Explanation:
;
;    Since , 8^1 + 9^2 = 89 , thus output is "Disarium !!"
;
; disariumNumber(564) ==> return "Not !!"
;
; Explanation:
;
; Since , 5^1 + 6^2 + 4^3 = 105 != 564 , thus output is "Not !!"

(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn pow [n pow]
  (reduce * (repeat pow n)))

(defn disarium-number [number]
  (if (= number (as-> (number->digits number) o
                      (map (fn [n e] (pow n e)) o (range 1 (inc (count o))))
                      (reduce + o)))
    "Disarium !!"
    "Not !!"))