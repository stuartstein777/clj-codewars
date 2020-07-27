(ns clj-codewars.beta-unofficial-fcc-challenge-mutations-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-mutations :refer :all]))

(deftest basic-test

  (is (not (mutation ["hello" "hey"]))
      "should return false")

  (is (mutation ["hello" "Hello"])
      "should return true")

  (is (mutation ["zyxwvutsrqponmlkjihgfedcba" "qrstu"])
      "should return true")

  (is (mutation ["Mary" "Army"])
      "should return true")

  (is (mutation ["Mary" "Aarmy"])
      "should return true")

  (is (mutation ["Alien" "line"])
      "should return true")

  (is (mutation ["floor" "for"])
      "should return true")

  (is (not (mutation ["hello" "neo"]))
      "should return false")

  (is (not (mutation ["voodoo" "no"]))
      "should return false"))