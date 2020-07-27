(ns clj-codewars.7kyu-average-of-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-average-of-numbers :refer :all]))

(deftest averages-test
  (are [in out] (= (averages in) out)
                '(2 2 2 2 2) '(2.0 2.0 2.0 2.0)
                '(2 -2 2 -2 2) '(0.0 0.0 0.0 0.0)
                '(1 3 5 1 -10) '(2.0 4.0 3.0 -4.5)))
