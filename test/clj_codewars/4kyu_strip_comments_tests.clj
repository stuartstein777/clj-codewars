(ns clj-codewars.4kyu-strip-comments-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.4kyu-strip-comments :refer :all]))

(deftest strip-comments-tests
  (are [text symbols expected] (= (strip-comments text symbols) expected)
                               "apples, pears # and bananas\ngrapes\nbananas !apples"
                               '("#" "!")
                               "apples, pears\ngrapes\nbananas"

                               "a #b\nc\nd $e f g"
                               '("#" "$")
                               "a\nc\nd"))
