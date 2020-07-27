(ns clj-codewars.8kyu-function-1-hello-world-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-function-1-hello-world :refer :all]))

(deftest hello-world
  (testing "Is it a function?"
    (is (function? greet-hw) "greet should be a function"))
  (testing "Does it return the correct value?"
    (is (= (greet-hw) "hello world!") "greet should return \"hello world!\"")))