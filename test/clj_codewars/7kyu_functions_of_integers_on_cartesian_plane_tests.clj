(ns clj-codewars.7kyu-functions-of-integers-on-cartesian-plane-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-functions-of-integers-on-cartesian-plane :refer :all]))

(deftest a-test1
  (testing "test1"
    (is (= (sumin 5) 55))))
(deftest a-test4
  (testing "test4"
    (is (= (sumax 8) 372))))
(deftest a-test5
  (testing "test5"
    (is (= (sumsum 8) 576))))