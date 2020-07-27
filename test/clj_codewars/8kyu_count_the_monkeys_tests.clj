(ns clj-codewars.8kyu-count-the-monkeys-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-count-the-monkeys :refer :all]))

(deftest basic-tests-monkey-counting
  (testing "Testing for 5" (is (= (monkey-count 5) [1 2 3 4 5])))
  (testing "Testing for 3" (is (= (monkey-count 3) [1 2 3])))
  (testing "Testing for 9" (is (= (monkey-count 9) [1 2 3 4 5 6 7 8 9])))
  (testing "Testing for 10" (is (= (monkey-count 10) [1 2 3 4 5 6 7 8 9 10])))
  (testing "Testing for 20" (is (= (monkey-count 20) [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20]))))