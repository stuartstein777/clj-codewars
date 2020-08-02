(ns clj-codewars.7kyu-balanced-number-sepcial-number-series-1-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-balanced-number-special-number-series-1 :refer :all]))

(deftest test-balanced-number
  (testing "test balanced numbers"
    (is (= "Balanced" (balanced-num 7)))
    (is (= "Balanced" (balanced-num 959)))
    (is (= "Balanced" (balanced-num 13)))
    (is (= "Not Balanced" (balanced-num 432)))
    (is (= "Balanced" (balanced-num 424)))))