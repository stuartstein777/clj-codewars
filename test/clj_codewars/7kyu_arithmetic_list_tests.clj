(ns clj-codewars.7kyu-arithmetic-list-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-arithmetic-list :refer :all]))

(deftest test-last-function
  (are [x y] (= x y)
             (seqlist 0 1 20) [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]))