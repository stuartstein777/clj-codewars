(ns clj-codewars.6kyu-tortoise-racing)

;; Tortoise Racing
;
; Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour. Young B
; knows she runs faster than A, and furthermore has not finished her cabbage.
;
; When she starts, at last, she can see that A has a 70 feet lead but B's speed is 850 feet per hour. How long
; will it take B to catch A?
;
; More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g
; (integer > 0) how long will it take B to catch A?
;
; The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (round down
; to the nearest second) or a string in some languages.
;
; If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, [] for Kotlin or
; "-1 -1 -1".
;
; Examples:
;
; (form of the result depends on the language)
;
;   race(720, 850, 70) => [0, 32, 18] or "0 32 18"
;   race(80, 91, 37)   => [3, 21, 49] or "3 21 49"

(defn to-time [n]
  "n in seconds to [Hours Minutes Seconds]"
  (let [hours (Math/floor (/ n 3600))
      minutes (Math/floor (/ (- n (* 3600 hours)) 60))
      seconds (- n (* hours 3600) (* minutes 60))]
    [(int hours) (int minutes) (int seconds)]))

(defn race [v1 v2 g]
  (if (> v1 v2)
    nil
    (let [a-speed-ft-per-sec (/ v1 3600)
          b-speed-ft-per-sec (/ v2 3600)
          lead-ft g
          diff-ft-per-sec (- b-speed-ft-per-sec a-speed-ft-per-sec)]
      (->> (Math/floor (/ lead-ft diff-ft-per-sec))
           (to-time)))))