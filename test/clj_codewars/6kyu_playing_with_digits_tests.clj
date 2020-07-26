(ns clj-codewars.6kyu-playing-with-digits-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-playing-with-digits :refer :all]))

(deftest playing-with-digits-tests
  (testing "Test1"
    (is (= (dig-pow 89 1) 1)))
  (testing "Test2"
    (is (= (dig-pow 92 1) -1))))
