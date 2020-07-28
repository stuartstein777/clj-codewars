(ns clj-codewars.6kyu-prize-draw
  (:require [clojure.string :as str]))

(defn cmp [[a0 a1] [b0 b1]]
  (let [c (compare b0 a0)]
    (if (zero? c)
      (compare a1 b1)
      c)))

(defn name-winning-number [name weight]
  [(->> (str/lower-case name)
        (map #(- (int %) 96))
        (reduce +)
        (+ (count name))
        (* weight)) name])

(defn rank [st we n]
  (let [names (str/split st #",")]
    (cond (= "" st)           "No participants"
          (> n (count names)) "Not enough participants"
          :else               (second (nth (->> (map name-winning-number names we)
                                                (sort cmp))
                                           (dec n))))))