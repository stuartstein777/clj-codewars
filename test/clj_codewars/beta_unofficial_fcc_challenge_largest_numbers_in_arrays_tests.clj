(ns clj-codewars.beta-unofficial-fcc-challenge-largest-numbers-in-arrays-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-largest-numbers-in-arrays :refer :all]))

(deftest basic-tests

  (is (seq? (largest-of-four [[4 5 1 3] [13 27 18 26] [32 35 37 39] [1000 1001 857 1]]))
      "should return a sequence")

  (is (= (largest-of-four [[13 27 18 26] [4 5 1 3] [32 35 37 39] [1000 1001 857 1]])
         [27 5 39 1001])
      "should return [27 5 39 1001]")

  (is (= (largest-of-four [[4 9 1 3] [13 35 18 26] [32 35 97 39] [1000000 1001 857 1]])
         [9 35 97 1000000])
      "should return  [9 35 97 1000000]"))


