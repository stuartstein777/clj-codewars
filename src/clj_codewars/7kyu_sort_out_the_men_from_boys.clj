(ns clj-codewars.7kyu-sort-out-the-men-from-boys)

;; Sort Out The Men From Boys
; Scenario.
; Men are the Even numbers and Boys are the odd
; Task
; Given an array/list [] of n integers , Separate The even numbers from the odds , or Separate the men from the boys
; Notes
; * Return an array/list where Even numbers come first then odds
; * Since , Men are stronger than Boys , Then Even numbers in ascending order While odds in descending .
; * Array/list size is at least *4*** .
; * Array/list numbers could be a mixture of positives , negatives .
; * Have no fear , It is guaranteed that no Zeroes will exists .
; Repetition of numbers in the array/list could occur , So (duplications are not included when separating).

(defn men-from-boys [arr]
  (let [split ((juxt filter remove) even? (distinct arr))]
    (concat (sort < (first split)) (sort > (second split)))))
