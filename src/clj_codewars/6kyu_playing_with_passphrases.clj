(ns clj-codewars.6kyu-playing-with-passphrases
  (:require [clojure.string :as str]))

;; Playing with passphrases
; Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on but frequently
; they can be guessed due to common cultural references. You can get your passphrases stronger by different means.
; One is the following:
;
; choose a text in capital letters including or not digits and non alphabetic characters,
;
;   1. shift each letter by a given number but the transformed letter must be a letter (circular shift),
;   2. replace each digit by its complement to 9,
;   3. keep such as non alphabetic and non digit characters,
;   4. downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
;   5. reverse the whole result.
;
; #Example:
;   your text: "BORN IN 2015!", shift 1
;
;   1+ 2 + 3 -> "CPSO JO 7984!"
;   4 "CpSo jO 7984!"
;   5 "!4897 Oj oSpC"
;
; With longer passphrases it's better to have a small and easy program. Would you write it?

;; move the character 'c' right by 'n' letters.
;; e.g. c = \a, n = 2, result = \c
;;      c = \a, n = 25, result = \z
;;      c = \a, n = 26, result = \a
(defn circular-shift [n c]
  (if-let [d (cond (<= 97 (int c) 122) 97
                   (<= 65 (int c) 90)  65)]
    (as-> (int c) o
          (- o d)
          (+ n o)
          (mod o 26)
          (+ o d)
          (char o))
    c))

(defn offset-numbers [s]
  (str/replace s #"\d" #(str (- 9 (Integer/parseInt %)))))

(defn play-pass [s n]
  (->> (map identity s)
       (map (partial circular-shift n))
       (map-indexed #(if (odd? %)
                       (str/lower-case (str %2))
                       (str/upper-case (str %2))))
       (str/join #"")
       (offset-numbers)
       (str/reverse)))
