(ns clj-codewars.8kyu-subtract-the-sum-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-subtract-the-sum :refer :all]))

(defn tester [n exp]
  (testing (str "(subtract-sum " n ")")
    (is (= (subtract-sum n) exp))))

(deftest basic-tests
  (tester 10 "apple"))