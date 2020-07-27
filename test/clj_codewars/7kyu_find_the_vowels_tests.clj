(ns clj-codewars.7kyu-find-the-vowels-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-find-the-vowels :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest test-vowel-indices
  (testing "vowel-indices"
    (test-assert(vowel-indices "super"), [2,4])))