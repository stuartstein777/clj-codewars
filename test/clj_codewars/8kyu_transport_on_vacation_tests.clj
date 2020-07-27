(ns clj-codewars.8kyu-transport-on-vacation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-transport-on-vacation :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "rental-car-cost"
    (test-assert (rental-car-cost  1) 40)
    (test-assert (rental-car-cost  3) 100)
    (test-assert (rental-car-cost  8) 270)))