(ns clj-codewars.6kyu-reducing-by-steps)

(defn gcdi [a b]
  (loop [a (Math/abs ^long a)
         b (Math/abs ^long b)]
    (if (zero? b)
      a
      (recur b (mod a b)))))

(defn lcmu [a b]
  (/ (* (Math/abs ^long a) (Math/abs ^long b)) (gcdi a b)))

(defn som [x y]
  (+ x y))

(defn maxi [x y]
  (max x y))

(defn mini [x y]
  (min x y))

(defn oper-array [fct arr init]
  (rest (reductions fct init arr)))