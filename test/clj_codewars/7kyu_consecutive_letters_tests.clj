(ns clj-codewars.7kyu-consecutive-letters-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-consecutive-letters :refer :all]))

(deftest consecutive-letters-tests
  (is (= (consecutive-letters "abc") true))
  (is (= (consecutive-letters "dabc") true))
  (is (= (consecutive-letters "abd") false))
  (is (= (consecutive-letters "v") true))
  (is (= (consecutive-letters "abbc") false)))
