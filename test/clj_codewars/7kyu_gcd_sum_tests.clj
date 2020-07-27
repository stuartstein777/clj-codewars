(ns clj-codewars.7kyu-gcd-sum-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-gcd-sum :refer :all]))

(deftest gcd-sum-tests
  (is (= (gcd-sum 6 3) [3 3]))
  (is (= (gcd-sum 8 2) [2 6]))
  (is (= (gcd-sum 10 3) -1))
  (is (= (gcd-sum 12 4) [4 8]))
  (is (= (gcd-sum 12 5) -1))
  (is (= (gcd-sum 50 10) [10 40]))
  (is (= (gcd-sum 50 4) -1))
  (is (= (gcd-sum 10 5) [5 5]))
  (is (= (gcd-sum 100 5) [5 95]))
  (is (= (gcd-sum 1000 5) [5 995])))
