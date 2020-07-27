(ns clj-codewars.8kyu-century-from-year)

;; Century From Year
; he first century spans from the year 1 up to and including the year 100, The second - from the year 101 up to and
; including the year 200, etc.
;
; Given a year, return the century it is in.
;Input , Output Examples ::
;
;     centuryFromYear(1705)  returns (18)
;     centuryFromYear(1900)  returns (19)
;     centuryFromYear(1601)  returns (17)
;     centuryFromYear(2000)  returns (20)

(defn century [year]
  (loop [yr year
         c 0]
    (if (< yr 100)
      (if (= yr 0)
        c
        (inc c))
      (recur (- yr 100) (inc c)))))