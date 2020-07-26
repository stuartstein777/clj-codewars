(ns clj-codewars.6kyu-playing-on-a-chessboard-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-playing-on-a-chessboard :refer :all]))

(deftest a-test1-playing-on-a-chessboard
  (testing "test1"
    (is (= (game 0) [0]))))

(deftest a-test2-playing-on-a-chessboard
  (testing "test2"
    (is (= (game 1) [1, 2]))))

(deftest a-test3-playing-on-a-chessboard
  (testing "test3"
    (is (= (game 8) [32]))))