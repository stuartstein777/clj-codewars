(ns clj-codewars.7kyu-find-the-vowels)

;; Find the vowels
; We want to know the index of the vowels in a given word, for example, there are two vowels in the word super (the second and fourth letters).
; So given a string "super", we should return a list of [2, 4].
; Some examples:
;   Mmmm  => []
;   Super => [2,4]
;   Apple => [1,5]
;   YoMama -> [1,2,4,6]
; *NOTE: Vowels in this context refers to English Language Vowels - a e i o u y *
; NOTE: this is indexed from [1..n] (not zero indexed!)

(defn is-vowel? [x]
  (not= nil (#{\a \e \i \o \u \y \A \E \I \O \U \Y} x)))

(defn vowel-indices [word]
  ((fn [word indices idx]
     (if (empty? word)
       indices
       (if (is-vowel? (first word))
         (recur (rest word) (conj indices (inc idx)) (inc idx))
         (recur (rest word) indices (inc idx))))) word [] 0))
