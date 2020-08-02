(ns clj-codewars.7kyu-reversing-fun-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-reversing-fun :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "reverse-fun"
    (test-assert(reverse-fun "012"), "201")
    (test-assert(reverse-fun "012345"), "504132")
    (test-assert(reverse-fun "0123456789"), "9081726354")
    (test-assert(reverse-fun "Hello"), "oHlel")
    (test-assert(reverse-fun "4ppso1vdjc9rjyf5bkmd5nztr8"), "84rptpzsno51dvmdkjbc59fryj")
    ))
