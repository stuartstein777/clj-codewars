(ns clj-codewars.5kyu-number-of-trailing-zeros-of-n-factorial-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-number-of-trailing-zeros-of-n-factorial :refer :all]))

(deftest number-of-trailing-zeros-of-n
  (is (= (zeros 0) 0) "Zero has 0 trailing zeros")
  (is (= (zeros 6) 1))
  (is (= (zeros 30) 7)))