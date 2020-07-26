(ns clj-codewars.6kyu-split-strings)

;; Split Strings
; Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number
; of characters then it should replace the missing second character of the final pair with an underscore ('_').
;
; Examples:
;   (solution "abc") ; => ["ab" "c_"]
;   (solution "abcd") ; => ["ab" "cd"]

(defn split-strings [s]
  (vec (if (not (zero? (mod (count s) 2)))
         (map (partial apply str) (partition-all 2 (str s "_")))
         (map (partial apply str) (partition-all 2 s)))))