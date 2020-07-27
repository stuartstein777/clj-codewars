(ns clj-codewars.7kyu-sum-of-odd-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-sum-of-odd-numbers :refer :all]))

(deftest sum-of-odd-numbers-tests
  (is (= 1 (row-sum-odd-numbers 1)))
  (is (= 125 (row-sum-odd-numbers 5)))
  (is (= 343 (row-sum-odd-numbers 7))))