(ns clj-codewars.7kyu-character-counter-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-character-counter :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest a-test1
  (testing "find-even-index"
    (println "Fixed Tests validate-word")
    (do-test validate-word "abcabc", true)
    (do-test validate-word "abc123", true)
    (do-test validate-word "abcabcd", false)
    (do-test validate-word "abc!abc!", true)
    (do-test validate-word "abc!abc", false)))