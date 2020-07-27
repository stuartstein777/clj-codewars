(ns clj-codewars.7kyu-find-the-missing-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-find-the-missing-number :refer :all]))

(deftest zero-test
  (is (= (->> (range 1 101) shuffle missing-no) 0)))

(deftest twelve-test
  (is (= (->> (range 101) (remove (partial = 12)) shuffle missing-no) 12)))