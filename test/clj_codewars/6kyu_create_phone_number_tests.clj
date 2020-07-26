(ns clj-codewars.6kyu-create-phone-number-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-create-phone-number :refer :all]))

(deftest create-phone-number-tests
  (is (= (create-phone-number [1 2 3 4 5 6 7 8 9 0]) "(123) 456-7890"))
  (is (= (create-phone-number [1 1 1 1 1 1 1 1 1 1]) "(111) 111-1111"))
  (is (= (create-phone-number [4 7 8 1 5 7 9 9 7 1]) "(478) 157-9971"))
  (is (= (create-phone-number [7 8 0 2 2 1 7 5 1 3]) "(780) 221-7513")))
