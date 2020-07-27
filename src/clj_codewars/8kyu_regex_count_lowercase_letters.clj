(ns clj-codewars.8kyu-regex-count-lowercase-letters)

;; Regex count lowercase letters
; Your task is simply to count the total number of lowercase letters in a string.

(defn lowercase_count[strng]
  (count (re-seq #"[a-z]" strng)))