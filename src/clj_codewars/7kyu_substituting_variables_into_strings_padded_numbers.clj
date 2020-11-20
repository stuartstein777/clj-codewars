(ns clj-codewars.7kyu-substituting-variables-into-strings-padded-numbers)

;; Substituting Variables Into Strings: Padded Numbers
;
; Complete the solution so that it returns a formatted string. The return value should equal "Value is VALUE" where
; value is a 5 digit padded number.
;
; Example:
;   solution(5); // should return "Value is 00005"

(defn solution [n]
  (format "Value is %05d" n))