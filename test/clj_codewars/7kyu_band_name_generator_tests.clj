(ns clj-codewars.7kyu-band-name-generator-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-band-name-generator :refer :all]))

(deftest sample
  (testing "sample-tests"
    (are [input expected] (= (generate-band-name input) expected)
                          "knife" "The Knife"
                          "tart" "Tartart"
                          "sandles" "Sandlesandles"
                          "bed" "The Bed")))
