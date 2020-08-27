(ns clj-codewars.5kyu-some-egyptian-fractions-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-some-egyptian-fractions :refer :all]))

(deftest a-test1
  (is (= (decompose "0") []))
  (is (= (decompose "3/4") ["1/2", "1/4"]))
  (is (= (decompose "12/4") ["3"]))
  (is (= (decompose "4/5") ["1/2", "1/4", "1/20"]))
  (is (= (decompose "1.25") ["1" "1/4"])))