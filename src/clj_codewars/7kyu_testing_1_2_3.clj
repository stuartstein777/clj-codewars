(ns clj-codewars.7kyu-testing-1-2-3)

;; Testing 1-2-3
; Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
; Write a function which takes a list of strings and returns each line prepended by the correct number.
; The numbering starts at 1. The format is n: string. Notice the colon and space in between.
;
;Examples:
;
;    number(List<string>()) // => List<string>()
;    number(List<string>{"a", "b", "c"}) // => ["1: a", "2: b", "3: c"]

(defn number [lines]
  (loop [numbered []
         to-number lines
         current-line 1]
    (if (empty? to-number)
      numbered
      (recur (conj numbered (str current-line ": " (first to-number))) (rest to-number) (inc current-line)))))
