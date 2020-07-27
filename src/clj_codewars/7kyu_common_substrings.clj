(ns clj-codewars.7kyu-common-substrings
  (:require [clojure.string :as str]))

;; Common Substrings
; Given 2 strings, your job is to find out if there is a substring that appears in both strings. You will return true if you find a substring that appears in both strings, or false if you do not. We only care about substrings that are longer than one letter long.
;
;#Examples:
;
;*Example 1*
;SubstringTest("Something","Fun"); //Returns false
;
;*Example 2*
;SubstringTest("Something","Home"); //Returns true
;
; In the above example, example 2 returns true because both of the inputs contain the substring "me".
; (soMEthing and hoME) In example 1, the method will return false because something and fun contain no common
; substrings. (We do not count the 'n' as a substring in this Kata because it is only 1 character long)
;
; #Rules: Lowercase and uppercase letters are the same. So 'A' == 'a'.
; We only count substrings that are > 1 in length.
;
; #Input: Two strings with both lower and upper cases.
; #Output: A boolean value determining if there is a common substing between the two inputs.

(defn common-substrings [str1 str2]
  (->> (partition 2 1 (str/lower-case str1))
       (map (partial apply str))
       (some (partial str/includes? (str/lower-case str2)))
       (nil?)
       (not)))
