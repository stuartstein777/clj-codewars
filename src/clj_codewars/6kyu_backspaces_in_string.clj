(ns clj-codewars.6kyu-backspaces-in-string
  (:require [clojure.string :as str]))

;; Backspaces in string
;
; Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
; Your task is to process a string with "#" symbols.
; Examples
;
;   "abc#d##c"      ==>  "ac"
;   "abc##d######"  ==>  ""
;   "#######"       ==>  ""
;   ""              ==>  ""

(defn clean-string [s]
  (->> (reduce (fn [acc i]
                 (if (= \# i)
                   (vec (butlast acc))
                   (vec (conj acc i))
                   )) [] s)
       (str/join "")))