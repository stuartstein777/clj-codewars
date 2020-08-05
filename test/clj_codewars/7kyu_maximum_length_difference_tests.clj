(ns clj-codewars.7kyu-maximum-length-difference-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-maximum-length-difference :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "mxdiflg"
    (def s1 ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"])
    (def s2 ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"])
    (test-assert(mxdiflg s1, s2), 13)))

