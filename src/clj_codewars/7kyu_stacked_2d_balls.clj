(ns clj-codewars.7kyu-stacked-2d-balls)

;; Stacked Balls - 2D
;
; I have stacked some pool balls in a triangle.
;
; Like this,
;
;       0
;      0 0
;     0 0 0
;    0 0 0 0
;   0 0 0 0 0
;
; Kata Task
; Given the number of layers of my stack, what is the total height?
; Return the height as multiple of the ball diameter.
; Example
; The image above shows a stack of 5 layers.
; Notes
;    layers >= 0
;    approximate answers (within 0.001) are good enough

(defn ** [n]
  (* n n))

(defn stack-height-2d [n]
  (if (zero? n)
    0
    (+ 1 (Math/sqrt (- (** (- n 1.0))
                       (** (/ (- n 1.0) 2.0)))))))