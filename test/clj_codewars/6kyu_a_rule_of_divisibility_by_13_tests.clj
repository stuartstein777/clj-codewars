(ns clj-codewars.6kyu-a-rule-of-divisibility-by-13-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-a-rule-of-divisibility-by-13 :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "thirt"
    (test-assert(thirt 8529), 79)
    (test-assert(thirt 85299258), 31)
    (test-assert(thirt 5634), 57)
    (test-assert(thirt 1111111111), 71)
    (test-assert(thirt 987654321), 30)))