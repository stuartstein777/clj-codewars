(ns clj-codewars.7kyu-form-the-largest)

;; Form the Largest
; Task
;
; Given a number , Return _The Maximum number _ could be formed from the digits of the number given .
; Notes
;
;  * Only Natural numbers passed to the function , numbers Contain digits [0:9] inclusive
;  * Digit Duplications could occur , So also consider it when forming the Largest
;
; Input >> Output Examples:
;
; maxNumber (213) ==> return (321)
;
; Explanation:
;
; As 321 is _The Maximum number _ could be formed from the digits of the number *213*** .

(defn number->digits [num]
  (->> num str (map (comp #(Integer/parseInt %) str))))

(defn max-number [n]
  (->> (number->digits n)
       (sort >)
       (apply str)
       (read-string)))