(ns clj-codewars.6kyu-lucas-numbers)

;; Lucas numbers
;
; Lucas numbers are numbers in a sequence defined like this:
;
;   L(0) = 2
;   L(1) = 1
;   L(n) = L(n-1) + L(n-2)
;
; Your mission is to complete the function that returns the nth term of this sequence.
;
; Note: It should work for negative numbers as well; how you do this is you flip the equation around, so for
; negative numbers: L(n) = L(n+2) - L(n+1)
; Examples
;
;   L(-10) = 123
;   L(-6)  = L(-4) - L(-5)  = 7 - (-11)= 18 EVEN
;   L(-5)  = L(-3) - L(-4)  = -4 - 7   = -11 ODD
;   L(-4)  = L(-2) - L(-3)  = 3 - (-4) =  7 EVEN
;   L(-3)  = L(-1) - L(-2)  = -1 - 3   = -4 ODD
;   L(-2)  = L(0) - L(-1)   = 2 - (-1) =  3 EVEN
;   L(-1)  =  -1     ODD
;   L(0)   =   2
;   L(1)   =   1
;   L(2)   = L(1) + L(0) =  1 + 2  =   3    +  2
;   L(3)   = L(2) + L(1) =  3 + 1  =   4    +  1
;   L(4)   = L(3) + L(2) =  3 + 4  =   7    +  3
;   L(5)   = L(4) + L(3) =  7 + 4  =  11    +  4
;   L(6)   = L(5) + L(4) = 11 + 7  =  18    +  7
;   L(7)   = L(6) + L(5) = 18 + 11 =  29    + 11
;   L(8)   =                       =  47    + 18
;   L(9)   =                       =  76    + 29
;   L(10)  =                       = 123    + 47

(def lucas-generator
  ((fn lcs [a b]
     (lazy-seq (cons a (lcs b (+' b a))))) 2 1))

(defn lucasnum [n]
  (let [res (first (drop (Math/abs n) lucas-generator))]
    (if (and (neg? n) (odd? (Math/abs n)))
      (- res)
      res)))