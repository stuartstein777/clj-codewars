(ns clj-codewars.7kyu-sorted-yes-no-how-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-sorted-yes-no-how :refer :all]))

(deftest sample-tests
  (are [inp exp] (= exp (sorted-and-how inp))
                 [1 2] "yes, ascending"
                 [15 7 3 -8] "yes, descending"
                 [4 2 30] "no"))

