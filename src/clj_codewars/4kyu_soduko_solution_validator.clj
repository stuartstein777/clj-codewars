(ns clj-codewars.4kyu-soduko-solution-validator
  (:require [clojure.set :as set]))

(defn board-pos [x y board]
  (nth (nth board x) y))

(defn valid-solution [b]
  (and
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
         (every? #(= #{} (set/difference (set (range 1 10)) %))))))