(ns clj-codewars.7kyu-fix-string-case
  (:require [clojure.string :as str]))

;; Fix string case
;
; In this Kata, you will be given a string that may have mixed uppercase and lowercase letters and your task
; is to convert that string to either lowercase only or uppercase only based on:
;
;    make as few changes as possible.
;    if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
;
; For example:
;
;   solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
;   solve("CODe") = "CODE". Uppercase characters > lowrecase. Change only the "e" to uppercase.
;   solve("coDE") = "code". Upper == lowercase. Change all to lowercase.

(defn solve [s]
  (let [u (reduce (fn [a c] (+ a (if (Character/isUpperCase c) 1 0))) 0 s)
        l (- (count s) u)]
    (if (> u l) (str/upper-case s)
                (str/lower-case s))))

