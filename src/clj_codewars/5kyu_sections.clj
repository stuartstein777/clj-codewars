(ns clj-codewars.5kyu-sections)

;; Sections
; Consider the following equation of a surface S: z*z*z = x*x * y*y. Take a cross section of S by a plane P: z = k
; where k is a positive integer (k > 0). Call this cross section C(k).
; Task
; Find the number of points of C(k) whose coordinates are positive integers.
; Examples
;
; If we call c(k) the function which returns this number we have
;
;     c(1) -> 1
;     c(4) -> 4
;     c(4096576) -> 160
;     c(2019) -> 0 which means that no point of C(2019) has integer coordinates.
;
; Notes
;    k can go up to about 10,000,000,000
;    Prolog: the function cis called section.
;    Please could you ask before translating : some translations are already written.

(defn solve [^double n]
  (let [xy (*' n n n)
        s (Math/sqrt xy)]
    (loop [x 1.0 solutions 0]
      (if (> x s)
        solutions
        (if (zero? (mod xy x))
          (let [y (/ xy x)]
            (if (= x y)
              (recur (inc x) (inc solutions))
              (recur (inc x) (+ 2 solutions))))
          (recur (inc x) solutions))))))

(defn sections [n] (solve (Math/sqrt n)))
