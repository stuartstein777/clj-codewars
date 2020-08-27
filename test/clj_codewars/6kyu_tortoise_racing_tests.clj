(ns clj-codewars.6kyu-tortoise-racing-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-tortoise-racing :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is (= (race 720 850 70) [0 32 18]))
    (is (= (race 80 91 37) [3 21 49]))
    (is (= (race 80 100 40) [2 0 0]))))