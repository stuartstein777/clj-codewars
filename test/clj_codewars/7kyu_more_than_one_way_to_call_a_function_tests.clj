(ns clj-codewars.7kyu-more-than-one-way-to-call-a-function-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-more-than-one-way-to-call-a-function :refer :all]))

(deftest basic-test-more-than-one-way-to-skin-a-cat
  (testing "two parameters"
    (is (= (sum 5 5) 10)))
  (testing "one parameter"
    (is (= ((sum 5) 5) 10))))
