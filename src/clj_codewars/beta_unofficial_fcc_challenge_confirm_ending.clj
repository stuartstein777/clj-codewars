(ns clj-codewars.beta-unofficial-fcc-challenge-confirm-ending)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Confirm Ending
;; Estimated 7 KYU
; Check if a string (first argument, s) ends with the given target string (second argument, target).
; This challenge can be solved with the clojure.string/ends-with? function, but for the purpose of this challenge,
; we would like to see you solve this using the subs function or other functions.

(defn confirm-ending [s, target]
  (= target (apply str (drop (- (count s) (count target)) s))))
