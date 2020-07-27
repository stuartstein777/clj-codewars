(ns clj-codewars.8kyu-get-nth-even-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-get-nth-even-number :refer :all]))

(deftest basic-tests-nth-even-number
  (testing "Testing for 1" (is (= (nth-even 1) 0)))
  (testing "Testing for 2" (is (= (nth-even 2) 2)))
  (testing "Testing for 3" (is (= (nth-even 3) 4)))
  (testing "Testing for 100" (is (= (nth-even 100) 198)))
  (testing "Testing for 1298734" (is (= (nth-even 1298734) 2597466))))