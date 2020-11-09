(ns clj-codewars.6kyu-rainfall
  (:require [clojure.string :as str]))

;; Rainfall
;
; data and data1 are two strings with rainfall records of a few cities for months from January to December. The records
; of towns are separated by \n. The name of each town is followed by :.
;
; data and towns can be seen in "Your Test Cases:".
; Task:
;
; function: mean(town, strng) should return the average of rainfall for the city town and the strng data or data1
; (In R and Julia this function is called avg).
; function: variance(town, strng) should return the variance of rainfall for the city town and the strng data or data1.
;
;Examples:
;
;mean("London", data), 51.19(9999999999996)
;variance("London", data), 57.42(833333333374)
;
;Notes:
;
; if functions mean or variance have as parameter town a city which has no records return -1 or -1.0 (depending on
; the language)
;
; Don't truncate or round: the tests will pass if abs(your_result - test_result) <= 1e-2 or
; abs((your_result - test_result) / test_result) <= 1e-6 depending on the language.
;
; A ref: http://www.mathsisfun.com/data/standard-deviation.html
;

(defn parse-rainfall [data city]
  (->> (str/split data #"\n")
       (map #(str/replace % #":" ","))
       (map #(str/split % #","))
       (filter #(= (first %) city))
       (first)
       (rest)
       (map (fn [month] (->> (str/split month #" ")
                             (second)
                             (read-string))))))

(defn mean [city data]
  (let [rainfall (parse-rainfall data city)]
    (if (empty? rainfall)
      -1
      (/ (reduce + rainfall) (count rainfall)))))

(defn variance [city data]
  (let [rainfall (parse-rainfall data city)]
    (if (empty? rainfall)
      -1
      (let [mean (/ (reduce + rainfall) (count rainfall))]
        (/ (->> (map #(* (- % mean) (- % mean)) rainfall)
                (reduce +))
           (count rainfall))))))