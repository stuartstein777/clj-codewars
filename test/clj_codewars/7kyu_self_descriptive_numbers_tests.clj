(ns clj-codewars.7kyu-self-descriptive-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-self-descriptive-numbers :refer :all]))

(deftest test-self-descriptive
  (testing "Basic tests"
    (is (= (self-descriptive? 21200) true))))