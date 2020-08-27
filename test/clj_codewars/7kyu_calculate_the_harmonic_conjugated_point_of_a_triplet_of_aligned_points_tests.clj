(ns clj-codewars.7kyu-calculate-the-harmonic-conjugated-point-of-a-triplet-of-aligned-points-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-calculate-the-harmonic-conjugated-point-of-a-triplet-of-aligned-points :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is (= (harmon-point-trip 6, 10, 11), 9.3333))
    (is (= (harmon-point-trip 2, 10, 20), 7.1429))))

