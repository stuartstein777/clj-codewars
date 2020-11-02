(ns clj-codewars.6kyu-vector-affinity)

;; Vector affinity
; Calculate the number of items in a vector that appear at the same index in each vector, with the same value.
;
;  (vector-affinity [1 2 3 4 5] [1 2 2 4 3]) ; => 0.6
;  (vector-affinity [1 2 3] [1 2 3]) ; => 1.0
;
; Affinity value should be realized on a scale of 0.0 to 1.0, with 1.0 being absolutely identical. Two identical sets
; should always be evaulated as having an affinity or 1.0.

(defn get-common-count [xs ys cnt]
  (if (or (empty? xs) (empty? ys))
    cnt
    (recur (rest xs) (rest ys) (if (= (first xs) (first ys)) (inc cnt) cnt))))

(defn vector-affinity [xs ys]
  (if (and (empty? xs) (empty? ys))
    1.0
    (float (/ (get-common-count xs ys 0) (max (count xs) (count ys))))))