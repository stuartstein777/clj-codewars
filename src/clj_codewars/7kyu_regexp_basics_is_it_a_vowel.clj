(ns clj-codewars.7kyu-regexp-basics-is-it-a-vowel)

;; Regexp Basics - is it a vowel?
; Implement the function which should return true if given object is a vowel (meaning a, e, i, o, u), and false
; otherwise.

(defn vowel[str]
  (not= nil (#{"a" "e" "i" "o" "u" "A" "E" "I" "O" "U"} str)))