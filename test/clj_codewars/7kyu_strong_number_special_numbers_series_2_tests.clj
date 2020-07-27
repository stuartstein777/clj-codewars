(ns clj-codewars.7kyu-strong-number-special-numbers-series-2-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-strong-number-special-numbers-series-2 :refer :all]))

(defn tester-strong-numbers [n exp]
  (testing (str "Testing for " n)
    (is (= (strong n) exp))))

(deftest basic-tests-strong-numbers
  (tester-strong-numbers 1 "STRONG!!!!")
  (tester-strong-numbers 2 "STRONG!!!!")
  (tester-strong-numbers 145 "STRONG!!!!")
  (tester-strong-numbers 40585 "STRONG!!!!")
  (tester-strong-numbers 7 "Not Strong !!")
  (tester-strong-numbers 93 "Not Strong !!")
  (tester-strong-numbers 185 "Not Strong !!"))
