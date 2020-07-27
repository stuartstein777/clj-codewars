(ns clj-codewars.8kyu-convert-number-to-reversed-array-of-digits-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-convert-number-to-reversed-array-of-digits :refer :all]))

(deftest digitize-tests
  (is (= (digitize 35231) [1 3 2 5 3])))