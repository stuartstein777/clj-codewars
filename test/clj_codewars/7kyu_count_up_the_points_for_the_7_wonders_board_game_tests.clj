(ns clj-codewars.7kyu-count-up-the-points-for-the-7-wonders-board-game-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-Count-up-the-points-for-the-7-wonders-board-game :refer :all]))

(deftest seven-wonders-science-test
  (is (= (seven-wonders-science 1 1 1) 10))
  (is (= (seven-wonders-science 2 1 1) 13))
  (is (= (seven-wonders-science 4 2 2) 38)))