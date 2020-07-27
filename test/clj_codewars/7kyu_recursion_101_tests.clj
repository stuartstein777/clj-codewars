(ns clj-codewars.7kyu-recursion-101-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-recursion-101 :refer :all]))

(deftest recursion-101-tests
  (is (= (recursion-101 6 19) '(6 7)))
  (is (= (recursion-101 2 1) '(0 1)))
  (is (= (recursion-101 22 5) '(0 1)))
  (is (= (recursion-101 2 10) '(2 2)))
  (is (= (recursion-101 8796203 7556) '(1019 1442)))
  (is (= (recursion-101 19394 19394) '(19394 19394))))
