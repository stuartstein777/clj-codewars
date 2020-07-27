(ns clj-codewars.8kyu-convert-a-string-to-a-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-convert-a-string-to-a-number :refer :all]))

(deftest examples
  (is (string-to-number "1234") 1234)
  (is (string-to-number "605") 605)
  (is (string-to-number "1405") 1405)
  (is (string-to-number "-7") -7))