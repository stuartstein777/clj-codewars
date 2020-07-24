(ns clj-codewars.8kyu-2
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; Number toString
; The code gives an error!
;   (def a (123 toString))
; Fix it!

(def a (str 123))
;; -------------------------------------------END---

;; Century From Year
; he first century spans from the year 1 up to and including the year 100, The second - from the year 101 up to and
; including the year 200, etc.
;
; Given a year, return the century it is in.
;Input , Output Examples ::
;
;     centuryFromYear(1705)  returns (18)
;     centuryFromYear(1900)  returns (19)
;     centuryFromYear(1601)  returns (17)
;     centuryFromYear(2000)  returns (20)

(defn century [year]
  (loop [yr year
         c 0]
    (if (< yr 100)
      (if (= yr 0)
        c
        (inc c))
      (recur (- yr 100) (inc c)))))
;; -------------------------------------------END---

;; Get the mean of an array
; It's the academic year's end, fateful moment of your school report. The averages must be calculated. All the students
; come to you and entreat you to calculate their average for them. Easy ! You just need to write a script.
;
; Return the average of the given array rounded down to its nearest integer.
;
; The array will never be empty.

(defn get-average [marks]
  (quot (reduce + marks) (count marks)))
;; -------------------------------------------END---

;; Calculate average
; Write function avg which calculates average of numbers in given list.

(defn find-average [numbers]
  (/ (reduce + numbers) (count numbers)))
;; -------------------------------------------END---

;; What's up next?
; Given a sequence of items and a specific item in that sequence, return the item immediately following the item
; specified. If the item occurs more than once in a sequence, return the item after the first occurence. This should
; work for a sequence of any type.
;
; When the item isn't present or nothing follows it, the function should return nil in Clojure and Elixir, Nothing in
; Haskell, undefined in JavaScript, None in Python.
;
;     (next-item (range 1 10000) 7) ;=> 8
;     (next-item ["Joe" "Bob" "Sally"] "Bob") ;=> "Sally"

(defn next-item
  "Returns the value that comes after item in xs or nil"
  [xs item]
  (second (drop-while #(not= item %) xs)))
;; -------------------------------------------END---

;; Regex count lowercase letters
; Your task is simply to count the total number of lowercase letters in a string.

(defn lowercase_count[strng]
  (count (re-seq #"[a-z]" strng)))
;; -------------------------------------------END---

;; Localize The Barycenter of a Triangle
; The medians of a triangle are the segments that unit the vertices with the midpoint of their opposite sides. The
; three medians of a triangle intersect at the same point, called the barycenter or the centroid. Given a triangle,
; defined by the cartesian coordinates of its vertices we need to localize its barycenter or centroid.
;
; The function bar_triang() or barTriang or bar-triang, receives the coordinates of the three vertices A, B and C as
; three different arguments and outputs the coordinates of the barycenter O in an array [xO, yO]
;
; This is how our asked function should work: the result of the coordinates should be expressed up to four decimals,
; (rounded result).
; Let's see some cases:
;       bar-triang([4, 6], [12, 4], [10, 10]) ------> [8.6667, 6.6667]
;       bar-triang([4, 2], [12, 2], [6, 10] ------> [7.3333, 4.6667]
;       (bar-triang [0, 0], [1, 6], [8, -6]) ------> [3.0, 0.0]

(defn bar-triang [[a b] [c d] [e f]]
  [(Double/parseDouble (format "%.4f" (double (/ (+ a c e) 3))))
   (Double/parseDouble (format "%.4f" (double (/ (+ b d f) 3))))])
;; -------------------------------------------END---

;; No zeros for heros
; Numbers ending with zeros are boring.
; They might be fun in your world, but not here.
; Get rid of them. Only the ending ones.
;     1450 -> 145
;     960000 -> 96
;     1050 -> 105
;     -1050 -> -105
;
; Zero alone is fine, don't worry about it. Poor guy anyway

(defn no-boring-zeros [n]
  (if (= 0 n)
    0
    (->> (str n)
         (str/reverse)
         (drop-while #(= \0 %))
         (apply str)
         (str/reverse)
         (Integer/parseInt))))
;; -------------------------------------------END---

;; Exclamation marks series #4: Remove all exclamation marks from sentence but ensure a exclamation mark at the end
;; of string
; Remove all exclamation marks from sentence but ensure a exclamation mark at the end of string. For a beginner kata,
; you can assume that the input data is always a non empty string, no need to verify it.
; Examples
;
;     remove("Hi!") === "Hi!"
;     remove("Hi!!!") === "Hi!"
;     remove("!Hi") === "Hi!"
;     remove("!Hi!") === "Hi!"
;     remove("Hi! Hi!") === "Hi Hi!"
;     remove("Hi") === "Hi!"

(defn remove-bang [s]
  (str (apply str (filter #(not= \! %) s))"!"))
;; -------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Reverse a String
; Reverse the provided string.
; Your result must be a string.
; Clojure provides the clojure.string/reverse function, but it has been disabled for this challenge.

(defn reverse-string [s]
  (apply str (reverse (map identity s))))
;; -------------------------------------------END---

;; Rock Paper Scissors
; Let's play! You have to return which player won! In case of a draw return Draw!.
;
; Examples:
;
;     rps('scissors','paper') // Player 1 won!
;     rps('scissors','rock') // Player 2 won!
;     rps('paper','paper') // Draw!

(def beats
  {"rock" "scissors"
   "paper" "rock"
   "scissors" "paper"})

(defn rps [p1 p2]
  (cond (= p1 p2) "Draw!"
        (= (beats p1) p2) "Player 1 won!"
        :else "Player 2 won!"))
;; -------------------------------------------END---

;; Convert number to reversed array of digits
; Convert number to reversed array of digits
; Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
; Example:
;       348597 => [7,9,5,8,4,3]

(defn digitize [n]
  (reverse (map #(Character/digit % 10) (str n))))
;; -------------------------------------------END---

;; Parse nice int from char problem
; Ask a small girl - "How old are you?". She always says strange things... Lets help her!
; For correct answer program should return int from 0 to 9.
; Assume test input string always valid and may look like "1 year old" or "5 years old", etc.. The first char is number
; only.

(defn how-old
  [her-old]
  (Integer/parseInt (str (first her-old))))
;; -------------------------------------------END---
