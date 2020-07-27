(ns clj-codewars.8kyu-grasshopper-summation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-grasshopper-summation :refer :all]))

(defn tester-1 [n e]
  (testing (str "Testing for " n)
    (is (= (summation n) e))))

(deftest basic-tests-0
  (tester-1 1 1)
  (tester-1 8 36)
  (tester-1 22 253)
  (tester-1 100 5050)
  (tester-1 213 22791))

