(ns clj-codewars.7kyu-target-date-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-target-date :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "date-nb-days"
    (println "Fixed Tests date-nb-days")
    (test-assert(date-nb-days 4281, 5087, 2), "2024-07-03")
    (test-assert(date-nb-days 4620, 5188, 2), "2021-09-19")
    (test-assert(date-nb-days 9999, 11427, 6), "2018-03-13")
    (test-assert(date-nb-days 3525, 4822, 3), "2026-04-18")
    (test-assert(date-nb-days 5923, 6465, 6), "2017-06-10")
    (test-assert(date-nb-days 4254, 4761, 8), "2017-05-22")
    (test-assert(date-nb-days 1244, 2566, 4), "2033-11-04")
    (test-assert(date-nb-days 6328, 7517, 5), "2019-05-25")
    (test-assert(date-nb-days 2920, 3834, 2), "2029-06-03")
    (test-assert(date-nb-days 7792, 8987, 4), "2019-07-09")))