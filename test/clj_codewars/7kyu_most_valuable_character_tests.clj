(ns clj-codewars.7kyu-most-valuable-character-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-most-valuable-character :refer :all]))

(deftest most-valuable-character-tests
  (testing "single char " (is (= (most-valuable-character "a") \a)))
  (testing "aa" (is (= \a (most-valuable-character "aa"))))
  (testing "bcd" (is (= \b (most-valuable-character "bcd"))))
  (testing "axyzxyz" (is (= \x (most-valuable-character "axyzxyz"))))
  (testing "dcbadcba" (is (= \a (most-valuable-character "dcbadcba"))))
  (testing "aabccc" (is (= \c (most-valuable-character "aabccc")))))