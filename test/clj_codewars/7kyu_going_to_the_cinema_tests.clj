(ns clj-codewars.7kyu-going-to-the-cinema-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-going-to-the-cinema :refer [movie]]))


(deftest a-test1
  (testing "movie"
    (is (= (movie 500, 15, 0.9) 43))
    (is (= (movie 100, 10, 0.95) 24))))