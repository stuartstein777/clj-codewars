(ns clj-codewars.7kyu-reversing-fun
  (:require [clojure.string :as str]))

;; Reversing fun
; You are going to be given a string. Your job is to return that string in a certain order that I will explain below:
;
; Let's say you start with this: 012345
;
; The first thing you do is reverse it:543210
; Then you will take the string from the 1st position and reverse it again:501234
; Then you will take the string from the 2nd position and reverse it again:504321
; Then you will take the string from the 3rd position and reverse it again:504123
;
; Continue this pattern until you have done every single position, and then you will return the string you have
; created. For this particular number, you would return:504132
;
; #Input: A string of length 1 - 1000
; #Output: A correctly reordered string.

(defn reverse-fun [s]
  (let [l (take (Math/ceil (/ (count s) 2)) (str/reverse s))
        r (take (Math/floor (/ (count s) 2)) s)
        res (apply str (interleave l r))]
    (if (odd? (count s))
      (str res (last l))
      res)))