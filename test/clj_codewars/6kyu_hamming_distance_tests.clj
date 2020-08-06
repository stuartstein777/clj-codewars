(ns clj-codewars.6kyu-hamming-distance-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-hamming-distance :refer :all]))

(deftest Tests
  (is (= (hamming "I like turtles" "I like turkeys") 3))
  (is (= (hamming "Hello World" "Hello World") 0))
  (is (= (hamming "Hello Haskell" "Hello World!!") 7)))