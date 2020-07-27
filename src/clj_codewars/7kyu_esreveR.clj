(ns clj-codewars.7kyu-esreveR)

;; esreveR
; Write a function reverse which reverses a list (or in clojure's case, any list-like data structure)
;
; (the dedicated builtin(s) functionalities are deactivated)

(defn esrever
  "Reverse a list"
  [lst]
  ((fn [lst r]
     (if (empty? lst)
       r
       (recur (rest lst) (cons (first lst) r)))) lst []))
