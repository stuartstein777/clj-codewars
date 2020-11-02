(ns clj-codewars.5kyu-common-denominators
  (:require [clj-codewars.handy-functions :as helpers]))

;; Common denominators
; You will have a list of rationals in the form
;  [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
;
;  where all numbers are positive ints.
;
; You have to produce a result in the form
;  [ (N_1', D) , ... (N_n, D) ]
;
; n which D is as small as possible and
;
; N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
;
;Example:
;
; convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]

(defn convert-fracts [xs]
  (let [numerators (map first xs)
        denoms     (map second xs)
        lcm        (reduce helpers/lcmu denoms)]
    (map (fn [n d] [(* n (quot lcm d)) lcm]) numerators denoms)))