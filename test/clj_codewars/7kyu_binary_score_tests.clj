(ns clj-codewars.7kyu-binary-score-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-binary-score :refer :all]))

(defn assert-equals [act exp]
  (is (= act exp)))

(deftest score-tests
  (testing "Basic"
    (assert-equals (score 0) 0)
    (assert-equals (score 1) 1)
    (assert-equals (score 49) 63)
    (assert-equals (score 1000000) 1048575)))