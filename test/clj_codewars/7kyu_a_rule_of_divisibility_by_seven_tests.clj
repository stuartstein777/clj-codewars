(ns clj-codewars.7kyu-a-rule-of-divisibility-by-seven-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-a-rule-of-divisibility-by-seven :refer :all]))

(deftest a-rule-of-divisibility-by-seven-tests
  (testing "Basic tests"
    (is (= (seven 1603) [7, 2]))
    (is (= (seven 371) [35, 1]))
    (is (= (seven 483) [42, 1]))))
