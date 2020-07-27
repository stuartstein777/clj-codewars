(ns clj-codewars.8kyu-even-or-odd)

;; Even or Odd
; Create a function (or write a script in Shell) that takes an integer as an argument and returns "Even" for even
; numbers or "Odd" for odd numbers.

(defn even-or-odd [number]
  (if (even? number) "Even" "Odd"))