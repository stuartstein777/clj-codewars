(ns clj-codewars.8kyu-number-to-string-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-number-to-string :refer :all]))

(deftest number-to-string-test-example
  (is (= (number-to-string 67) "67")))