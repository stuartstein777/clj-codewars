(ns clj-codewars.6kyu-most-frequent-weekdays
  (:require [clojure.string :as str]))

;; Most Frequent Weekdays
; What is your favourite day of the week? Check if it's the most frequent day of the week in the year.
;
; You are given a year as integer (e. g. 2001). You should return the most frequent day(s) of the week in that year.
; The result has to be a list of days sorted by the order of days in week (e. g. ['Monday', 'Tuesday'],
; ['Saturday', 'Sunday'], ['Monday', 'Sunday']). Week starts with Monday.
;
; Input: Year as an int.
; Output: The list of most frequent days sorted by the order of days in week (from Monday to Sunday).
;
; Preconditions:
;
;    Week starts on Monday.
;    Year is between 1583 and 4000.
;    Calendar is Gregorian.
;
; Example:
;
;   Kata.MostFrequentDays(2427) == {"Friday"}
;   Kata.MostFrequentDays(2185) == {"Saturday"}
;   Kata.MostFrequentDays(2860) == {"Thursday", "Friday"}

(defn most-frequent-weekdays [year]
  (let [dt (java.time.LocalDate/of year 1 1)
        day-1 (-> dt (.getDayOfWeek) (str))
        day-2 (-> dt (.plusDays 1) (.getDayOfWeek) (str))]
    (if (or (zero? (mod year 400)) (and (zero? (mod year 4)) (not (zero? (mod year 100)))))
      [(str/capitalize day-1) (str/capitalize day-2)]
      [(str/capitalize day-1)])))