(ns clj-codewars.6kyu-difference-of-two-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-difference-of-two :refer :all]))

(deftest difference-of-two-tests
  (testing "Basic tests"
    (is (= [[1 3] [2 4]] (twos-difference [1 2 3 4])))
    (is (= [[1 3] [4 6]] (twos-difference [1 3 4 6])))
    (is (= [[1 3]] (twos-difference [0 3 1 4])))
    (is (= [[1 3] [2 4]] (twos-difference [4 1 2 3])))
    (is (= [[1 3] [3 5] [4 6]] (twos-difference [6 3 4 1 5])))
    (is (= [[1 3] [4 6]] (twos-difference [3 1 6 4])))
    (is (= [[1 3] [3 5] [6 8] [8 10] [10 12] [12 14]] (twos-difference [1 3 5 6 8 10 15 32 12 14 56]))))
  (testing "Edge cases"
    (is (= [] (twos-difference [])))
    (is (= [] (twos-difference [1 4 7 10])))))