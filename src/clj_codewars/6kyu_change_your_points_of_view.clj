(ns clj-codewars.6kyu-change-your-points-of-view)

;; Change your Points of View
; We want to define the location x, y of a point on a two-dimensional plane where x and y are positive integers.
; Our definition of such a point will return a function (procedure). There are several possible functions to do that.
; Possible form of point:
; Of course we need to be able to extract from our point the two coordinates x and y.
; The function fst must return the first element x and our function snd must return the second element y.
; We will also write a function sqr-dist which returns the square of the distance between two points point1 and point2.
; Last function to write line:
; ;Given two points foo and bar this function return a list (l m n) or [l, m, n] where l, m, n are the coefficients in
; the general equation l*x + m*y + n = 0 (1) of the straight line through the points foo and bar.
; Equation k*l*x + k*m*y + k*n = 0 is equivalent to (1) and the tests consider that they define the "same" line.

(defn point [a b]
  (fn [] [a b]))

(defn fst [point]
  (first (point)))

(defn snd [point]
  (second (point)))

(defn sqr-dist [point1 point2]
  (let [delta-x (Math/abs (- (fst point2) (fst point1)))
        delta-y (Math/abs (- (snd point2) (snd point1)))]
    (+ (* delta-x delta-x) (* delta-y delta-y))))

(defn line [foo bar]
  [(- (snd foo) (snd bar))
   (- (fst bar) (fst foo))
   (- (* (fst foo) (snd bar))
      (* (snd foo) (fst bar)))])

