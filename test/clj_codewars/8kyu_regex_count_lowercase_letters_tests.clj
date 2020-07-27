(ns clj-codewars.8kyu-regex-count-lowercase-letters-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-regex-count-lowercase-letters :refer :all]))

(deftest regex-count-lowercase-letters-tests
  (testing "Basic Tests"
    (is (= (lowercase_count "abc") 3))
    (is (= (lowercase_count "abcABC123") 3))
    ;note that this had to remove an escape character because of clojure's string rules
    (is (= (lowercase_count "abcABC123!@#$%^&*()_-+=}{[]|':;?/>.<,~") 3))
    (is (= (lowercase_count "") 0))
    ;note that this had to remove an escape character because of clojure's string rules
    (is (= (lowercase_count "ABC123!@#$%^&*()_-+=}{[]|':;?/>.<,~") 0))
    (is (= (lowercase_count "abcdefghijklmnopqrstuvwxyz") 26))))