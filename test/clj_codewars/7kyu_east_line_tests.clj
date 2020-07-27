(ns clj-codewars.7kyu-east-line-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-easy-line :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest easy-line-tests
  (testing "Basic test easy-line"
    (do-test easy-line 7 3432N)
    (do-test easy-line 13 10400600N)
    (do-test easy-line 17 2333606220N)
    (do-test easy-line 19 35345263800N)))