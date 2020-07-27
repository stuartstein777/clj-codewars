(ns clj-codewars.7kyu-complementary-dna-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-complementary-dna :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest complementary-dna-tests
  (do-test dna-strand "ATCG" "TAGC"))