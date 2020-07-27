(ns clj-codewars.8kyu-sort-and-star-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-sort-and-star :refer [star-sort]]))

(deftest a-test1-sort-and-star
  (testing "Test1"
    (is (= (star-sort ["bitcoin" "take" "over" "the" "world" "maybe" "who" "knows" "perhaps"])
           "b***i***t***c***o***i***n"))))
(deftest a-test2-sort-and-star
  (testing "Test 2"
    (is (= (star-sort ["turns" "out" "random" "test" "cases" "are" "easier" "than" "writing" "out" "basic" "ones"])
           "a***r***e"))))
(deftest a-test3-sort-and-star
  (testing "Test 3"
    (is (= (star-sort ["lets" "talk" "about" "javascript" "the" "best" "language"])
           "a***b***o***u***t"))))
(deftest a-test4-sort-and-star
  (testing "Test 4"
    (is (= (star-sort ["i" "want" "to" "travel" "the" "world" "writing" "code" "one" "day"])
           "c***o***d***e"))))
(deftest a-test5-sort-and-star
  (testing "Test 5"
    (is (= (star-sort ["Lets" "all" "go" "on" "holiday" "somewhere" "very" "cold"])
           "L***e***t***s"))))
