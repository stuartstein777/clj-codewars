(ns clj-codewars.6kyu-stop-gninnips-my-sdrow-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-stop-gninnips-my-sdrow :refer :all]))

(deftest one-word-test
  (is (= (spin-words "Welcome") "emocleW")))
