(ns clj-codewars.beta-unofficial-fcc-falsy-bouncer-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-falsy-bouncer :refer :all]))

(deftest basic-tests

  (is (= (bouncer [7 "ate" "" false 9])
         [7 "ate" "" 9])
      "should return [7 \"ate\" 9]")

  (is (= (bouncer ["a" "b" "c"])
         ["a" "b" "c"])
      "should return [\"a\" \"b\" \"c\"]")

  (is (= (bouncer [false nil])
         [])
      "should return []")

  (is (= (bouncer [1 nil 2])
         [1 2])
      "should return [1 2]"))
