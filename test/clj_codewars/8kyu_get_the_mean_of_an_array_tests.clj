(ns clj-codewars.8kyu-get-the-mean-of-an-array-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-get-the-mean-of-an-array :refer :all]))

(deftest get-the-mean-of-an-array-tests
  (is (= (get-average [2, 2, 2, 2]) 2))
  (is (= (get-average [1, 5, 87, 45, 8, 8]) 25))
  (is (= (get-average [2,5,13,20,16,16,10]) 11))
  (is (= (get-average [1,2,15,15,17,11,12,17,17,14,13,15,6,11,8,7]) 11)))
