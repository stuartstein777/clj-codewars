(ns clj-codewars.8kyu-draw-stairs-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-draw-stairs :refer :all]))

(defn tester [n exp]
  (testing (str "Testing for " n)
    (is (= (draw-stairs n) exp))))

(deftest basic-tests
  (tester 3 "I\n I\n  I")
  (tester 5 "I\n I\n  I\n   I\n    I"))