(ns clj-codewars.handy-functions-test
  (:require [clojure.test :refer :all]
            [clj-codewars.handy-functions :refer :all]))

(deftest aeiou-are-vowels
  (is (= true (is-vowel "a")))
  (is (= true (is-vowel "e")))
  (is (= true (is-vowel "i")))
  (is (= true (is-vowel "o")))
  (is (= true (is-vowel "u"))))
    ()

(deftest other-letters-are-not-vowels
  (is (= false (is-vowel "b")))
  (is (= false (is-vowel "c")))
  (is (= false (is-vowel "d")))
  (is (= false (is-vowel "f")))
  (is (= false (is-vowel "g"))))

(deftest remove-b-from-a-test
  (let [a [1 1 2 2 2 3 3 4 5 6]
        b [3 4]]
    (is (= [1 1 2 2 2 5 6] (remove-b-from-a a b)))))

(deftest number->digits-test
  (is (= [1 2 3 4 5] (number->digits 12345))))

(deftest swap-test
  (is (= (swap [:o :# :#] 0 1) [:# :o :#])))

(deftest gcd-tests
  (is (= 5 (gcd 25 30)))
  (is (= 1 (gcd 19 25))))