(ns clj-codewars.7kyu-arithmetic-list)

;; Arithmetic List!
; In this kata, you will write an arithmetic list which is basically a list that contains consecutive terms in the sequence.
; You will be given three parameters :
;
;    first the first term in the sequence
;    c the constant that you are going to ADD ( since it is an arithmetic sequence...)
;    l the number of terms that should be returned
;
; Useful link: Sequence

(defn seqlist
  "Generates consecutive terms in a sequence"
  [first c terms]
  (loop [n first
         res []]
    (if (= n (+ first (* c (dec terms))))
      (conj res n)
      (recur (+ n c) (conj res n)))))
