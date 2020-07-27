(ns clj-codewars.7kyu-excel-sheet-column-numbers)

;; Excel sheet column numbers
; Write a function
;     titleToNumber(title) or title_to_number(title) or titleToNb title ...
; (depending on the language)
; that given a column title as it appears in an Excel sheet, returns its corresponding column number. All column titles will be uppercase.
; Examples:
;   titleTonumber('A') === 1
;   titleTonumber('Z') === 26
;   titleTonumber('AA') === 27
;
; Note for Clojure:
;   Don't use Java Math/pow (even with bigint) because there is a loss of precision
;   when the length of "title" is growing.
; Write your own function "exp [x n]".

(defn pow [x n]
  (reduce *' (repeat x n)))

(defn title-to-nb [col]
  (reduce + (map-indexed (fn [i a] (* (inc (- (int a) (int \A))) (pow (dec (- (count col) i)) 26))) col)))