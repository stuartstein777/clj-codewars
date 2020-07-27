(ns clj-codewars.8kyu-kata-example-twist-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-kata-example-twist :refer :all]))

(deftest kata-example-twist-tests
  (is (pos? (count websites)))
  (is (= 1000 (count websites)))
  (is (every? #(= "codewars" %) websites)))