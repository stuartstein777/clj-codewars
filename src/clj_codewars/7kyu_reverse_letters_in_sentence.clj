(ns clj-codewars.7kyu-reverse-letters-in-sentence)

;; Reverse Letters in Sentence
; Take a sentence (string) and reverse each word in the sentence. Do not reverse the order of the words, just the letters in each word.
; If there is punctuation, it should be interpreted as a regular character; no special rules.
; If there is spacing before/after the input string, leave them there.
; String will not be empty.
; Examples
; "Hi mom" => "iH mom"
; "A fun little challenge! " => " A nuf elttil !egnellahc "

(defn reverser [s]
  (->> (partition-by #(= \space %) s)
       (map #(apply str (reverse %)))
       (apply str)))
