(ns clj-codewars.7kyu-simple-fun-74-growing-plant-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-simple-fun-74-growing-plant :refer :all]))

(deftest growing-plant-tests
  (is (= (growing-plant 100 10 910) 10))
  (is (= (growing-plant 10 9 4) 1))
  (is (= (growing-plant 5 2 5) 1))
  (is (= (growing-plant 5 2 6) 2)))