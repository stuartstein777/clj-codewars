(ns clj-codewars.beta-unofficial-fcc-challenge-seek-and-destroy)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Seek and Destroy
;; Estimated 7 KYU
; You will be provided with an initial vector (the first argument in the destroyer function), followed by one or more
; arguments. Remove all elements from the initial vector that are of the same value as these arguments.

(defn destroyer [xs & args]
  (remove (set args) xs))
