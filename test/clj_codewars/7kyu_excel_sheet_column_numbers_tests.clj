(ns clj-codewars.7kyu-excel-sheet-column-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-excel-sheet-column-numbers :refer :all]))

(deftest excel-sheet-column-numbers
  (testing "Basic tests"
    (is (= (title-to-nb "A") 1))
    (is (= (title-to-nb "Z") 26))
    (is (= (title-to-nb "AA") 27))
    (is (= (title-to-nb "AZ") 52))
    (is (= (title-to-nb "BA") 53))
    (is (= (title-to-nb "CODEWARS") 28779382963))))