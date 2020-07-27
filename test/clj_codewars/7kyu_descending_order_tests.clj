(ns clj-codewars.7kyu-descending-order-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-descending-order :refer :all]))

(deftest descending-order-tests
  (are [n expected]
    (= expected (desc-order n))
    0          0
    1          1
    15         51))