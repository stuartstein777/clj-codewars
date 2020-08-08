(ns clj-codewars.7kyu-easy-wallpaper-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-easy-wallpaper :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "wallpaper"
    (test-assert(wallpaper 6.3, 4.5, 3.29), "sixteen")
    (test-assert(wallpaper 7.8, 2.9, 3.29), "sixteen")
    (test-assert(wallpaper 6.3, 5.8, 3.13), "seventeen")
    (test-assert(wallpaper 6.1, 6.7, 2.81), "sixteen")
    (test-assert(wallpaper 0.0, 3.5, 3.0), "zero")
    (test-assert(wallpaper 4.0, 3.5, 3.0), "ten")))
