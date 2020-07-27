(ns clj-codewars.7kyu-unpacking-arguments-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-unpacking-arguments :refer :all]))

(deftest examples
  (is (= (spread-cw + [1 2 3 4 5]) 15), "Spread isn't working!"))