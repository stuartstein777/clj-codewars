(ns clj-codewars.8kyu-sort-and-star)

;; Sort and Star
; You will be given an vector of string(s). You must sort it alphabetically (case-sensitive, and based on the ASCII
; values of the chars) and then return the first value.
; The returned value must be a string, and have "***" between each of its letters.
; You should not remove or add elements from/to the array.

(defn star-sort [arr]
  (apply str (interpose "***" (first (sort arr)))))
