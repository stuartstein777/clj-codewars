(ns clj-codewars.8kyu-opposite-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-opposite-number :refer :all]))

(deftest opposite-test
  (is (= (opposite 1) -1)))