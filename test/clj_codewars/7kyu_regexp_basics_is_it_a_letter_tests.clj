(ns clj-codewars.7kyu-regexp-basics-is-it-a-letter-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-regexp-basics-is-it-a-letter :refer :all]))

(deftest letter?-tests
  (testing "letter"
    (doseq [s ["a" "X"]]
      (testing (prn-str s)
        (is (true? (letter? s))))))
  (testing "non-letter"
    (doseq [s ["" "7" "*" "ab" "a\n"]]
      (testing (prn-str s)
        (is (false? (letter? s)))))))
