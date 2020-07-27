(ns clj-codewars.8kyu-string-repeat)

;; String repeat
; Write a function called repeatString which repeats the given String src exactly count times.
;
; repeatStr(6, "I") // "IIIIII"
; repeatStr(5, "Hello") // "HelloHelloHelloHelloHello"
(defn repeat-str [n strng]
  (apply str (repeat n strng)))