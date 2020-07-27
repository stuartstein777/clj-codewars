(ns clj-codewars.beta-unofficial-fcc-challenge-check-for-palindromes
  (:require [clojure.string :as str]))

; ;Unofficial FCC Challenge -- Basic Algorithm Scripting -- Check for Palindromes
;; Estimated 7 KYU
; Return true if the given string is a palindrome. Otherwise, return false.
; A palindrome is a word or sentence that's spelled the same way both forward and backward, ignoring punctuation,
; case, and spacing.
; Note You'll need to remove all non-alphanumeric characters (punctuation, spaces and symbols) and turn everything
; lower case in order to check for palindromes.
; We'll pass strings with varying formats, such as "racecar", "RaceCar", and "race CAR" among others.
; We'll also pass strings with special symbols, such as "2A3*3a2", "2A3 3a2", and "2_A3*3#A2".

(defn palindrome? [xs]
  (let [valid-chars #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z
                      \1 \2 \3 \4 \5 \6 \7 \8 \9 \0}
        stripped (filter valid-chars (str/lower-case xs))]
    (= stripped (reverse stripped))))

