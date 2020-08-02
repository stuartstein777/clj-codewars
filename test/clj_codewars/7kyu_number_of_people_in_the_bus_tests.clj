(ns clj-codewars.7kyu-number-of-people-in-the-bus-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-number-of-people-in-the-bus :refer :all]))

(deftest basic-tests
  (is (= 5 (number [[10 0] [3 5] [5 8]])))
  (is (= 17 (number [[3 0] [9 1] [4 10] [12 2] [6 1] [7 10]])))
  (is (= 21 (number [[3 0] [9 1] [4 8] [12 2] [6 1] [7 8]]))))