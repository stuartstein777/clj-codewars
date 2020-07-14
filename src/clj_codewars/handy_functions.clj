(ns clj-codewars.handy-functions
  (:require [clojure.string :as str]))

;; Creating a date and adding days to it
(-> (java.time.LocalDate/parse "2016-01-01") (.plusDays 1) str)

;; check
(defn is-vowel [s]
  (not= nil (re-matches #"(?i)[aeiou]" s)))

;; precise pow
(defn int-pow [b ^long ex]
  (loop [acc 1 ex ex]
    (case ex
      0 acc
      (recur (* acc b) (dec ex)))))

;; remove items from list a that are in list b
(defn remove-b-from-a [a b]
  (remove (set b) a))

;; split a string on spaces
(str/split "a b c d e" #"\s+")

;; split a number into a sequence of its digits
(defn number->digits [num]
  (->> num str (map (comp read-string str))))

;; swap two items in a list
(defn swap [v i1 i2]
  (assoc v i2 (v i1) i1 (v i2)))