(ns clj-codewars.6kyu-detect-pangram-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-detect-pangram :refer :all]))

(deftest pangram-tests
  (is (= (pangram? "The quick brown fox jumps over the lazy dog.") true))
  (is (= (pangram? "Pack my box with five dozen liquor jugs.") true))
  (is (= (pangram? "Not every sentence is a a pangram. An example") false)))

