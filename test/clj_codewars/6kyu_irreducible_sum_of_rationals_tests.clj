(ns clj-codewars.6kyu-irreducible-sum-of-rationals-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-irreducible-sum-of-rationals :refer :all]))

(deftest a-test1
  (testing "Test1"
    (is (= (sum_fracts [[1, 2], [1, 3], [1, 4]]) [13 12]))))
(deftest a-test2
  (testing "Test2"
    (is (= (sum_fracts [[1, 3], [5, 3]]) 2))))