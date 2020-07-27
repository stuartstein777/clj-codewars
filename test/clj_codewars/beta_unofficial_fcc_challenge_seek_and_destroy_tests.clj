(ns clj-codewars.beta-unofficial-fcc-challenge-seek-and-destroy-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-seek-and-destroy :refer :all]))

(deftest basic-tests
  (is (= (destroyer [1 2 3 1 2 3] 2 3) [1 1]) "should return [1 1]")
  (is (= (destroyer [1 2 3 5 1 2 3] 2 3) [1 5 1]) "should return [1 5 1]")
  (is (= (destroyer [3 5 1 2 2] 2 3 5) [1]) "should return [1]")
  (is (= (destroyer [2 3 2 3] 2 3) []) "should return []")
  (is (= (destroyer ["tree" "hamburger" 53] "tree" 53) ["hamburger"]) "should return [\"hamburger\"]"))