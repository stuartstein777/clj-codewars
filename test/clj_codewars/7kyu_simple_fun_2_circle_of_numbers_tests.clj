(ns clj-codewars.7kyu-simple-fun-2-circle-of-numbers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-simple-fun-2-circle-of-numbers :refer :all]))

(deftest circle-of-numbers-tests
  (is (= (circle-of-numbers 10 2) 7))
  (is (= (circle-of-numbers 10 7) 2))
  (is (= (circle-of-numbers 4 1) 3))
  (is (= (circle-of-numbers 6 3) 0)))
