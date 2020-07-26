(ns clj-codewars.6kyu-detect-pangram
  (:require [clojure.string :as str]))

;; Detect Pangram
; A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
; "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is
; irrelevant).
;
; Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and
; punctuation.

(defn pangram?
  [s]
  (= (count (->> (str/lower-case s)
                 (re-seq #"[A-Za-z]")
                 (set))) 26))
