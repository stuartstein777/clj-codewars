(ns clj-codewars.6kyu-ease-the-stockbroker-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-ease-the-stockbroker :refer :all]))

(deftest a-test0
  (testing "stockbroker test 1"
    (is (= (balance "GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S")
           "Buy: 14440 Sell: 6408; Badly formed 2: MYSPACE 24.0 210 B ;CITI 50 450 B ;"))))
(deftest a-test1
  (testing "stockbroker test 2"
    (is (= (balance "GOOG 300 542.0 B, AAPL 50 145.0 B, CSCO 250.0 29 B, GOOG 200 580.0 S")
           "Buy: 169850 Sell: 116000; Badly formed 1: CSCO 250.0 29 B ;"))))
(deftest a-test2
  (testing "stockbroker test 3"
    (is (= (balance "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B")
           "Buy: 29499 Sell: 0"))))
(deftest a-test3
  (testing "stockbroker test 4"
    (is (= (balance "")
           "Buy: 0 Sell: 0"))))