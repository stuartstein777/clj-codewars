(ns clj-codewars.7kyu-maximum-multiple-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-maximum-multiple :refer :all]))

(deftest basic-tests
  (is (= (max-multiple 2 7) 6))
  (is (= (max-multiple 3 10) 9))
  (is (= (max-multiple 7 17) 14))
  (is (= (max-multiple 10 50) 50))
  (is (= (max-multiple 37 200) 185))
  (is (= (max-multiple 7 100) 98)))
