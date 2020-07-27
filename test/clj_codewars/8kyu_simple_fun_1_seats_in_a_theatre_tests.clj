(ns clj-codewars.8kyu-simple-fun-1-seats-in-a-theatre-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-simple-fun-1-seats-in-a-theatre :refer :all]))

(defn tester-2 [a b c d e]
  (testing (str "(seats-in-theater " a " " b " " c " " d ")")
    (is (= (seats-in-theater a b c d) e))))

(deftest basic-tests-1
  (tester-2 16 11 5 3 96)
  (tester-2 1 1 1 1 0)
  (tester-2 13 6 8 3 18)
  (tester-2 60 100 60 1 99)
  (tester-2 1000 1000 1000 1000 0))