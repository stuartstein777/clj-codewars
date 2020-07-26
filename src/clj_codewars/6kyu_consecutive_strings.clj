(ns clj-codewars.6kyu-consecutive-strings
  (:require [clojure.string :as str]))

;; Consecutive Strings
; You are given an array(list) strarr of strings and an integer k. Your task is to return the first longest string
; consisting of k consecutive strings taken in the array.
; Example:
;
; longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
; n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
;
; Note
; consecutive strings : follow one after another without an interruption

(defn longest-cons [xs k]
  (if (or (<= k 0)
          (zero? (count xs))
          (> k (count xs)))
    ""
    (->> (map-indexed (fn [ix _] (str/join "" (subvec xs ix (+ ix k)))) (range 0 (inc (- (count xs) k))))
         (sort-by count #(> %1 %2))
         (first))))