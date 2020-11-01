(ns clj-codewars.6kyu-routes-in-a-square-grid)

;; Routes in a square grid
;
; Given a side length n, traveling only right and down how many ways are there to get from the top left corner to the
; bottom right corner of an n by n grid?
;
; Your mission is to write a program to do just that!
;
; Add code to route(n) that returns the number of routes for a grid n by n (if n is less than 1 return 0).
;
; Examples:
;
; -100 -> 0
; 1 -> 2
; 2 -> 6
; 20 -> 137846528820
;
; Note: you're traveling on the edges of the squares in the grid not the squares themselves.

(defn factorial [n]
  (apply *' (range 1 (inc n))))

(defn routes [n]
  (if (neg? n) 0
               (/ (factorial (*' 2 n))
                  (*' (factorial n) (factorial (- (*' 2 n) n))))))