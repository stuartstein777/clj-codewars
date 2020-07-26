(ns clj-codewars.6kyu-two-sum-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-two-sum :refer :all]))

(deftest twosum-example-tests
  (is (= (sort < (twosum '[1 2 3] 4)) '[0 2]))
  (is (= (sort < (twosum '[1234 5678 9012] 14690)) '[1 2]))
  (is (= (sort < (twosum '[2 2 3] 4)) '[0 1])))
