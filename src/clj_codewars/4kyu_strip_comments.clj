(ns clj-codewars.4kyu-strip-comments
  (:require [clojure.string :as str]))

;; Strip Comments
; Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any
; whitespace at the end of the line should also be stripped out.
;
; Example:
;
; Given an input string of:
;
;     apples, pears # and bananas
;     grapes
;     bananas !apples
;
; The output expected would be:
;
;     apples, pears
;     grapes
;     bananas
;
; The code would be called like so:
;      var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
;     // result should == "apples, pears\ngrapes\nbananas"

(defn strip-comment [comment-chars line]
  (str/trimr (apply str (take-while #(= nil ((set comment-chars) (str %))) line))))

(defn strip-comments [code comment-chars]
  (->> (str/split code #"\n")
       (map (partial strip-comment comment-chars))
       (map (partial apply str))
       (str/join "\n")))
