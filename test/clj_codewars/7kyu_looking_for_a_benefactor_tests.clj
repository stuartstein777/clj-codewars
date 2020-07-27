(ns clj-codewars.7kyu-looking-for-a-benefactor-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-looking-for-a-benefactor :refer :all]))

(defn test-assert-benefactor [act exp]
  (is (= act exp)))

(deftest a-test1-benefactor
  (testing "new-avg"
    (test-assert-benefactor (new-avg [14, 30, 5, 7, 9, 11, 16] 90) 628)
    (test-assert-benefactor (new-avg [14, 30, 5, 7, 9, 11, 15] 92) 645)
    (is (thrown? IllegalArgumentException (new-avg [14, 30, 5, 7, 9, 11, 15] 2)))))
