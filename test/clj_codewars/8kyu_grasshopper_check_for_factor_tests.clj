(ns clj-codewars.8kyu-grasshopper-check-for-factor-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-grasshopper-check-for-factor :refer :all]))

(defn tester-check-for-factor [base factor exp]
  (testing (str "(check-for-factor " base " " factor ")")
    (is (= (check-for-factor base factor) exp))))

(deftest basic-tests-check-for-factor
  (tester-check-for-factor 10 2 true)
  (tester-check-for-factor 63 7 true)
  (tester-check-for-factor 2450 5 true)
  (tester-check-for-factor 24612 3 true)
  (tester-check-for-factor 9 2 false)
  (tester-check-for-factor 653 7 false)
  (tester-check-for-factor 2453 5 false)
  (tester-check-for-factor 24617 3 false))
