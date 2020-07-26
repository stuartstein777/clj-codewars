(ns clj-codewars.6kyu-array-diff)

;; Array.diff
; Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the
; result.
; It should remove all values from list a, which are present in list b.
;   (= (array-diff [1 2] [1]) [2])
; If a value is present in b, all of its occurrences must be removed from the other:
;   (= (array-diff [1,2,2,2,3] [2]) [1,3])

(defn array-diff [a b]
  ((fn [a b diff]
     (if (empty? a)
       diff
       (do (let [x (first a)]
             (if (= nil (some #{x} b))
               (recur (rest a) b (conj diff x))
               (recur (rest a) b diff)))))) a b []))
