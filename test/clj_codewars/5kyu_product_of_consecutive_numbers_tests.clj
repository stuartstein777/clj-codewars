(ns clj-codewars.5kyu-product-of-consecutive-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-product-of-consecutive-fib-numbers :refer :all]))

(deftest a-test1
  (testing "Test 1"
    (is (= (product-fib 4895) [55N 89N true]))))
(deftest a-test2
  (testing "Test 2"
    (is (= (product-fib 5895) [89, 144, false]))))