(ns clj-codewars.8kyu-calculate-average-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-calculate-average :refer :all]))

(deftest calculate-average-tests
  (is (= 1 (find-average [1 1 1])))
  (is (= 2 (find-average [1 2 3])))
  (is (= 2.5 (double (find-average [1 2 3 4])))))
