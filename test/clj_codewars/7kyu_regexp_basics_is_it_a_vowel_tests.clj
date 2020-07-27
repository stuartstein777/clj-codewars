(ns clj-codewars.7kyu-regexp-basics-is-it-a-vowel-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-regexp-basics-is-it-a-vowel :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest vowel-test
  (testing "Basic Tests"
    (do-test vowel "" false)
    (do-test vowel "a" true)
    (do-test vowel "E" true)
    (do-test vowel "ou" false)
    (do-test vowel "z" false)
    (do-test vowel "lol" false)))