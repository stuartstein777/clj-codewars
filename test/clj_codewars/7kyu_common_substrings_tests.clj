(ns clj-codewars.7kyu-common-substrings-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-common-substrings :refer :all]))

(deftest common-substrings-tests
  (is (= true (common-substrings "Something" "Home")))
  (is (= false (common-substrings "Something" "Fun"))))
