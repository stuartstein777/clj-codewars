(ns clj-codewars.7kyu-indexed-capitalization-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-indexed-capitalization :refer :all]))

(deftest indexed-capitalization-tests
  (is (= (capitalize "abcdef" [1 2 5]) "aBCdeF"))
  (is (= (capitalize "abcdef" [1 2 5 100]) "aBCdeF"))
  (is (= (capitalize "codewars" [1 3 5 50]) "cOdEwArs"))
  (is (= (capitalize "abracadabra" [2 6 9 10]) "abRacaDabRA"))
  (is (= (capitalize "indexinglessons" [0]) "Indexinglessons")))