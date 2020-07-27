(ns clj-codewars.7kyu-persistent-bugger-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-persistent-bugger :refer :all]))

(deftest persistent-bugger-tests
  (testing "Initial Tests"
    (is (= (persistence 39) 3))
    (is (= (persistence 4) 0))
    (is (= (persistence 25) 2))
    (is (= (persistence 999) 4))))