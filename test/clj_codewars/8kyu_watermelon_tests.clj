(ns clj-codewars.8kyu-watermelon-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-watermelon :refer :all]))

(defn tester [n exp]
  (testing (str "(divide " n ")")
    (is (= (divide n) exp))))

(deftest basic-tests
  (tester 4 true)
  (tester 2 false)
  (tester 5 false)
  (tester 88 true)
  (tester 100 true)
  (tester 67 false)
  (tester 90 true)
  (tester 10 true)
  (tester 99 false)
  (tester 32 true))