(ns clj-codewars.8kyu-third-angle-of-a-triangle)

;; Third Angle of a Triangle
; You are given two angles (in degrees) of a triangle.
; Write a function to return the 3rd.
; Note: only positive integers will be tested.

(defn third-angle [a b]
  (- 180 a b))
