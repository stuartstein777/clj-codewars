(ns clj-codewars.7kyu-complementary-dna
  (:require [clojure.string :as str]))

;; Complementary DNA
; Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the
; development and functioning of living organisms.
; If you want to know more http://en.wikipedia.org/wiki/DNA
; In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side
; of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or
; there is no DNA at all (again, except for Haskell).
;
;     (is (= (dna-strand "ATTGC") "TAACG"))
;     (is (= (dna-strand "GTAT") "CATA"))

(defn dna-strand [dna]
  (as-> (str/replace dna "A" "t") v
        (str/replace v "T" "a")
        (str/replace v "C" "g")
        (str/replace v "G" "c")
        (str/upper-case v)))
