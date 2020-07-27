(ns clj-codewars.7kyu-covfefe-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-covfefe :refer :all]))

(deftest covfefe-tests
  (is (= (covfefe "coverage") "covfefe"))
  (is (= (covfefe "I have coverage of them") "I have covfefe of them"))
  (is (= (covfefe "I dont know") "I dont know covfefe")))