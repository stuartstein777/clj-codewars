(ns clj-codewars.8kyu-how-do-i-compare-numbers)

;; How do I compare numbers?
; What could be easier than comparing integer numbers? However, the given piece of code doesn't recognize some of the
; special numbers for a reason to be found. Your task is to find the bug and eliminate it.

(defn what-is [x]
  (cond
    (identical? x 42) "everything"
    (= x (* 42 42)) "everything squared"
    :else "nothing"))
