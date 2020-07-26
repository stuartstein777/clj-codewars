(ns clj-codewars.6kyu-counting-duplicates-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-counting-duplicates :refer :all]))

(deftest counting-duplicate-tests
  (testing "blank"
    (is (= 0 (duplicate-count ""))))
  (testing "abcde"
    (is (= 0 (duplicate-count "abcde"))))
  (testing "aabbcde"
    (is (= 2 (duplicate-count "aabbcde"))))
  (testing "ignore-case"
    (is (= 2 (duplicate-count "aabBcde"))))
  (testing "Indivisibility"
    (is (= 1 (duplicate-count "Indivisibility"))))
  (testing "non-adjacent"
    (is (= 2 (duplicate-count "Indivisibilities")))))
