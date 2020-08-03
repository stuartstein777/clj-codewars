(ns clj-codewars.6kyu-moves-in-squared-strings-iv
  (:require [clojure.string :as str]))

;; Moves in squared strings (IV)
; You are given a string of n lines, each substring being n characters long: For example:
;
; s = "abcd\nefgh\nijkl\nmnop"
;
; We will study some transformations of this square of strings.
;    Symmetry with respect to the main cross diagonal: diag_2_sym (or diag2Sym or diag-2-sym)
;       diag_2_sym(s) => "plhd\nokgc\nnjfb\nmiea"
;    Counterclockwise rotation 90 degrees: rot_90_counter (or rot90Counter or rot-90-counter)
;       rot_90_counter(s)=> "dhlp\ncgko\nbfjn\naeim"
;    selfie_diag2_counterclock (or selfieDiag2Counterclock or selfie-diag2-counterclock) It is initial string + string obtained by symmetry with respect to the main cross diagonal + counterclockwise rotation 90 degrees .
;       s = "abcd\nefgh\nijkl\nmnop" --> "abcd|plhd|dhlp\nefgh|okgc|cgko\nijkl|njfb|bfjn\nmnop|miea|aeim"
;
;    or printed for the last:
;
; selfie_diag2_counterclock
;     abcd|plhd|dhlp
;     efgh|okgc|cgko
;     ijkl|njfb|bfjn
;     mnop|miea|aeim
;
;#Task:
;    Write these functions diag_2_sym, rot_90_counter, selfie_diag2_counterclock
;
; and
;    high-order function oper(fct, s) where fct is the function of one variable f to apply to the string s
;   (fct will be one of diag_2_sym, rot_90_counter, selfie_diag2_counterclock)
;
; #Examples:
;   = "abcd\nefgh\nijkl\nmnop"
;   oper(diag_2_sym, s) => "plhd\nokgc\nnjfb\nmiea"
;   oper(rot_90_counter, s) => "dhlp\ncgko\nbfjn\naeim"
;   oper(selfie_diag2_counterclock, s) => "abcd|plhd|dhlp\nefgh|okgc|cgko\nijkl|njfb|bfjn\nmnop|miea|aeim"

(defn rot-90-counter [s]
  (->> (str/split s #"\n")
       (apply map vector)
       (reverse)
       (map (partial apply str))))

(defn diag-2-sym [s]
  (->> (str/split s #"\n")
       (apply map vector)
       (map reverse)
       (reverse)
       (map (partial apply str))))

(defn selfie-diag2-counterclock [s]
  (let [s1 (str/split s #"\n")
      s2 (diag-2-sym s)
      s3 (rot-90-counter s)]
    (map (fn [a b c] (str a "|" b "|" c)) s1 s2 s3)))

(defn oper [fct s]
  (str/join "\n" (fct s)))