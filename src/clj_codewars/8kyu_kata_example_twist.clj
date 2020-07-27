(ns clj-codewars.8kyu-kata-example-twist)

;; Kata Example Twist
; This is an easy twist to the example kata (provided by Codewars when learning how to create your own kata).
;
; Add the value "codewars" to the array websites/Websites 1,000 times.
;
; (defn websites [])

(def websites
  (repeat 1000 "codewars"))