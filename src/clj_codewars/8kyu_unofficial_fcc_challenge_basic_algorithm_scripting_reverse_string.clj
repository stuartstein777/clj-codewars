(ns clj-codewars.8kyu-unofficial-fcc-challenge-basic-algorithm-scripting-reverse-string)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Reverse a String
; Reverse the provided string.
; Your result must be a string.
; Clojure provides the clojure.string/reverse function, but it has been disabled for this challenge.

(defn reverse-string [s]
  (apply str (reverse (map identity s))))