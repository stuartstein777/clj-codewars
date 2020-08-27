(ns clj-codewars.6kyu-Srot-the-inner-ctonnet-in-dsnnieedcg-oredr-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-Srot-the-inner-ctonnet-in-dsnnieedcg-oredr :refer :all]))

(deftest sample-tests
  (is (= (sort-the-inner-content "sort the inner content in descending order") "srot the inner ctonnet in dsnnieedcg oredr"))
  (is (= (sort-the-inner-content "wait for me") "wiat for me"))
  (is (= (sort-the-inner-content "this kata is easy") "tihs ktaa is esay"))
  (is (= (sort-the-inner-content "mind the     spaaaace ") "mnid the     spcaaaae "))
  (is (= (sort-the-inner-content "this is a test") "tihs is a tset"))
  (is (= (sort-the-inner-content "a") "a"))
  (is (= (sort-the-inner-content "  a ") "  a "))
  (is (= (sort-the-inner-content "a b c") "a b c"))
  (is (= (sort-the-inner-content " a b  c   ") " a b  c   "))
  (is (= (sort-the-inner-content "ab") "ab"))
  (is (= (sort-the-inner-content " ab") " ab"))
  (is (= (sort-the-inner-content "ab cd ef") "ab cd ef"))
  (is (= (sort-the-inner-content " ab  cd  ef ") " ab  cd  ef "))
  (is (= (sort-the-inner-content " abc def ") " abc def ")))