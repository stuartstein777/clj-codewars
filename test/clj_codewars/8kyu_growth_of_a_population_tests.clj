(ns clj-codewars.8kyu-growth-of-a-population-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-growth-of-a-population :refer :all]))

(defn test-assert-growth-of-a-population [act exp]
  (is (= act exp)))

(deftest a-test1-growth-of-a-population
  (testing "nb-year"
    (test-assert-growth-of-a-population(nb-year 1500, 5, 100, 5000), 15)
    (test-assert-growth-of-a-population(nb-year 1500000, 2.5, 10000, 2000000), 10)
    (test-assert-growth-of-a-population(nb-year 1500000, 0.25, 1000, 2000000), 94)))


