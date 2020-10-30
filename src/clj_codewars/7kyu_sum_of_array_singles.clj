(ns clj-codewars.7kyu-sum-of-array-singles)

(defn repeats [xs]
  (reduce (fn [acc [val occurrences]]
            (if (= 1 occurrences) (+ acc val) acc)) 0 (frequencies xs)))