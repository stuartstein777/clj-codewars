(ns clj-codewars.7kyu-regexp-basics-is-it-a-letter)

;; Regexp Basics - is it a letter?
; Complete the code which should return true if the given object is a single ASCII letter (lower or upper case), false
; otherwise.

(defn letter? [s]
  (not= nil (re-matches #"[A-Za-z]" s)))
