(ns clj-codewars.6kyu-moves-in-squared-strings-iii
  (:require [clojure.string :as str]))

(defn diag-1-sym [s]
  (let [rows (str/split s #"\n")
        cnt (count rows)]
    (->> (for [pos (range cnt)] (map #(nth % pos) rows))
         (map (partial apply str)))))

(defn rot-90-clock [strng]
  (map (partial apply str) (map reverse (diag-1-sym strng))))

(defn selfie-and-diag1 [s]
  (let [diag (diag-1-sym s)
        splits (str/split s #"\n")]
    (map #(str %1 "|" %2) splits diag)))

(defn oper [fct s]
  (str/join "\n" (fct s)))