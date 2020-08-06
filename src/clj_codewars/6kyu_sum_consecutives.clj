(ns clj-codewars.6kyu-sum-consecutives)

;; Sum consecutives
;
; You are given a list/array which contains only integers (positive and negative). Your job is to sum only the numbers that are the same and consecutive. The result should be one list.
; Extra credit if you solve it in one line. You can assume there is never an empty list/array and there will always be an integer.
;
; Same meaning: 1 == 1
;   1 != -1
;
; #Examples:
;
; [1,4,4,4,0,4,3,3,1] # should return [1,12,0,4,6,1]
;

(defn sum-consecutives [a]
  (map (partial reduce +) (partition-by identity a)))