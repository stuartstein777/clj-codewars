(ns clj-codewars.beta
  (:require [clojure.set :as set]
            [clojure.string :as str]))

;; Dungeons And Dragons 5th edition leveling utilities
;; Estimated 7 KYU

(def level-requirements {:1 0 :2 300 :3 900 :4 2700 :5 6500 :6 14000 :7 23000 :8 34000 :9 48000 :10 64000
                       :11 85000 :12 100000 :13 120000 :14 140000 :15 165000 :16 195000 :17 225000
                       :18 265000 :19 305000 :20 355000})

(defn- cap-level [level cap]
  (if (> level cap)
    cap
    level))

(defn- level->keyword [level]
  (keyword (str level)))

(defn- cur-level-number [current-xp]
  (cap-level (count (filter #(>= current-xp (second %)) level-requirements)) 20))

(defn- next-level-number [current-xp]
  (cap-level (inc (cur-level-number current-xp)) 20))

(defn current-level [current-xp]
  (level->keyword (cur-level-number current-xp)))

(defn next-level [current-xp]
  (level->keyword (next-level-number current-xp)))

(defn xp-until-next-level [current-xp]
  (let [next-lvl (next-level current-xp)
        cur-level (cur-level-number current-xp)
        target-xp (get level-requirements next-lvl)]
    (if (= cur-level 20)
      0
      (- target-xp current-xp))))
;; -------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Mutations
;; Estimated 7 KYU
; Return true if the string in the first element of the vector contains all of the letters of the string in the second
; element of the vector.
; For example, ["hello", "Hello"], should return true because all of the letters in the second string are present
; in the first, ignoring case.
; The arguments ["hello", "hey"] should return false because the string "hello" does not contain a "y".
; Lastly, ["Alien", "line"], should return true because all of the letters in "line" are present in "Alien".

(defn mutation
  [[a b]]
  (let [set-a (into #{} (str/split (str/lower-case a) #""))
        set-b (into #{} (str/split (str/lower-case b) #""))]
    (empty? (set/difference set-b set-a))))
;; -------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Title Case a Sentence
;; Estimated 7 KYU
; Return the provided string with the first letter of each word capitalized. Make sure the rest of the word is in
; lower case.
; For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".
; Clojure provides clojure.string/capitalize but it has been disabled for this challenge.

(defn title-case [s]
  (str/join " " (->> (str/split (str/lower-case s) #" ")
                     (map #(str (str/upper-case (str (first %))) (apply str (rest %)))))))
;; --------------------------------------------END---

; ;Unofficial FCC Challenge -- Basic Algorithm Scripting -- Check for Palindromes
;; Estimated 7 KYU
; Return true if the given string is a palindrome. Otherwise, return false.
; A palindrome is a word or sentence that's spelled the same way both forward and backward, ignoring punctuation,
; case, and spacing.
; Note You'll need to remove all non-alphanumeric characters (punctuation, spaces and symbols) and turn everything
; lower case in order to check for palindromes.
; We'll pass strings with varying formats, such as "racecar", "RaceCar", and "race CAR" among others.
; We'll also pass strings with special symbols, such as "2A3*3a2", "2A3 3a2", and "2_A3*3#A2".

(defn palindrome? [xs]
  (let [valid-chars #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z
                      \1 \2 \3 \4 \5 \6 \7 \8 \9 \0}
        stripped (filter valid-chars (str/lower-case xs))]
    (= stripped (reverse stripped))))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Seek and Destroy
;; Estimated 7 KYU
; You will be provided with an initial vector (the first argument in the destroyer function), followed by one or more
; arguments. Remove all elements from the initial vector that are of the same value as these arguments.

(defn destroyer [xs & args]
  (remove (set args) xs))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Confirm Ending
;; Estimated 7 KYU
; Check if a string (first argument, s) ends with the given target string (second argument, target).
; This challenge can be solved with the clojure.string/ends-with? function, but for the purpose of this challenge,
; we would like to see you solve this using the subs function or other functions.

(defn confirm-ending [s, target]
  (= target (apply str (drop (- (count s) (count target)) s))))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Truncate a String
;; Estimated 7 KYU
; Truncate a string (first argument) if it is longer than the given maximum string length (second argument).
; Return the truncated string with a ... ending.
; Note that inserting the three dots to the end will add to the string length.
; However, if the given maximum string s length n is less than or equal to 3, then the addition of the three dots
; does not add to the string length in determining the truncated string.

(defn truncate-string [s n]
  (let [len (count s)]
    (cond (<= len n) s
          (> len n) (cond (> n 3) (str (subs s 0 (- n 3)) "...")
                          :else (str (subs s 0 n) "...")))))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting --Largest Numbers in Arrays
;; Estimated 8 KYU
; Return a sequence consisting of the largest number from each provided sub-vector. For simplicity, the provided
; vector will contain exactly 4 sub-vectors.

(defn largest-of-four [xs]
  (map #(apply max %) xs))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Falsy Bouncer
; Remove all false'y values from an array.
; False'y values in Clojure are false and nil, everything else is true.

(defn bouncer [xs]
  (remove #(or (false? %) (nil? %)) xs))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Find the Longest Word in a String
; Return the length of the longest word in the provided sentence.
; Your response should be a number.

(defn find-longest-word [s]
  (->> (str/split s #" ")
       (map count)
       (apply max)))
;; --------------------------------------------END---

;; A function within a function
; Given an input n, write a function always that returns a function which returns n. Ruby should return a lambda or a
; proc.

(defn always [n]
  (fn [] n))
;; --------------------------------------------END---

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Where Do I Belong
; Return the lowest index at which a value (second argument) should be inserted into an vector (first argument) once it
; has been sorted. The returned value should be a number.
;
; For example, getIndexToIns([1,2,3,4], 1.5) should return 1 because it is greater than 1 (index 0), but less than 2
; (index 1).
;
; Likewise, getIndexToIns([20,3,5], 19) should return 2 because once the array has been sorted it will look like
; [3,5,20] and 19 is less than 20 (index 2) and greater than 5 (index 1).

(defn get-index-to-insert [xs x]
  (->> (sort xs)
       (take-while #(< % x))
       (count)))
;; --------------------------------------------END---