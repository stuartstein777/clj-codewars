(ns clj-codewars.8kyu-is-n-divisible-by-x-and-y-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-is-n-divisible-by-x-and-y :refer :all]))

(defn tester-is-n-divisible-by-x-and-y [a b c exp]
  (testing (str "(isDivisible " a " " b " " c ")")
    (is (= (is-divisible a b c) exp))))

(deftest basic-tests-is-n-divisible-by-x-and-y
  (tester-is-n-divisible-by-x-and-y 3 3 4 false)
  (tester-is-n-divisible-by-x-and-y 12 3 4 true)
  (tester-is-n-divisible-by-x-and-y 8 3 4 false)
  (tester-is-n-divisible-by-x-and-y 48 3 4 true)
  (tester-is-n-divisible-by-x-and-y 100 5 10 true)
  (tester-is-n-divisible-by-x-and-y 100 5 3 false)
  (tester-is-n-divisible-by-x-and-y 4 4 2 true)
  (tester-is-n-divisible-by-x-and-y 5 2 3 false)
  (tester-is-n-divisible-by-x-and-y 17 17 17 true)
  (tester-is-n-divisible-by-x-and-y 17 1 17 true))