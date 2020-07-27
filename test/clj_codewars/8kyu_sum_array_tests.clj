(ns clj-codewars.8kyu-sum-array-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-sum-arrays :refer :all]))

(deftest Tests-sun-arrays
  (is (= (sum []) 0))
  (is (= (sum [1 2 3]) 6))
  (is (= (sum [1.1 2.2 3.3]) 6.6))
  (is (= (sum '(4 5 6)) 15))
  (is (= (sum (range 101)) 5050)))