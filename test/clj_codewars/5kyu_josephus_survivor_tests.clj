(ns clj-codewars.5kyu-josephus-survivor-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-josephus-survivor :refer :all]))


(defn testJos [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "josephus-survivor"
    (testJos (josephus-survivor 7 3) 4)
    (testJos (josephus-survivor 11 19) 10)
    (testJos (josephus-survivor 40 3) 28)
    (testJos (josephus-survivor 14 2) 13)
    (testJos (josephus-survivor 100 1) 100)
    (testJos (josephus-survivor 1 300) 1)
    (testJos (josephus-survivor 2 300) 1)
    (testJos (josephus-survivor 5 300) 1)
    (testJos (josephus-survivor 7 300) 7)
    (testJos (josephus-survivor 300 300) 265)))