(ns clj-codewars.8kyu-whats-up-next-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-whats-up-next :refer :all]))

(deftest whats-up-next-tests
  (is (= (next-item (range 1 25) 12) 13))
  (is (= (next-item "testing" \t) \e))
  (is (nil? (next-item [:a :b :c] :d)))
  (is (nil? (next-item [:a :b :c] :c))))