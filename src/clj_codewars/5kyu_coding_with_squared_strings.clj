(ns clj-codewars.5kyu-coding-with-squared-strings
  (:require [clojure.string :as str]))

;; Coding with Squared Strings
; A squared string has n lines, each substring being n characters long: For example:
;   s = "abcd\nefgh\nijkl\nmnop" is a squared string of size 4.
;
; We will use squared strings to code and decode texts. To make things easier we suppose that our original text doesn't
; include the character '\n'.
;
; Coding
; Input:
;    a text t of length l.
;    Consider the smallest integer n such that n * n be greater or equal to l.
;    Complete t with the char of ascii code 11 (we suppose that this char is not in our original text) until the length
;    of t is n * n.
;    From now on we can transform the new t in a squared string s of size n by inserting '\n' where needed.
;    Apply a clockwise rotation of 90 degrees to s: that's it for the coding part.
;
; Decoding
; Input:
;
;    a squared string s resulting from the coding
;    Apply a counter-clockwise rotation of 90 degrees to s
;    Do some cleaning to have the original text t
;
; You can see clockwise rotation of 90 degrees: http://www.codewars.com/kata/56dbeec613c2f63be4000be6 You can see
; counter-clockwise rotation of 90 degrees: http://www.codewars.com/kata/56dbf59b0a10feb08c000227
; Example:
;
;     t = "I.was.going.fishing.that.morning.at.ten.o'clock"
;     code(t) -> "c.nhsoI\nltiahi.\noentinw\ncng.nga\nk..mg.s\n\voao.f.\n\v'trtig"
;     decode(code(t)) == "I.was.going.fishing.that.morning.at.ten.o'clock"
;
; (Dots indicate spaces since they are quite invisible).

(defn diag-1-sym [s]
  (let [rows (str/split s #"\n")
        cnt (count rows)]
    (->> (for [pos (range cnt)] (map #(nth % pos) rows))
         (map (partial apply str)))))

(defn rot-90-clock [s]
  (map (partial apply str) (map reverse (diag-1-sym s))))

(defn rot-90-counter [s]
  (->> (str/split s #"\n")
       (apply map vector)
       (reverse)
       (map (partial apply str))))

(defn code [s]
  (if (= s "")
    ""
    (let [square (->> (count s)
                      (Math/sqrt)
                      (Math/ceil)
                      (int))
          padding (str s (apply str (repeat (- (* square square) (count s)) "\013")))
          squared-string (apply str (apply concat (interpose [\newline] (partition square padding))))]
      (str/join "\n" (rot-90-clock squared-string)))))

(defn decode [s]
  (if (= s "")
    ""
    (str/join "" (map #(str/replace % #"\013" "") (rot-90-counter s)))))