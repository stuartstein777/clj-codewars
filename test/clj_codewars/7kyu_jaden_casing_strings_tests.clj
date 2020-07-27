(ns clj-codewars.7kyu-jaden-casing-strings-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-jaden-casing-strings :refer :all]))

(deftest test-quote
  (is (= "How Can Mirrors Be Real If Our Eyes Aren't Real"
         (jaden-case "How can mirrors be real if our eyes aren't real"))))

