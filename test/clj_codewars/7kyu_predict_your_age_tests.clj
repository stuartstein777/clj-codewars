(ns clj-codewars.7kyu-predict-your-age-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-predict-your-age :refer :all]))

(deftest predit-age-test1
  (is (= (predict-age 65 60 75 55 60 63 64 45) 86)))

(deftest predit-age-test2
  (is (= (predict-age 32 54 76 65 34 63 64 45) 79)))
