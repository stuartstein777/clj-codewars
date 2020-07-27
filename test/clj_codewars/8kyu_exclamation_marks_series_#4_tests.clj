(ns clj-codewars.8kyu-exclamation-marks-series-#4-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-exclamation-marks-series-#4 :refer :all]))

(deftest exclamation-marks-series-4-tests
  (let [greetings ["Hi", "Hi!", "Hi!!!!", "!Hi", "!Hi!", "Hi Hi!!", "Hi!\nHi", "!!!!!!!"]
        expected ["Hi!", "Hi!", "Hi!", "Hi!", "Hi!", "Hi Hi!", "Hi\nHi!", "!"]]
    (doall (map #(is (= (remove-bang %1) %2) "Basic tests") greetings expected))))