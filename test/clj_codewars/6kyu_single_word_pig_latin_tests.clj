(ns clj-codewars.6kyu-single-word-pig-latin-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-single-word-pig-latin :refer :all]))

(deftest pig-latin-test
  (is (= (pig-latin "map") "apmay"))
  (is (= (pig-latin "egg") "eggway"))
  (is (= (pig-latin "tes3t5") nil))
  (is (= (pig-latin "YA") "ayay"))
  (is (= (pig-latin "") "")))