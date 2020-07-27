(ns clj-codewars.7kyu-blood-moon-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-blood-moon :refer :all]))

(def EPSILON 0.001)
(defn abs [n] (max n (- n)))
(defn do-test-blood-moon   [n exp]
  (let [actual (blood-moon n)]
    (is
      (<= (abs (- actual exp)) EPSILON)
      (str "Expected " exp " (+/- " EPSILON ")\nReceived " actual))))
(deftest basic-tests-blood-moon
  (testing "Testing for 0" (do-test-blood-moon 0 0))
  (testing "Testing for 1" (do-test-blood-moon 1 0.25))
  (testing "Testing for 2" (do-test-blood-moon 2 1))
  (testing "Testing for 3" (do-test-blood-moon 3 2.25)))
