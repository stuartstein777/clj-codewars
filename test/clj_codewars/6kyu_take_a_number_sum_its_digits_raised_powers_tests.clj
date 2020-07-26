(ns clj-codewars.6kyu-take-a-number-sum-its-digits-raised-powers-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-take-a-number-sum-its-digits-raised-powers :refer :all]))

(deftest sum-dig-pow-tests
  (println "Basic Tests sum-dig-pow")
  (= (sum-dig-pow 1 10) [1, 2, 3, 4, 5, 6, 7, 8, 9])
  (= (sum-dig-pow 1 100) [1, 2, 3, 4, 5, 6, 7, 8, 9, 89])
  (= (sum-dig-pow 10 100) [89])
  (= (sum-dig-pow 90 100) [])
  (= (sum-dig-pow 90 150) [135])
  (= (sum-dig-pow 50 150) [89, 135])
  (= (sum-dig-pow 10 150) [89, 135]))
