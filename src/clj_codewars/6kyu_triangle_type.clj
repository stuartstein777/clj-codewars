(ns clj-codewars.6kyu-triangle-type)

(defn ** [x] (* x x))

; Should return triangle type:
;  0 : if triangle cannot be made with given sides
;  1 : acute triangle
;  2 : right triangle
;  3 : obtuse triangle
(defn triangle-type [a b c]
  (let [sorted (sort [a b c])
        aq (** (first sorted))
        bq (** (second sorted))
        cq (** (last sorted))]
    (if (or (<= (+ a b) c) (<= (+ a c) b) (<= (+ b c) a))
      0
      (cond (> (+ aq bq) cq) 1
            (= (+ aq bq) cq) 2
            :else 3))))