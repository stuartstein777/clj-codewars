(ns clj-codewars.7kyu-head-tail-init-and-last-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-head-tail-init-and-last :refer :all]))

(deftest head-tail-init-last-tests
  (is (= (head [5 1]) 5))
  (is (= (tail [1]) []))
  (is (= (init [1 5 7 9]) [1 5 7]))
  (is (= (last_ [7 2]) 2)))
