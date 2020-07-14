(ns clj-codewars.4kyu
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; Recover a secret string from random triplets
; There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the
; original string.
;
; A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in
; the given string. "whi" is a triplet for the string "whatisup".
;
; As a simplification, you may assume that no letter occurs more than once in the secret string.
;
; You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain
; sufficient information to deduce the original string. In particular, this means that the secret string will never
; contain letters that do not occur in one of the triplets given to you.

(defn remove-last [c m]
  (dissoc (reduce-kv (fn [acc k v] (into acc {k (vec (filter #(not= % c) v))})) {} m) c))

(defn recover-secret [xs]
  (loop [remaining (reduce (fn [acc i]
                             (as-> (update acc (second i)  conj (first i)) o
                                   (update o   (nth i 2)   conj (first i) (second i))
                                   (update o   (first i)   (fnil conj [])))) {} xs)
         result []]
    (let [next ((set/map-invert remaining) [])]
      (cond (nil? next) (apply str result)
            :else (recur (remove-last next remaining) (conj result next))))))
;; -------------------------------------------------

;; Human readable duration format
; Your task in order to complete this Kata is to write a function which formats a duration, given as a number of
; seconds, in a human-friendly way.
;
; The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is
; expressed as a combination of years, days, hours, minutes and seconds.
;
; It is much easier to understand with an example:
;
;     formatDuration (62)    // returns "1 minute and 2 seconds"
;     formatDuration (3662)  // returns "1 hour, 1 minute and 2 seconds"
;
; For the purpose of this Kata, a year is 365 days and a day is 24 hours.
;
;Note that spaces are important.
;Detailed rules
;
; The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of
; the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
;
; The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ",
; just like it would be written in English.
;
; A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is
; not correct, but 1 year and 1 second is.
;
; Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
;
; A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it
; should be just 1 minute.
;
; A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1
; minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid
; more significant unit of time.

(def minute 60)
(def hour (* minute 60))
(def day (* hour 24))
(def year (* day 365))

(defn format-timespan [timespan]
  (cond (= (count timespan) 10) (str (first timespan) " " (second timespan) ", "
                                     (nth timespan 2) " " (nth timespan 3) ", "
                                     (nth timespan 4) " " (nth timespan 5) ", "
                                     (nth timespan 6) " " (nth timespan 7) " and "
                                     (nth timespan 8) " " (nth timespan 9))
        (= (count timespan) 8) (str (first timespan) " " (second timespan) ", "
                                    (nth timespan 2) " " (nth timespan 3) ", "
                                    (nth timespan 4) " " (nth timespan 5) " and "
                                    (nth timespan 6) " " (nth timespan 7))
        (= (count timespan) 6) (str (first timespan) " " (second timespan) ", "
                                    (nth timespan 2) " " (nth timespan 3) " and "
                                    (nth timespan 4) " " (nth timespan 5))
        (= (count timespan) 4) (str (first timespan) " " (second timespan) " and "
                                    (nth timespan 2) " " (nth timespan 3))
        (= (count timespan) 2) (str (first timespan) " " (second timespan))
        (= (count timespan) 0) (str "now")))

(defn format-duration [dur]
  (let [years (/ (- dur (mod dur year)) year)
        minus-years (- dur (* years year))
        days (/ (- minus-years (mod minus-years day)) day)
        minus-days (- minus-years (* days day))
        hours (/ (- minus-days (mod minus-days hour)) hour)
        minus-hours (- minus-days (* hours hour))
        minutes (/ (- minus-hours (mod minus-hours minute)) minute)
        seconds (- minus-hours (* minutes minute))]
    (let [timespan [[years (if (< 1 years) "years" "year")]
                    [days (if (< 1 days) "days" "day")]
                    [hours (if (< 1 hours) "hours" "hour")]
                    [minutes (if (< 1 minutes) "minutes" "minute") ]
                    [seconds (if (< 1 seconds) "seconds" "second")]]
          to-format (vec (flatten (filter #(> (first %) 0) timespan)))]
      (format-timespan to-format))))
;; -------------------------------------------------

;; Strip Comments
; Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any
; whitespace at the end of the line should also be stripped out.
;
; Example:
;
; Given an input string of:
;
;     apples, pears # and bananas
;     grapes
;     bananas !apples
;
; The output expected would be:
;
;     apples, pears
;     grapes
;     bananas
;
; The code would be called like so:
;      var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
;     // result should == "apples, pears\ngrapes\nbananas"

(defn strip-comment [comment-chars line]
  (str/trimr (apply str (take-while #(= nil ((set comment-chars) (str %))) line))))

(defn strip-comments [code comment-chars]
  (->> (str/split code #"\n")
       (map (partial strip-comment comment-chars))
       (map (partial apply str))
       (str/join "\n")))
;; -------------------------------------------------