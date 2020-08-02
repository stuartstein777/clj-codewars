(ns clj-codewars.5kyu-human-readable-time-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-human-readable-time :refer :all]))

(deftest Tests
  (is (= (human-readable      0) "00:00:00"))
  (is (= (human-readable     59) "00:00:59"))
  (is (= (human-readable     60) "00:01:00"))
  (is (= (human-readable     90) "00:01:30"))
  (is (= (human-readable  86399) "23:59:59"))
  (is (= (human-readable 359999) "99:59:59")))