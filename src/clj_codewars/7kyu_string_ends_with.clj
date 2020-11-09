(ns clj-codewars.7kyu-string-ends-with
  (:require [clojure.string :as str]))

;; String ends with?
;
; Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument
; (also a string).
;
; Examples:
;
;   (solution "abc" "bc") ; returns true
;   (solution "abc" "d'" ; returns false

(defn solution [strng ending]
  (str/ends-with? strng ending))