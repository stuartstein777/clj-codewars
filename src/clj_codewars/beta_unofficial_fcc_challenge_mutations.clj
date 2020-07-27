(ns clj-codewars.beta-unofficial-fcc-challenge-mutations
  (:require [clojure.set :as set]
            [clojure.string :as str]))

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
