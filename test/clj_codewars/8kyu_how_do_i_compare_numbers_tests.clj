(ns clj-codewars.8kyu-how-do-i-compare-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-how-do-i-compare-numbers :refer :all]))

(deftest tests-compare-numbers
  (are [x answer] (= (what-is x) answer)
                  0 "nothing"
                  123 "nothing"
                  -1 "nothing"
                  42 "everything"
                  (* 42 42) "everything squared"))