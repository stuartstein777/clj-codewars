(ns clj-codewars.8kyu-grasshopper-terminal-game-move-function-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-grasshopper-terminal-game-move-function :refer :all]))

(deftest basic-tests-terminal-mov
  (testing "(move 0 4)" (is (= (move 0 4) 8)))
  (testing "(move 3 6)" (is (= (move 3 6) 15)))
  (testing "(move 2 5)" (is (= (move 2 5) 12))))
