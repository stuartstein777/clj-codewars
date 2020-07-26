(ns clj-codewars.6kyu-mexican-wave
  (:require [clojure.string :as str]))

;; Mexican Wave
; In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be passed a
; string and you must return that string in an array where an uppercase letter is a person standing up.
; Rules
;  	1.  The input string will always be lower case but maybe empty.
;   2.  If the character in the string is whitespace then pass over it as if it was an empty seat.
; Example
;     wave("hello") => []string{"Hello", "hEllo", "heLlo", "helLo", "hellO"}

(defn wave [s]
  (let [l (dec (count s))]
    (loop [res []
           idx 0]
      (cond (> idx l) (filter #(not= s %) (distinct res))
            (= idx 0) (recur (conj res (str (str/upper-case (subs s 0 1)) (subs s 1))) (inc idx))
            (< idx l) (recur (conj res (str (subs s 0 idx) (str/upper-case (subs s idx (inc idx))) (subs s (inc idx)))) (inc idx))
            (= idx l) (recur (conj res (str (subs s 0 idx) (str/upper-case (subs s idx (inc idx))))) (inc idx))))))
