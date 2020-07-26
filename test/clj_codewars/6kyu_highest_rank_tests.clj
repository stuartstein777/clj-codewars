(ns clj-codewars.6kyu-highest-rank-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-highest-rank :refer :all]))

(deftest highest-rank-an-array
  (is (= (highest-rank [12 10 8 12 7 6 4 10 12]) 12))
  (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10]) 10))
  (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12]) 12))
  (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12, 14, 14, 14, 14]) 14)))
