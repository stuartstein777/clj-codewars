(ns clj-codewars.7kyu-last)

;; Last
; Find the last element of the given argument(s).
; Examples
;   (last [1, 2, 3, 4]) ; => 4
;   (last "xyz")        ; => \z

(defn last-cw
  "Returns the last element of an ISeq"
  [lst]
  (first (reverse lst)))
