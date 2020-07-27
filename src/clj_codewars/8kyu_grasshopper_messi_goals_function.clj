(ns clj-codewars.8kyu-grasshopper-messi-goals-function)

;; Grasshopper - Messi goals function
; Messi goals function
;
;Messi is a soccer player with goals in three leagues:
;    LaLiga
;    Copa del Rey
;    Champions
; Complete the function to return his total number of goals in all three leagues.
; Note: the input will always be valid.
; For example:
;   5, 10, 2  -->  17

(defn goals [la-liga-goals copa-del-rey-goals champions-league-goals]
  (+ la-liga-goals copa-del-rey-goals champions-league-goals))
