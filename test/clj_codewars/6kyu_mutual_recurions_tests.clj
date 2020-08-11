(ns clj-codewars.6kyu-mutual-recurions-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-mutual-recursion :refer :all]))

(deftest mutual-recursion-test
  (is (=  (f 0) 1))
  (is (=  (f 1) 1))
  (is (=  (f 2) 2))
  (is (=  (f 3) 2))
  (is (=  (m 0) 0))
  (is (=  (m 1) 0))
  (is (=  (m 2) 1))
  (is (=  (m 3) 2)))