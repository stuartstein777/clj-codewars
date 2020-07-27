(ns clj-codewars.8kyu-determine-offpring-sex-based-on-chromosomes-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-determine-offpring-sex-based-on-chromosomes :refer :all]))

(deftest simple-tests
  (is (= "Congratulations! You're going to have a son." (chromosome-check "XY")))
  (is (= "Congratulations! You're going to have a daughter." (chromosome-check "XX"))))