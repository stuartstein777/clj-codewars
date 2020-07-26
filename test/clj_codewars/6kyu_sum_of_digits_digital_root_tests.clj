(ns clj-codewars.6kyu-sum-of-digits-digital-root-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-sum-of-digits-digital-root :refer :all]))

(deftest digital-root-example-test
  (is (= (digital-root 16) 7))
  (is (= (digital-root 456) 6)))
