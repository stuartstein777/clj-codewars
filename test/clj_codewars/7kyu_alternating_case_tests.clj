(ns clj-codewars.7kyu-alternating-case-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-alternating-case :refer :all]))

(deftest sample-tests
  (is (= (alternate-case "") ""))
  (is (= (alternate-case "abc") "ABC"))
  (is (= (alternate-case "Hello World!") "hELLO wORLD!"))
  (is (= (alternate-case "CodeWars") "cODEwARS"))
  (is (= (alternate-case "i LIKE MAKING KATAS VERY MUCH!") "I like making katas very much!"))
  (is (= (alternate-case "0 gravity 0 calories!") "0 GRAVITY 0 CALORIES!")))