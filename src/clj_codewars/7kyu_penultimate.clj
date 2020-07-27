(ns clj-codewars.7kyu-penultimate)

;; Penultimate
; Find the second-to-last element of a list.
; Example:
;   (penultimate [1,2,3,4])         ; => 3
;   (penultimate "LISP IS AWESOME") ; => \M

(defn penultimate
  "Gets the second to last element of an ISeq"
  [lst]
  (last (butlast lst)))
