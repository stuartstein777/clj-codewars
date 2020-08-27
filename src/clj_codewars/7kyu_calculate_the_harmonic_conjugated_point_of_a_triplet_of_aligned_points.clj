(ns clj-codewars.7kyu-calculate-the-harmonic-conjugated-point-of-a-triplet-of-aligned-points)

;; he image shows how we can obtain the Harmonic Conjugated Point of three aligned points A, B, C.
;
;    We choose any point L, that is not in the line with A, B and C. We form the triangle ABL
;
;    Then we draw a line from point C that intersects the sides of this triangle at points M and N respectively.
;
;    We draw the diagonals of the quadrilateral ABNM; they are AN and BM and they intersect at point K
;
;    We unit, with a line L and K, and this line intects the line of points A, B and C at point D
;
; The point D is named the Conjugated Harmonic Point of the points A, B, C. You can get more knowledge related with
; this point at: (https://en.wikipedia.org/wiki/Projective_harmonic_conjugate)
;
; If we apply the theorems of Ceva (https://en.wikipedia.org/wiki/Ceva%27s_theorem) and Menelaus
; (https://en.wikipedia.org/wiki/Menelaus%27_theorem) we will have this formula:
;
;  __ __    __ __
;  AC BD /  AD BC = -1
;
; AC, in the above formula is the length of the segment of points A to C in this direction and its value is:
;
; AC = xA - xC
;
; Transform the above formula using the coordinates xA, xB, xC and xD
;
; The task is to create a function harmon_pointTrip(), that receives three arguments, the coordinates of
; points xA, xB and xC, with values such that : xA < xB < xC, this function should output the coordinates of point
; D for each given triplet, such that
;
; xA < xD < xB < xC, or to be clearer
;
; let's see some cases:
;
; harmon-point-trip(xA, xB, xC) ------> xD # the result should be expressed up to four decimals (rounded result)
; harmon-point-trip(2, 10, 20) -----> 7.1429 # (2 < 7.1429 < 10 < 20, satisfies the constraint)
; harmon-point-trip(3, 9, 18) -----> 6.75

(defn round [n]
  (let [scale (Math/pow 10 4)]
    (/ (Math/round (* n scale))
       scale)))

(defn harmon-point-trip [a b c]
  (round (/ (- (* 2.0 a b)
               (* a c)
               (* b c))
            (- (+ a b)
               (* 2.0 c)))))