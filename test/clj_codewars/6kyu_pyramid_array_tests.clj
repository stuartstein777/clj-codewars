(ns clj-codewars.6kyu-pyramid-array-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-pyramid-array :refer :all]))

(deftest pyramid-tests
  (is (= (pyramid 0) []))
  (is (= (pyramid 1) [[1]]))
  (is (= (pyramid 2) [[1] [1 1]]))
  (is (= (pyramid 3) [[1] [1 1] [1 1 1 ]])))
