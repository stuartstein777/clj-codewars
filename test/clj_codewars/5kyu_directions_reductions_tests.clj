(ns clj-codewars.5kyu-directions-reductions-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-directions-reduction :refer :all]))

(deftest a-test1-directions-reduction
  (testing "Test 1"
    (def ur ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"])
    (def vr ["WEST"])
    (is (= (dir-reduc ur) vr))))
