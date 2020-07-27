(ns clj-codewars.7kyu-sum-of-the-first-nth-terms-of-series-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-sum-of-the-first-nth-terms-of-series :refer :all]))

(deftest sum-first-nth-terms-of-series-tests
  (testing "Test 1"
    (is (= (series-sum 9) "1.77")))
  (testing "Test 2"
    (is (= (series-sum 0) "0.00")))
  (testing "Test 3"
    (is (= (series-sum 15) "1.94"))))
