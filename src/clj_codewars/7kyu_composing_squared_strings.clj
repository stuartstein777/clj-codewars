(ns clj-codewars.7kyu-composing-squared-strings
  (:require [clojure.string :as str]))

;; Composing squared strings
;
; A squared string is a string of n lines, each substring being n characters long. We are given two n-squared strings.
; For example:
;
; s1 = "abcd\nefgh\nijkl\nmnop" s2 = "qrst\nuvwx\nyz12\n3456"
;
; Let us build a new string strng of size (n + 1) x n in the following way:
;
; * The first line of strng has the first char of the first line of s1 plus the chars of the last line of s2.
; * The second line of strng has the first two chars of the second line of s1 plus the chars of the penultimate line
;   of s2 except the last char
; * and so on until the nth line of strng has the n chars of the nth line of s1 plus the first char of the first line
;   of s2.
;
; Calling this function compose(s1, s2) we have:
;
;     compose(s1, s2) -> "a3456\nefyz1\nijkuv\nmnopq"
; or printed:
;   abcd    qrst  -->  a3456
;   efgh    uvwx       efyz1
;   ijkl    yz12       ijkuv
;   mnop    3456       mnopq

(defn compose[s1 s2]
  (let [s1 (str/split-lines s1)
        s2 (str/split-lines s2)
        sq (count s1)]
    (->> (map flatten
             (for [r (range 0 sq)]
               [(take (inc r) (nth s1 r)) (take (- sq r) (nth s2 (- sq (inc r))))]))
         (map (partial apply str))
         (str/join "\n"))))