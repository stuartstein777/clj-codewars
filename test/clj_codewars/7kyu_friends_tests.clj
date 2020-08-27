(ns clj-codewars.7kyu-friends-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-friends :refer :all]))

(defn tester [n e]
  (testing (str "Testing for " n)
    (is (= (friends n) e))))

(deftest example-tests
  (tester 0 0)
  (tester 1 0)
  (tester 2 0))