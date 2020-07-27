(ns clj-codewars.7kyu-find-the-kth-element-of-a-list)

;; Find the K'th Element of a List
; Find the K'th element of a list. The first element in the list is number 1.
;
; Example:
;
;   (element-at [1,2,3] 2) ; => 2
;   (element-at "haskell" 5) ; => \e

(defn element-at
  "Find the K'th element of an ISeq"
  [lst n]
  (nth lst (dec n)))
