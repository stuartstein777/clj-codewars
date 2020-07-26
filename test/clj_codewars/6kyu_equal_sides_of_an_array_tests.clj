(ns clj-codewars.6kyu-equal-sides-of-an-array-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-equal-sides-of-an-array :refer :all]))

(deftest a-test1
  (testing "find-even-index"
    (println "Fixed Tests find-even-index")
    (is (= (find-even-index [1, 2, 3, 4, 3, 2, 1]), 3))
    (is (= (find-even-index [1, 100, 50, -51, 1, 1]), 1))
    (is (= (find-even-index [1, 2, 3, 4, 5, 6]), -1))
    (is (= (find-even-index [20, 10, 30, 10, 10, 15, 35]), 3))))
