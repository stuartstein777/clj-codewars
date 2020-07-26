(ns clj-codewars.6kyu-help-the-bookseller-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-help-the-bookseller :refer :all]))

(deftest help-the-bookseller-test
  (testing "Test 1"
    (def ur ["BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"])
    (def vr ["A" "B" "C" "D"])
    (def res [["A" 0] ["B" 1290] ["C" 515] ["D" 600]])
    (is (= (stock-list ur vr) res))))
