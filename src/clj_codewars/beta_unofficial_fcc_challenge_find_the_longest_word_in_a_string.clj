(ns clj-codewars.beta-unofficial-fcc-challenge-find-the-longest-word-in-a-string
  (:require [clojure.string :as str]))

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Find the Longest Word in a String
; Return the length of the longest word in the provided sentence.
; Your response should be a number.

(defn find-longest-word [s]
  (->> (str/split s #" ")
       (map count)
       (apply max)))