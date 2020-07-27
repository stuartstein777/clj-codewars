(ns clj-codewars.8kyu-how-good-are-you-really-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-how-good-are-you-really :refer :all]))

(defn assert-equals-2 [act exp]
  (is (= act exp)))

(deftest better_than_average_test
  (testing "Basic Tests"
    (assert-equals-2 (better_than_average [2 3] 5) true)
    (assert-equals-2 (better_than_average [100 40 34 57 29 72 57 88] 75) true)
    (assert-equals-2 (better_than_average [12 23 34 45 56 67 78 89 90] 69) true)))