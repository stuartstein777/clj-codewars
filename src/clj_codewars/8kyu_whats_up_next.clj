(ns clj-codewars.8kyu-whats-up-next)

;; What's up next?
; Given a sequence of items and a specific item in that sequence, return the item immediately following the item
; specified. If the item occurs more than once in a sequence, return the item after the first occurence. This should
; work for a sequence of any type.
;
; When the item isn't present or nothing follows it, the function should return nil in Clojure and Elixir, Nothing in
; Haskell, undefined in JavaScript, None in Python.
;
;     (next-item (range 1 10000) 7) ;=> 8
;     (next-item ["Joe" "Bob" "Sally"] "Bob") ;=> "Sally"

(defn next-item
  "Returns the value that comes after item in xs or nil"
  [xs item]
  (second (drop-while #(not= item %) xs)))
