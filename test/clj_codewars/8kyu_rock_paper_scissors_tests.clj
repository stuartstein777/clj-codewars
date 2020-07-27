(ns clj-codewars.8kyu-rock-paper-scissors-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-rock-paper-scissors :refer :all]))

(deftest rps-tests
  (testing "player 1 win"
    (are [p1 p2] (= "Player 1 won!" (rps p1 p2))
                 "rock" "scissors"
                 "scissors" "paper"
                 "paper" "rock"))
  (testing "player 2 win"
    (are [p1 p2] (= "Player 2 won!" (rps p1 p2))
                 "scissors" "rock"
                 "paper" "scissors"
                 "rock" "paper"))
  (testing "draw"
    (are [p1 p2] (= "Draw!" (rps p1 p2))
                 "rock" "rock"
                 "scissors" "scissors"
                 "paper" "paper")))

