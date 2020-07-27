(ns clj-codewars.8kyu-are-you-playing-banjo-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-are-you-playing-banjo :refer :all]))

(deftest Banjo-test
  (is (= (plays-banjo? "Adam") "Adam does not play banjo"))
  (is (= (plays-banjo? "Paul") "Paul does not play banjo"))
  (is (= (plays-banjo? "Ringo") "Ringo plays banjo"))
  (is (= (plays-banjo? "bravo") "bravo does not play banjo"))
  (is (= (plays-banjo? "rolf") "rolf plays banjo")))