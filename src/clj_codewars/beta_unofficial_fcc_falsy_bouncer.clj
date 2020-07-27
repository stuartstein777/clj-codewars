(ns clj-codewars.beta-unofficial-fcc-falsy-bouncer)

;; Unofficial FCC Challenge -- Basic Algorithm Scripting -- Falsy Bouncer
; Remove all false'y values from an array.
; False'y values in Clojure are false and nil, everything else is true.

(defn bouncer [xs]
  (remove #(or (false? %) (nil? %)) xs))