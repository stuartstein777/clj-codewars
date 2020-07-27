(ns clj-codewars.7kyu-find-the-kth-element-of-a-list-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-find-the-kth-element-of-a-list :refer :all]))

(deftest test-last-function
  (let [input1 [1 9 13 1 99 9 9 13]]
    (testing (str "Testing: " (prn-str input1))
      (are [x y] (= x y)
                 (element-at input1 1) 1
                 (element-at input1 2) 9
                 (element-at input1 3) 13
                 (element-at input1 4) 1
                 (element-at input1 5) 99))))
