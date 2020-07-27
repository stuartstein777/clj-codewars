(ns clj-codewars.8kyu-string-repeat-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-string-repeat :refer :all]))

(deftest simple-test-string-repeat
  (is (= (repeat-str 4 "a") "aaaa"))
  (is (= (repeat-str 3 "hello ") "hello hello hello "))
  (is (= (repeat-str 2 "abc") "abcabc")))
