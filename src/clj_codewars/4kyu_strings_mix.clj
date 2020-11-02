(ns clj-codewars.4kyu-strings-mix
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account
;; the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.
;
;   s1 = "A aaaa bb c"
;   s2 = "& aaa bbb c d"
;
; s1 has 4 'a', 2 'b', 1 'c'
;
; s2 has 3 'a', 3 'b', 1 'c', 1 'd'
;
; So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not
; consider letters when the maximum of their occurrences is less than or equal to 1.
;
; We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for
; string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the
; maximum for b is 3.
;
; The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if
; this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear
; with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.
;
; In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing
; order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".
;
; Hopefully other examples can make this clearer.
;
;   s1 = "my&friend&Paul has heavy hats! &"
;   s2 = "my friend John has many many friends &"
;   mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
;
;   s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
;   s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
;   mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
;
;   s1="Are the kids at home? aaaaa fffff"
;   s2="Yes they are here! aaaaa fffff"
;   mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"


(defn repeat-char-count-times [count char]
  (apply str (repeat count char)))

(defn get-lower-case-chars [s]
  (apply str (re-seq #"[a-z]+" s)))

(defn get-frequencies-of-common-chars [common-chars s]
  (->> (frequencies s)
       (filter (fn [i] (some common-chars i)))))

(defn comparer [[count-a str-a a] [count-b str-b b]]
  (cond (= count-a count-b)
        (cond (= a b)
              (< (int str-a) (int str-b))
              (> a b) 1
              :else -1)
        (> count-a count-b) -1
        :else 1))

(defn pre-to-string [pre]
  (cond (= 10 pre) "=:"
        (= 1 pre) "1:"
        :else "2:"))

(defn item-to-result-string [[count chr pre]]
  (str (pre-to-string pre) (repeat-char-count-times count chr)))

(defn char-frequencies->map [cf]
  (zipmap (map first cf) (map second cf)))

(defn mix-items [fs1 fs2 chr]
  (let [fs1-count (fs1 chr 0)
        fs2-count (fs2 chr 0)]
    (cond (> fs1-count fs2-count) [fs1-count chr 1]
          (= fs1-count fs2-count) [fs1-count chr 10]
          :else [fs2-count chr 2])))

(defn mix [s1 s2]
  (let [ss1 (get-lower-case-chars s1)
        ss2 (get-lower-case-chars s2)
        common-chars (set/union (set ss1) (set ss2))
        fs1 (->> (get-frequencies-of-common-chars common-chars ss1)
                 (sort-by first)
                 (char-frequencies->map))
        fs2 (->> (get-frequencies-of-common-chars common-chars ss2)
                 (sort-by first)
                 (char-frequencies->map))]
    (->> common-chars
         (map (partial mix-items fs1 fs2))
         (filter (fn [[cnt _ _]] (> cnt 1)))
         (sort comparer)
         (map item-to-result-string)
         (str/join #"/"))))