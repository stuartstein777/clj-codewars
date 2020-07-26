(ns clj-codewars.5kyu-simple-pig-latin
  (:require [clojure.string :as str]))

;; Simple Pig Latin
; Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
; Examples
;   (piglatin/pig-it "Pig latin is cool") ; "igPay atinlay siay oolcay"
;   (piglatin/pig-it "Hello world !")     ; "elloHay orldway !"


(def letters #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z
               \A \B \C \D \E \F \G \H \I \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z})

(defn to-pig-latin [word]
  (let [a    (take-while letters word)
        punc (apply str (drop (count a) word))]
    (cond (zero? (count a)) word
          :else (str (apply str (rest a)) (str (first a)) "ay" punc))))

(defn pig-it [s]
  (->> (str/split s #" ")
       (map to-pig-latin)
       (str/join " ")))