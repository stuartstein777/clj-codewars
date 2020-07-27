(ns clj-codewars.7kyu-responsible-drinking-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-responsible-drinking :refer :all]))

(deftest hydrate-test1
  (def text "1 beer")
  (def expected "1 glass of water")
  (def actual (hydrate text))
  (is (= actual expected)))

(deftest hydrate-test3
  (def text "1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer")
  (def expected "10 glasses of water")
  (def actual (hydrate text))
  (is (= actual expected)))
