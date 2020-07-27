(ns clj-codewars.8kyu-function-2-squaring-an-argument-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-function-2-squaring-an-argument :refer :all]))

(deftest testing-squaring-argument
  (is (= (square 2) 4) )
  (is (= (square 3) 9) ))