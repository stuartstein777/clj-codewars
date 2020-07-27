(ns clj-codewars.7kyu-penultimate-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-penultimate :refer :all]))

(deftest test-penultimate
  (let [input1 [1 9 13 1 99 9 9 13]]
    (testing (prn-str input1)
      (is (= (penultimate input1) 9)))))
