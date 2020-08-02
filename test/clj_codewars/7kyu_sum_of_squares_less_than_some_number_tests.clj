(ns clj-codewars.7kyu-sum-of-squares-less-than-some-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-sum-of-squares-less-than-some-number :refer [get-number-of-squares]]))

(deftest example-tests
  (are [n answer] (= (get-number-of-squares n) answer)
                  1 0
                  2 1
                  5 1
                  6 2
                  15 3
                  50 4
                  100 6
                  1000 13
                  10000 30
                  100000 66
                  1000000 143
                  ))
