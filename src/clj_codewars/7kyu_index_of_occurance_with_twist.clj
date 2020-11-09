(ns clj-codewars.7kyu-index-of-occurance-with-twist)

;; Find the index of the first occurrence of an item in a list (with a twist)
;
; Write a function index_finder/index-finder that returns the index of the first occurrence of an item (x) in the list
; (lst), but ignoring the first item in the list. The item will always occur at least once after the first item in the
; list. For example:
;
;   lst = ['a','b','c'], x = 'b' >>> returns 1 ('b' occurs first at position 1)
;   lst = ['b','b','b'], x = 'b' >>> returns 1 ('b' occurs first at position 1 if you ignore index 0)
;   lst = ['b','c','b','a'], x = 'b' >>> returns 2 ('b' occurs first at position 2 if you ignore index 0)
;   lst = [0,2,'a','5',0,1,0], x = 0 >>> returns 4 (0 occurs first at position 4 if you ignore index 0)

(defn index-finder[l xs]
  (inc (.indexOf (rest l) xs)))