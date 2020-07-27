(ns clj-codewars.8kyu-you-cant-code-under-pressure-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-you-cant-code-under-pressure :refer :all]))

(deftest testing-double-integer
  (is (= (double-integer 2) 4))
  (is (= (double-integer 4) 8))
  (is (= (double-integer -10) -20))
  (is (= (double-integer 0) 0))
  (is (= (double-integer 100) 200)))
