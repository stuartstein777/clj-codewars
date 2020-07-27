(ns clj-codewars.7kyu-unlucky-days-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-unlucky-days :refer :all]))

(deftest unlucky-days-tests
  (is (= (unlucky-days 2015) 3))
  (is (= (unlucky-days 1986) 1)))
