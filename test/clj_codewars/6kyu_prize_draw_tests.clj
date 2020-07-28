(ns clj-codewars.6kyu-prize-draw-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-prize-draw :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is  (= "Benjamin" (rank "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin", [4, 2, 1, 4, 3, 1, 2], 4)))
    (is  (= "Matthew" (rank "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden", [1, 3, 5, 5, 3, 6], 2)))
    (is (= "Willaim" (rank "William,Willaim,Olivia,Olivai,Lily,Lyli" [1 1 1 1 1 1] 1)))
    (is (= "Not enough participants" (rank "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin" [4 2 1 4 3 1 2] 8)))
    (is (= "No participants" (rank "" [1 1 1 1 1 1] 1)))))