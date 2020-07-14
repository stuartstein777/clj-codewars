(ns clj-codewars.4kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.4kyu :refer :all]))

(deftest test-human-readable-duration
  (is (= (format-duration 0) "now"))
  (is (= (format-duration 1) "1 second"))
  (is (= (format-duration 62) "1 minute and 2 seconds"))
  (is (= (format-duration 120) "2 minutes"))
  (is (= (format-duration 3600) "1 hour"))
  (is (= (format-duration 3662) "1 hour, 1 minute and 2 seconds")))

(deftest strip-comments-tests
  (are [text symbols expected] (= (strip-comments text symbols) expected)
                               "apples, pears # and bananas\ngrapes\nbananas !apples"
                               '("#" "!")
                               "apples, pears\ngrapes\nbananas"

                               "a #b\nc\nd $e f g"
                               '("#" "$")
                               "a\nc\nd"))