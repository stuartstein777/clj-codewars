(ns clj-codewars.7kyu-shorter-concat-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-shorter-concat :refer :all]))

(deftest SampleTests-reverse-longer
  (is (= (reverseLonger "first" "abcde") "abcdetsrifabcde" ))
  (is (= (reverseLonger "hello" "bau") "bauollehbau"))
  (is (= (reverseLonger "abcde" "fghi") "fghiedcbafghi"))
  (is (= (reverseLonger "abc" "123") "123cba123"))
  (is (= (reverseLonger "" "123") "321"))
  (is (= (reverseLonger "abc" "") "cba")))

