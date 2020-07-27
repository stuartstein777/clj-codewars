(ns clj-codewars.7kyu-printer-errors-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-printer-errors :refer :all]))

(deftest printer-error-tests
  (testing "printer-error"
    (is (= (printer-error "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz") "3/56"))))