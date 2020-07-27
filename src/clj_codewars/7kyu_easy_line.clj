(ns clj-codewars.7kyu-easy-line)

;; Easy Line
; We want to calculate the sum of the squares of the binomial coefficients on a given horizontal line in a pascals
; triangle with a function called easyline (or easyLine or easy-line).
;
; Can you write a program which calculate easyline(n) where n is the horizontal line number?
;
; The function will take n (with: n>= 0) as parameter and will return the sum of the squares of the binomial
; coefficients on line n.
;
;##Examples:
;
;     easyline(0) => 1
;     easyline(1) => 2
;     easyline(4) => 70
;     easyline(50) => 100891344545564193334812497256

(defn easy-line [n]
  (loop [last 1 num n den 1 row [1]]
    (if (= 0 num)
      (reduce #(+ % (* %2 %2)) row)
      (let [current (* last (/ num den))]
        (recur current (dec num) (inc den) (conj row current))))))