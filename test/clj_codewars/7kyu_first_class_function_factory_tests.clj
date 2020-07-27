(ns clj-codewars.7kyu-first-class-function-factory-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-first-class-function-factory :refer :all]))

(deftest first-class-function-factory-tests
  (let [xs [1 2 3]]
    (are [x expected] (= expected ((factory x) xs))
                      3 [3 6 9]
                      5 [5 10 15])))