(ns clj-codewars.8kyu-grasshopper-messi-goals-function-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-grasshopper-messi-goals-function :refer :all]))

(deftest basic-tests-messi-goals
  (testing "(goals 0 0 0)" (is (= (goals 0 0 0) 0)))
  (testing "(goals 43 10 5)" (is (= (goals 43 10 5) 58))))