(ns clj-codewars.7kyu-see-you-next-happy-year)

;; See You Next Happy Year
;
; Scenario
;
; You're saying good-bye your best friend , See you next happy year .
;
; Happy Year is the year with only distinct digits , (e.g) 2018
; Task
;
; Given a year, Find The next happy year or The closest year You'll see your best friend

(defn number->digits [num]
  (->> num str (map (comp #(Integer/parseInt %) str))))

(defn next-happy-year [year]
  (let [year (inc year)
        year-digits (number->digits year)
        distinct-digits (->> year-digits
                             (distinct)
                             (count))]
    (if (= (count year-digits) distinct-digits)
      year
      (recur year))))

