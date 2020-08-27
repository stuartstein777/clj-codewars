(ns clj-codewars.7kyu-alternating-case
  (:require [clojure.string :as str]))

;; Alternate case
;
; Write function alternateCase which switch every letter in string from upper to lower and from lower to upper.
; E.g: Hello World -> hELLO wORLD

(defn alternate-case [s]
  (->> (map identity s)
       (map (fn [c] (let [i (int c)]
                      (cond (<= 97 i 122) (str/upper-case (str c))
                            (<= 65 i 90) (str/lower-case (str c))
                            :else (str c)))))
       (str/join "")))