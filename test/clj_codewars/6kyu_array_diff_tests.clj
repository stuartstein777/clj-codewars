(ns clj-codewars.6kyu-array-diff-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-array-diff :refer :all]))

(deftest array-diff-tests
  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1,2,2,2,3] [2]) [1,3])))