(ns clj-codewars.8kyu-no-zeros-for-heros
  (:require [clojure.string :as str]))

;; No zeros for heros
; Numbers ending with zeros are boring.
; They might be fun in your world, but not here.
; Get rid of them. Only the ending ones.
;     1450 -> 145
;     960000 -> 96
;     1050 -> 105
;     -1050 -> -105
;
; Zero alone is fine, don't worry about it. Poor guy anyway

(defn no-boring-zeros [n]
  (if (= 0 n)
    0
    (->> (str n)
         (str/reverse)
         (drop-while #(= \0 %))
         (apply str)
         (str/reverse)
         (Integer/parseInt))))
