(ns clj-codewars.6kyu-range-parser-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-range-parser :refer :all]))

(deftest range-parser-tests
  (are [inp exp] (= (range-parser inp) exp)
                 "2"      [2]
                 "1-10"   [1 2 3 4 5 6 7 8 9 10]
                 "5-10"   [5 6 7 8 9 10]
                 "1-10,3" [1 2 3 4 5 6 7 8 9 10 3]
                 "1-10:5" [1 6]
                 "2-3"    [2 3]
                 "2-3:2"  [2]
                 "0-5:5"  [0 5]
                 "2-3:2,2-3:2" [2 2]
                 "0-1, 0-2:1,3-5:2" [0 1 0 1 2 3 5]
                 "1-10,14, 20-25:2" [1 2 3 4 5 6 7 8 9 10 14 20 22 24]))
