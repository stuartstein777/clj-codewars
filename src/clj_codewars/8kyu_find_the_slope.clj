(ns clj-codewars.8kyu-find-the-slope)

;; Find the Slope
; Given an array of 4 integers
; [a,b,c,d] representing two points (a, b) and (c, d), return a string representation of the slope of the line
; joining these two points.
;
; For an undefined slope (division by 0), return undefined . Note that the "undefined" is case-sensitive.
;
;   a:x1
;   b:y1
;   c:x2
;   d:y2
;
; Assume that [a,b,c,d] and the answer are all integers (no floating numbers!).
; Slope: https://en.wikipedia.org/wiki/Slope

(defn slope [v]
  (let [delta-x (- (nth v 3) (second v))
        delta-y (- (nth v 2) (first v))]
    (if (= 0 delta-y)
      "undefined"
      (str (/ delta-x delta-y)))))
