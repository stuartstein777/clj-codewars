(ns clj-codewars.7kyu-deodorant-evaporator-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-deodorant-evaporator :refer :all]))

(deftest a-test1
  (testing "Test 1"
    (is (= (evaporator 10 10 10) 22))))
