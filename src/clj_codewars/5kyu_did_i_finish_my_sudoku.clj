(ns clj-codewars.5kyu-did-i-finish-my-sudoku
  (:require [clojure.set :as set]))

;; Did I Finish my Sudoku
;
; Write a function done_or_not/DoneOrNot passing a board (list[list_lines]) as parameter. If the board is valid return
; 'Finished!', otherwise return 'Try again!'
;
; Sudoku rules:
;
; Complete the Sudoku puzzle so that each and every row, column, and region contains the numbers one through nine only
; once.

(defn board-pos [x y board]
  (nth (nth board x) y))

(defn done-or-not [b]
  (if (and
        (->> (map #(into #{} %) b)
             (every? #(= #{} (set/difference (set (range 1 10)) %))))

        (->> (map (fn [x] (map (fn [y] (nth (nth b y) x)) (range 0 9))) (range 0 9))
             (every? #(= #{} (set/difference (set (range 1 10)) %))))

        (->> (map (fn [x] (map (fn [y] (into #{} [(board-pos x y b) (board-pos (inc x) y b) (board-pos (+ 2 x) y b)
                                                  (board-pos x (inc y) b) (board-pos (inc x) (inc y) b) (board-pos (+ 2 x) (inc y) b)
                                                  (board-pos x (+ 2 y) b) (board-pos (inc x) (+ 2 y) b) (board-pos (+ 2 x) (+ 2 y) b)]))
                               (range 0 9 3)))
                  (range 0 9 3))
             (flatten)
             (every? #(= #{} (set/difference (set (range 1 10)) %)))))
    "Finished!"
    "Try again!"))