(ns clj-codewars.7kyu-unlucky-days
  (:import (java.time LocalDate)))

;; Unlucky Days
; Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.
;
;Find the number of Friday 13th in the given year.
;
;Input: Year as an integer.
;
;Output: Number of Black Fridays in the year as an integer.
;
;Examples:
;
;unluckyDays(2015) == 3
;unluckyDays(1986) == 1

(defn get-year [year]
  (if (> 1000 year)
    (str 0 year)
    year))

(defn unlucky-days [year]
  (loop [date (-> (LocalDate/parse (str (get-year year) "-01-01")))
         unlucky 0]
    (let [day (-> date (.getDayOfMonth))
          day-of-week (-> date (.getDayOfWeek) (str))]
      (if (= (inc year) (-> date (.getYear)))
        unlucky
        (if (and (= day 13) (= day-of-week "FRIDAY"))
          (recur (-> date (.plusDays 1)) (inc unlucky))
          (recur (-> date (.plusDays 1)) unlucky))))))

