(ns clj-codewars.7kyu-simple-fun-3-late-ride-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-simple-fun-3-late-ride :refer :all]))

(defn tester [n e]
  (testing (str "Testing for " n)
    (is (= (late-ride n) e))))

(deftest basic-tests
  (tester 240 4)
  (tester 808 14)
  (tester 1439 19)
  (tester 0 0)
  (tester 23 5)
  (tester 8 8))
