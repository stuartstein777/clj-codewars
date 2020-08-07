
(ns clj-codewars.7kyu-stacked-2d-balls-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-stacked-2d-balls :refer :all]))

(def EPSILON 0.001)
(defn abs [n] (max n (- n)))
(defn do-test [layers exp]
  (let [actual (stack-height-2d layers)]
    (is
      (<= (abs (- actual exp)) EPSILON)
      (str "Expected " exp " (+/- " EPSILON ")\nReceived " actual))))
(deftest solution-tests
  (testing "test0" (do-test 0 0.0))
  (testing "test1" (do-test 1 1.0))
  (testing "test2" (do-test 2 1.866)))