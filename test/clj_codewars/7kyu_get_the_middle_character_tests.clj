(ns clj-codewars.7kyu-get-the-middle-character-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-get-the-middle-character :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest get-the-middle-chracter-tests
  (testing "get-middle"
    (do-test get-middle "test", "es")
    (do-test get-middle "testing", "t")
    (do-test get-middle "middle", "dd")
    (do-test get-middle "A", "A")))