(ns clj-codewars.8kyu-exclusive-or-xor-logical-operator-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-exclusive-or-xor-logical-operator :refer :all]))

(deftest Tests-2
  (is (= (xor false false) false) "false xor false === false")
  (is (= (xor true false) true) "true xor false === true")
  (is (= (xor false true) true) "false xor true === true")
  (is (= (xor true true) false) "true xor true === false")
  (is (not= (xor true true) true) "'xor' is NOT identical to 'or'"))
