(ns clj-codewars.7kyu-l2-triple-x
  (:require [clojure.string :as str]))

;; L2: Triple X
;
; Given a string, return true if the first instance of "x" in the string is immediately followed by the string "xx".
;
;tripleX("abraxxxas") → true
;tripleX("xoxotrololololololoxxx") → false
;tripleX("softX kitty, warm kitty, xxxxx") → true
;tripleX("softx kitty, warm kitty, xxxxx") → false
;
;Note :
;
;    capital X's do not count as an occurrence of "x".
;    if there are no "x"'s then return false

(defn triple-x? [s]
  (let [first-x (str/index-of s "x")]
    (if (or (nil? first-x) (>= first-x (- (count s) 2)))
      false
      (= "xxx" (subs s first-x (+ first-x 3))))))