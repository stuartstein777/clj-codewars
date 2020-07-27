(ns clj-codewars.7kyu-beginner-series-5-triangular-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-beginner-series-5-triangular-numbers :refer :all]))

(deftest is-triangular-test
  (testing "Triangular Numbers"
    (is (is-triangular 1)  "Failed when t = 1")
    (is (is-triangular 3)  "Failed when t = 3")
    (is (is-triangular 6)  "Failed when t = 6")
    (is (is-triangular 10) "Failed when t = 10")
    (is (is-triangular 15) "Failed when t = 15")
    (is (is-triangular 21) "Failed when t = 21")
    (is (is-triangular 28) "Failed when t = 28"))
  (testing "Non Triangular Numbers"
    (is (not (is-triangular 2))  "Failed when t = 2")
    (is (not (is-triangular 7))  "Failed when t = 7")
    (is (not (is-triangular 14)) "Failed when t = 14")
    (is (not (is-triangular 27)) "Failed when t = 27")))