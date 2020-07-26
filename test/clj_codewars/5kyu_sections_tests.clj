(ns clj-codewars.5kyu-sections-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-sections :refer :all]))

(defn dotest [f n exp]
  (is (= (f n) exp)))

(deftest a-test1
  (testing "c (fixed 1)"
    (dotest sections 1 1)
    (dotest sections 4 4)
    (dotest sections 4096576 160)
    (dotest sections 2019 0)
    (dotest sections 423128 0)
    (dotest sections 1369 4)
    (dotest sections 2999824 28)
    (dotest sections 11710084 64)
    (dotest sections 14830201 4)))
