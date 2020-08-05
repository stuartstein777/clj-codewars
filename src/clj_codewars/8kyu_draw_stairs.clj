(ns clj-codewars.8kyu-draw-stairs
  (:require [clojure.string :as str]))

;; Draw Stairs
;
; Given a number n, draw stairs using the letter "I", n tall and n wide, with the tallest in the top left.
;
; For example n = 3 result in "I\n I\n I", or printed:
;
;I
; I
;  I
;
; Another example, a 7-step stairs should be drawn like this:
;
;I
; I
;  I
;   I
;    I
;     I
;      I

(defn draw-stairs [n]
  (str/join "\n" (for [r (range 0 n)]
                   (str (apply str (repeat r " " )) "I"))))