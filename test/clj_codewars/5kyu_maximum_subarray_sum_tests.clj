(ns clj-codewars.5kyu-maximum-subarray-sum-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-maximum-subarray-sum :refer :all]))

(deftest simple-maximum-subarray-sum
  (is (= (max-sequence [-2, 1, -3, 4, -1, 2, 1, -5, 4]) 6)))
