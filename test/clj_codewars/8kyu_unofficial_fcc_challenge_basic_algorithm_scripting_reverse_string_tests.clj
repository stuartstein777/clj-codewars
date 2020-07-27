(ns clj-codewars.8kyu-unofficial-fcc-challenge-basic-algorithm-scripting-reverse-string-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-unofficial-fcc-challenge-basic-algorithm-scripting-reverse-string :refer :all]))

(deftest fcc-reverse-test
  (is (string? (reverse-string "hello"))
      "should return a string")
  (is (= (reverse-string "hello")
         "olleh")
      "should return \"olleh\"")
  (is (= (reverse-string "Howdy")
         "ydwoH")
      "should return \"ydwoH\"")
  (is (= (reverse-string "Greetings from Earth")
         "htraE morf sgniteerG")
      "should return \"htraE morf sgniteerG\""))