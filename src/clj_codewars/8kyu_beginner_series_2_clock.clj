(ns clj-codewars.8kyu-beginner-series-2-clock)

;; Beginner Series #2 Clock
;
; Clock shows 'h' hours, 'm' minutes and 's' seconds after midnight.
;
; Your task is to make 'Past' function which returns time converted to milliseconds.
; Example:
;   (= (past 0 1 1) 61000)
; Input constraints: 0 <= h <= 23, 0 <= m <= 59, 0 <= s <= 59
;

(defn past [h m s]
  (+ (* 1000 s) (* 60000 m) (* 3600000 h)))