(ns clj-codewars.beta-unofficial-fcc-challenge-truncate-a-string)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Truncate a String
;; Estimated 7 KYU
; Truncate a string (first argument) if it is longer than the given maximum string length (second argument).
; Return the truncated string with a ... ending.
; Note that inserting the three dots to the end will add to the string length.
; However, if the given maximum string s length n is less than or equal to 3, then the addition of the three dots
; does not add to the string length in determining the truncated string.

(defn truncate-string [s n]
  (let [len (count s)]
    (cond (<= len n) s
          (> len n) (cond (> n 3) (str (subs s 0 (- n 3)) "...")
                          :else (str (subs s 0 n) "...")))))
