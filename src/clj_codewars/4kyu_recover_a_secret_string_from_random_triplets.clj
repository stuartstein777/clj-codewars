(ns clj-codewars.4kyu-recover-a-secret-string-from-random-triplets
  (:require [clojure.set :as set]))

;; Recover a secret string from random triplets
; There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the
; original string.
;
; A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in
; the given string. "whi" is a triplet for the string "whatisup".
;
; As a simplification, you may assume that no letter occurs more than once in the secret string.
;
; You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain
; sufficient information to deduce the original string. In particular, this means that the secret string will never
; contain letters that do not occur in one of the triplets given to you.

(defn remove-last [c m]
  (dissoc (reduce-kv (fn [acc k v] (into acc {k (vec (filter #(not= % c) v))})) {} m) c))

(defn recover-secret [xs]
  (loop [remaining (reduce (fn [acc i]
                             (as-> (update acc (second i)  conj (first i)) o
                                   (update o   (nth i 2)   conj (first i) (second i))
                                   (update o   (first i)   (fnil conj [])))) {} xs)
         result []]
    (let [next ((set/map-invert remaining) [])]
      (cond (nil? next) (apply str result)
            :else (recur (remove-last next remaining) (conj result next))))))