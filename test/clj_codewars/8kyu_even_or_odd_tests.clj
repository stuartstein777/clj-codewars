(ns clj-codewars.8kyu-even-or-odd-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-even-or-odd :refer :all]))

(deftest even-or-odd-tests
  (is (= (even-or-odd 2) "Even"))
  (is (= (even-or-odd 0) "Even"))
  (is (= (even-or-odd 7) "Odd"))
  (is (= (even-or-odd 1) "Odd"))
  (is (= (even-or-odd -1) "Odd")))
