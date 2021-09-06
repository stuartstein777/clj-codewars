(ns vowel-sort
  (:require [clojure.string :as str]))

(defn sort-vowel [c]
  (let [vowels #{\a \e \i \o \u \A \E \I \O \U}]
    (if (some? (vowels c))
      (str "|" c)
      (str c "|"))))

(defn sort-vowels [s]
  (if (string? s)
    (->> s
         (map sort-vowel)
        (str/join "\n"))
    ""))