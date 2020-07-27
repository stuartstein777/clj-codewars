(ns clj-codewars.7kyu-powers-of-3-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-powers-of-3 :refer :all]))

(deftest largest-power-tests
  (testing "Small cases"
    (is (= (largest-power 2) 0))
    (is (= (largest-power 3) 0))
    (is (= (largest-power 4) 1))
    (is (= (largest-power 5) 1))
    (is (= (largest-power 7) 1)))
  (testing "Large cases"
    (is (= (largest-power 81) 3))
    (is (= (largest-power 82) 4))
    (is (= (largest-power 59049) 9))
    (is (= (largest-power 59050) 10))
    (is (= (largest-power 123456789) 16))
    (is (= (largest-power 987654321) 18)))
  (testing "Edge case"
    (is (= (largest-power 1) -1))))
