(ns clj-codewars.6kyu-twisted-sum
  (:require [clj-codewars.handy-functions :refer [number->digits]]))

(defn compute-sum [n]
  (reduce (fn [acc i]
            (+ acc (reduce + (number->digits i)))) (range 1 (inc n))))