(ns clj-codewars.7kyu-longest-vowel-chain)

;; Longest Vowel Chain
; The vowel substrings in the word codewarriors are o,e,a,io. The longest of these has a length of 2. Given a
; lowercase string that has alphabetic characters only (both vowels and consonants) and no spaces, return the length of
; the longest vowel substring. Vowels are any of aeiou.

(defn is-vowel [c]
  (not (nil? (#{\a \e \i \o \u} c))))

(defn solve [s]
  (->> (partition-by is-vowel s)
       (filter #(true? (is-vowel (first %))))
       (map count)
       (apply max)))
