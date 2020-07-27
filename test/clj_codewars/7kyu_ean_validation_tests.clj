(ns clj-codewars.7kyu-ean-validation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-ean-validation :refer :all]))

(deftest ean-validation-tests
  (are [code answer] (= (validate-ean code) answer)
                     "9783815820865" true
                     "9783815820864" false
                     "9783827317100" true))