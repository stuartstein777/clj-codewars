(ns clj-codewars.7kyu-automorphic-numbers
  (:require [clojure.string :as str]))

;; Automorphic Number (Special Numbers Series #6)
;
; Definition
;
; A number is called Automorphic number if and only if its square ends in the same digits as the number
; itself.
; Task
;
; Given a number determine if it Automorphic or not .

(defn automorphic [n]
  (if (str/ends-with? (str (* n n)) (str n))
    "Automorphic"
    "Not!!"))