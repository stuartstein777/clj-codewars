(ns clj-codewars.8kyu-century-from-year-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-century-from-year :refer :all]))

(deftest century-from-year-tests
  (testing "Year 1705"
    (is (= (century 1705) 18)))
  (testing "Year 1900"
    (is (= (century 1900) 19)))
  (testing "Year 1601"
    (is (= (century 1601) 17)))
  (testing "Year 2000"
    (is (= (century 2000) 20))))