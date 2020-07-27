(ns clj-codewars.7kyu-strong-number-special-numbers-series-2)

;; STRONGN Strong Number (Special Numbers Series #2)
; Strong number is the number that the sum of the factorial of its digits is equal to number itself.
; For example: 145, since
;   1! + 4! + 5! = 1 + 24 + 120 = 145
; So, 145 is a Strong number.
; Notes
;  * Number passed is always Positive.
;  * Return the result as String
;
; Input >> Output Examples
; strong_num(1) ==> return "STRONG!!!!"
; Since , the sum of its digits' factorial of (1) is equal to number itself (1) , Then its a Strong .
;
; strong_num(123) ==> return "Not Strong !!"
; Since the sum of its digits' factorial of 1! + 2! + 3! = 9 is not equal to number itself (123) ,
;  Then it's Not Strong.
;
; strong_num(2)  ==>  return "STRONG!!!!"
; Since the sum of its digits' factorial of 2! = 2 is equal to number itself (2) , Then its a Strong .
;
; strong_num(150) ==> return "Not Strong !!"
; Since the sum of its digits' factorial of 1! + 5! + 0! = 122 is not equal to number itself (150),
; Then it's Not Strong .

(defn factorial
  ([n] (factorial n 1))
  ([n sum]
   (cond (= 0 n) sum
         :else (recur (dec n) (* sum n)))))

(defn strong [n]
  (if (= n
         (->> n str
              (map (comp read-string str))
              (map factorial)
              (reduce +)))
    "STRONG!!!!"
    "Not Strong !!"))