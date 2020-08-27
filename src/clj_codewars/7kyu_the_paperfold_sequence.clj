(ns clj-codewars.7kyu-the-paperfold-sequence)

(defn fold-step [xs]
  (repeat (interleave [0] (cycle [1 0]) xs)))

(repeat (interleave [0] (cycle [1 0]) [1]))

(defn paper-fold []
  (cycle (fold-step [1])))

(take 40 paper-fold)

(fold-step [1 1 0 1 1 0 0])

(def fib-seq-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))
   0 1))

(take 5 fib-seq-seq)

(defn paper-fold []
  ((fn step [xs]
     (lazy-seq [(interleave (repeat (count xs) [1 0]) xs) 0]))
   [1]))

(take 5 paper-fold)

(defn fold-step [xs]
  (if (seq xs)
    (lazy-seq (flatten [(interleave (flatten (repeat (count xs) [1 0])) xs) 0]))
    [1]))

(fold-step [1 1 0])

(defn foo-step [n]
  )

(defn foo []
  ((fn [x] iterate inc x) 0))

(take 5 foo)

