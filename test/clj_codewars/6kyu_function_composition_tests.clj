(ns clj-codewars.6kyu-function-composition-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-function-composition :refer :all]))

(defn id [n] (do n))

(deftest composition-example-test
  (is (= ((compose (partial + 1) id) 0) 1)))
