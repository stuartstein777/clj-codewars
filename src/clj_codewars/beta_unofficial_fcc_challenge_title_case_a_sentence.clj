(ns clj-codewars.beta-unofficial-fcc-challenge-title-case-a-sentence
  (:require [clojure.string :as str]))

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Title Case a Sentence
;; Estimated 7 KYU
; Return the provided string with the first letter of each word capitalized. Make sure the rest of the word is in
; lower case.
; For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".
; Clojure provides clojure.string/capitalize but it has been disabled for this challenge.

(defn title-case [s]
  (str/join " " (->> (str/split (str/lower-case s) #" ")
                     (map #(str (str/upper-case (str (first %))) (apply str (rest %)))))))