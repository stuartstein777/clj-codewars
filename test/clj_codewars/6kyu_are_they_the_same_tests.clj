(ns clj-codewars.6kyu-are-they-the-same-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-are-they-the-same :refer :all]))

(deftest a-test1-are-they-the-same
  (testing "Test 1"
    (def ur [121, 144, 19, 161, 19, 144, 19, 11])
    (def vr [121, 14641, 20736, 361, 25921, 361, 20736, 361])
    (is (= (compSame ur vr) true))))
