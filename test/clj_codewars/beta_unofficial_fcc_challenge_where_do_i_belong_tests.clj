(ns clj-codewars.beta-unofficial-fcc-challenge-where-do-i-belong-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-where-do-i-belong :refer :all]))

(deftest where-do-i-belong-tests
  (is (= (get-index-to-insert [10 20 30 40 50] 35) 3) "should return 3")
  (is (= (get-index-to-insert [10 20 30 40 50] 30) 2) "should return 2")
  (is (= (get-index-to-insert [40 60] 50) 1) "should return 1")
  (is (= (get-index-to-insert [3 10 5] 3) 0) "should return 0")
  (is (= (get-index-to-insert [5 3 20 3] 5) 2) "should return 2")
  (is (= (get-index-to-insert [2 20 10] 19) 2) "should return 2")
  (is (= (get-index-to-insert [2 5 10] 15) 3) "should return 3"))
