(ns clj-codewars.6kyu-bit-counting-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-bit-counting :refer :all]))

(deftest bit-counting-tests
  (testing "0"
    (is (= 0 (count-bits 0))))
  (testing "1"
    (is (= 1 (count-bits 1))))
  (testing "10"
    (is (= 2 (count-bits 10))))
  (testing "14"
    (is (= 3 (count-bits 14))))
  (testing "30"
    (is (= 4 (count-bits 30)))))