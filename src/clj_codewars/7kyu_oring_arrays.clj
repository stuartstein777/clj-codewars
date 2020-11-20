(ns clj-codewars.7kyu-oring-arrays)

;; ORing arrays
;
; It started as a discussion with a friend, who didn't fully grasp some way of setting defaults, but I thought the idea
; was cool enough for a beginner kata: binary OR each matching element of two given arrays (or lists, if you do it in
; Python; vectors in c++) of integers and give the resulting ORed array [starts to sound like a tonguetwister,
; doesn't it?].
;
; If one array is shorter than the other, use the optional third parametero (defaulted to 0) to OR the unmatched elements.
;
; For example:
;
; orArrays([1,2,3],[1,2,3]) === [1,2,3]
; orArrays([1,2,3],[4,5,6]) === [5,7,7]
; orArrays([1,2,3],[1,2]) === [1,2,3]
; orArrays([1,2],[1,2,3]) === [1,2,3]
; orArrays([1,2,3],[1,2,3],3) === [1,2,3]

(defn pad-list [xs def len]
  (concat xs (repeat (- len (count xs)) def)))

(defn or-arrays [a b & [default]]
  (let [default (if (nil? default) 0 default)
        longest (max (count a) (count b))
        xs (pad-list a default longest)
        ys (pad-list b default longest)]
    (map bit-or xs ys)))