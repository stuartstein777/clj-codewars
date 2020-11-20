(ns clj-codewars.7kyu-reversed-words
  (:require [clojure.string :as str]))

;; Reversed Words
;
; Complete the solution so that it reverses all of the words within the string passed in.
;
;Example:
;
;solution("The greatest victory is that which requires no battle")
;# should return "battle no requires which that is victory greatest The"

(defn reverse-words [words]
  (->> (str/split words #" ")
       (reverse)
       (str/join " ")))