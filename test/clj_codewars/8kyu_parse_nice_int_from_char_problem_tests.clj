(ns clj-codewars.8kyu-parse-nice-int-from-char-problem-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-parse-nice-int-from-char-problem :refer :all]))

(deftest
  how-old-test
  (testing "Testing how old"
    (is (= (how-old "1 year old") 1))
    (is (= (how-old "6 years old") 6))))

