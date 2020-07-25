(ns clj-codewars.7KYU-4
  (:require [clojure.string :as str])
  (:import (java.time LocalDate)))

;; Unlucky Days
; Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.
;
;Find the number of Friday 13th in the given year.
;
;Input: Year as an integer.
;
;Output: Number of Black Fridays in the year as an integer.
;
;Examples:
;
;unluckyDays(2015) == 3
;unluckyDays(1986) == 1

(defn get-year [year]
  (if (> 1000 year)
    (str 0 year)
    year))

(defn unlucky-days [year]
  (loop [date (-> (LocalDate/parse (str (get-year year) "-01-01")))
         unlucky 0]
    (let [day (-> date (.getDayOfMonth))
          day-of-week (-> date (.getDayOfWeek) (str))]
      (if (= (inc year) (-> date (.getYear)))
        unlucky
        (if (and (= day 13) (= day-of-week "FRIDAY"))
          (recur (-> date (.plusDays 1)) (inc unlucky))
          (recur (-> date (.plusDays 1)) unlucky))))))
;; -------------------------------------------------

;; Recursion 101
; In this Kata, you will be given two positive integers a and b and your task will be to apply the following operations:
;
; i) If a = 0 or b = 0, return [a,b]. Otherwise, go to step (ii);
; ii) If a ≥ 2*b, set a = a - 2*b, and repeat step (i). Otherwise, go to step (iii);
; iii) If b ≥ 2*a, set b = b - 2*a, and repeat step (i). Otherwise, return [a,b].

(defn recursion-101
  [a b]
  (cond (or (zero? a) (zero? b)) (list a b)
        (>= a (* 2 b)) (recur (- a (* 2 b)) b)
        (>= b (* 2 a)) (recur a (- b (* 2 a)))
        :else (list a b)))
;; -------------------------------------------------

;; Common Substrings
; Given 2 strings, your job is to find out if there is a substring that appears in both strings. You will return true if you find a substring that appears in both strings, or false if you do not. We only care about substrings that are longer than one letter long.
;
;#Examples:
;
;*Example 1*
;SubstringTest("Something","Fun"); //Returns false
;
;*Example 2*
;SubstringTest("Something","Home"); //Returns true
;
; In the above example, example 2 returns true because both of the inputs contain the substring "me".
; (soMEthing and hoME) In example 1, the method will return false because something and fun contain no common
; substrings. (We do not count the 'n' as a substring in this Kata because it is only 1 character long)
;
; #Rules: Lowercase and uppercase letters are the same. So 'A' == 'a'.
; We only count substrings that are > 1 in length.
;
; #Input: Two strings with both lower and upper cases.
; #Output: A boolean value determining if there is a common substing between the two inputs.

(defn common-substrings [str1 str2]
  (->> (partition 2 1 (str/lower-case str1))
       (map (partial apply str))
       (some (partial str/includes? (str/lower-case str2)))
       (nil?)
       (not)))
;; -------------------------------------------------

;; Most valuable character
; In this Kata, you will be given a string and your task is to return the most valuable character. The value of a character is the difference between the index of its last occurrence and the index of its first occurrence. Return the character that has the highest value. If there is a tie, return the lexicographically lowest character. [For Golang return rune]
;
; All inputs will be lower case.
;
; For example:
;   solve('a') = 'a'
;   solve('ab') = 'a'. Last occurrence is equal to first occurrence of each character. Return lexicographically lowest.
;   solve("axyzxyz") = 'x'
;
; More examples in test cases. Good luck!

(defn distance-then-lexicography [[c1 v1] [c2 v2]]
  (let [c (compare v2 v1)]
    (if (zero? c)
      (compare c1 c2) c)))

(defn most-valuable-character [s]
  (->> (map (fn [x] [x (- (str/last-index-of s x) (str/index-of s x))]) s)
       (distinct)
       (sort distance-then-lexicography)
       (ffirst)
       ))
;; -------------------------------------------------

;; A rule of divisibility by 7
; A number m of the form 10x + y is divisible by 7 if and only if x − 2y is divisible by 7. In other words, subtract
; twice the last digit from the number formed by the remaining digits. Continue to do this until a number known to be
; divisible or not by 7 is obtained; you can stop when this number has at most 2 digits because you are supposed to
; know if a number of at most 2 digits is divisible by 7 or not.
;
; The original number is divisible by 7 if and only if the last number obtained using this procedure is divisible by
; 7.
;
; Examples:
;
;   1 - m = 371 -> 37 − (2×1) -> 37 − 2 = 35 ; thus, since 35 is divisible by 7, 371 is divisible by 7.
;
; The number of steps to get the result is 1.
;
;   2 - m = 1603 -> 160 - (2 x 3) -> 154 -> 15 - 8 = 7 and 7 is divisible by 7.
;   3 - m = 372 -> 37 − (2×2) -> 37 − 4 = 33 ; thus, since 33 is not divisible by 7, 372 is not divisible by 7.
;
; The number of steps to get the result is 1.
;
; 4 - m = 477557101->47755708->4775554->477547->47740->4774->469->28 and 28 is divisible by 7, so is 477557101.
;
; The number of steps is 7.
; Task:
; Your task is to return to the function seven(m) (m integer >= 0) an array (or a pair, depending on the language)
; of numbers, the first being the last number m with at most 2 digits obtained by your function (this last m will be
; divisible or not by 7), the second one being the number of steps to get the result.

(defn seven [m]
  (loop [n m
         steps 0]
    (if (< (count (str n)) 3)
      [n steps]
      (recur (- (quot n 10) (*' 2 (mod n 10))) (inc steps)))))
;; -------------------------------------------------

;; GCD Sum
; Given the sum and gcd of two numbers, return those two numbers in ascending order. If the numbers do not exist, return -1, (or NULL in C, tuple (-1,-1) in C#, pair (-1,-1) in C++, array {-1,-1} in Java and Golang).
;
; For example:
; Given sum = 12 and gcd = 4...
;   solve(12,4) = [4,8]. The two numbers 4 and 8 sum to 12 and have a gcd of 4.
;   solve(12,5) = -1. No two numbers exist that sum to 12 and have gcd of 5.
;   solve(10,2) = [2,8]. Note that [4,6] is also a possibility but we pick the one with the lower first element: 2 < 4, so we take [2,8].

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn gcd-sum [s g]
  (let [y (- s g)]
    (if (= g (gcd g y))
      [g y]
      -1)))
;; -------------------------------------------------