(ns clj-codewars.6kyu-when-greatest-is-less-than-smallest)

;; When greatest is less than smallest
;
; Given an x and y find the smallest and greatest numbers above and below a given n that are divisible by both x and y.
; Examples
;
; greatest 2 3 20 => 18   ;; 18 is the greatest number under 20 that is divisible by both 2 and 3
; smallest 2 3 20 => 24   ;; 24 is the smallest number above 20 that is divisible by both 2 and 3
;
; greatest 5 15 100 => 90
; smallest 5 15 100 => 105
;
; greatest 123 456 789 => 0   ;; there are no numbers under 789 that are divisible by both 123 and 456
; smallest 123 456 789 => 18696
;
; Notes:
;
;    you should never return n even if it is divisible by x and y always the number above or below it
;    greatest should return 0 if there are no numbers under n that are divisible by both x and y
;    and all arguments will be valid (integers greater than 0).

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn abs [n]
  (if (neg? n)
    (- n)
    n))

(defn lcmu [a b]
  (/ (*' (abs a) (abs b)) (gcd a b)))

(defn greatest [x y n]
  (let [z (lcmu x y)
        r (- (+ z (- n (mod n z))) z)]
    (if (>= r n) 0 r)))

(defn smallest [x y n]
  (let [z (lcmu x y)]
    (+ z (- n (mod n z)))))