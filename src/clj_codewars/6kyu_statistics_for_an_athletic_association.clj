(ns clj-codewars.6kyu-statistics-for-an-athletic-association
  (:require [clojure.string :as str]))

(defn hours->seconds [hours]
  (* 3600 hours))

(defn minutes->seconds [minutes]
  (* 60 minutes))

(defn time-to-seconds [time]
  (let [times-split (->> (str/split time #"\|")
                         (map #(Integer/parseInt %)))
        hours-as-seconds (hours->seconds (first times-split))
        minutes-as-seconds (minutes->seconds (second times-split))
        seconds (last times-split)]
    (+ hours-as-seconds minutes-as-seconds seconds)))

(defn average [times]
  (quot (reduce + times) (count times)))

(defn range [times]
  (- (apply max times) (apply min times)))

(defn median [times]
  (let [number-of-times (count times)]
    (if (odd? number-of-times)
      (nth (sort times) (Math/floor (/ number-of-times 2)))
      (Math/floor (average [(nth (sort times) (dec (/ number-of-times 2.0)))
                                     (nth (sort times) (/ number-of-times 2.0))])))))

(defn seconds->time-string [seconds]
  (let [hours (int (quot seconds 3600))
        minutes (int (quot (- seconds (* 3600 hours)) 60))
        seconds (int (- seconds (* minutes 60) (* hours 60 60)))]
    (str (format "%02d" hours) "|" (format "%02d" minutes) "|" (format "%02d" seconds))))

(defn stat [s]
  (if (= "" s)
    ""
    (let [times (->> (map str/trim (str/split s #","))
                     (map time-to-seconds))]
      (println times)
      (str "Range: " (seconds->time-string (range times))
           " Average: " (seconds->time-string (average times))
           " Median: " (seconds->time-string (median times))))))