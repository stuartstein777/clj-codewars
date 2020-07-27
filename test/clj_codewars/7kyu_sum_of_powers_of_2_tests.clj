(ns clj-codewars.7kyu-sum-of-powers-of-2-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-sum-of-powers-of-2 :refer :all]))

(defn tester-sum-of-powers-of-2 [n exp]
  (testing (str "Testing for " n)
    (is (= (powers n) exp))))

(deftest example-tests-sum-of-powers-of-2
  (tester-sum-of-powers-of-2 1 [1])
  (tester-sum-of-powers-of-2 2 [2])
  (tester-sum-of-powers-of-2 6 [2 4]))
