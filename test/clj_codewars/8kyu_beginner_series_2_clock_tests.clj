(ns clj-codewars.8kyu-beginner-series-2-clock-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-beginner-series-2-clock :refer :all]))

(defn tester [h m s e]
  (testing (str "(past " h " " m " " s ")")
    (is (= (past h m s) e))))

(deftest basic-tests
  (tester 0 1 1 61000)
  (tester 1 1 1 3661000)
  (tester 0 0 0 0)
  (tester 1 0 1 3601000)
  (tester 1 0 0 3600000))
