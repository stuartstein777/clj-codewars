(ns clj-codewars.7kyu-last-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-last :refer :all]))

(deftest test-last-function
  (testing "[1 9 13 1 99 9 9 13]"
    (is (= (last-cw [1 9 13 1 99 9 9 13]) 13)))
  (testing "Empty list"
    (is (= (last-cw '()) nil)))
  (testing "String: \"I suppose I should learn Lisp, but it seems so foreign.\" - Paul Graham, Nov 1983"
    (is (= (last-cw "\"I suppose I should learn Lisp, but it seems so foreign.\" - Paul Graham, Nov 1983") \3))))