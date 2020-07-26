(ns clj-codewars.6kyu-the-shell-game-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-the-shell-game :refer :all]))

(deftest the-shell-game-tests
  (testing "An empty swap set doesn't move the ball"
    (is (= (find-the-ball 5 []) 5)))
  (testing "Some games"
    (is (= (find-the-ball 0 [[0 1] [2 1] [0 1]]) 2))))

