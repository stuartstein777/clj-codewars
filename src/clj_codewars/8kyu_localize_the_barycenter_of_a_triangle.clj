(ns clj-codewars.8kyu-localize-the-barycenter-of-a-triangle)

;; Localize The Barycenter of a Triangle
; The medians of a triangle are the segments that unit the vertices with the midpoint of their opposite sides. The
; three medians of a triangle intersect at the same point, called the barycenter or the centroid. Given a triangle,
; defined by the cartesian coordinates of its vertices we need to localize its barycenter or centroid.
;
; The function bar_triang() or barTriang or bar-triang, receives the coordinates of the three vertices A, B and C as
; three different arguments and outputs the coordinates of the barycenter O in an array [xO, yO]
;
; This is how our asked function should work: the result of the coordinates should be expressed up to four decimals,
; (rounded result).
; Let's see some cases:
;       bar-triang([4, 6], [12, 4], [10, 10]) ------> [8.6667, 6.6667]
;       bar-triang([4, 2], [12, 2], [6, 10] ------> [7.3333, 4.6667]
;       (bar-triang [0, 0], [1, 6], [8, -6]) ------> [3.0, 0.0]

(defn bar-triang [[a b] [c d] [e f]]
  [(Double/parseDouble (format "%.4f" (double (/ (+ a c e) 3))))
   (Double/parseDouble (format "%.4f" (double (/ (+ b d f) 3))))])


