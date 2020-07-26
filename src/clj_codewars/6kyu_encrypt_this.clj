(ns clj-codewars.6kyu-encrypt-this
  (:require [clojure.string :as str]))
;; Encrypt this!
; You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
;
;    1. Your message is a string containing space separated words.
;    2. You need to encrypt each word in the message using the following rules:
;       * The first letter needs to be converted to its ASCII code.
;       * The second letter needs to be switched with the last letter
;    3. Keepin' it simple: There are no special characters in input.

(defn encrypt [s]
  (cond (= 1 (count s)) (int (first s))
        (= 2 (count s)) (str (int (first s)) (last s))
        :else           (str (int (first s))
                             (last s)
                             (apply str (rest (butlast (rest s))))
                             (nth s 1))))

(defn encrypt-this [s]
  (->> (str/split s #" ")
       (map encrypt)
       (str/join " ")))