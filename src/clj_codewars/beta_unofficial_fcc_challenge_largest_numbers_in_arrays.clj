(ns clj-codewars.beta-unofficial-fcc-challenge-largest-numbers-in-arrays)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting --Largest Numbers in Arrays
;; Estimated 8 KYU
; Return a sequence consisting of the largest number from each provided sub-vector. For simplicity, the provided
; vector will contain exactly 4 sub-vectors.

(defn largest-of-four [xs]
  (map #(apply max %) xs))
