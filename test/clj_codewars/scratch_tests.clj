(ns clj-codewars.scratch-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.scratch :refer :all]))

(deftest split-section-along-x-tests
  (testing "splitting x at 2"
    (is (= [[[0 0] [1 4]] [[3 0] [4 4]]] (split-section-along-x [[0 0] [4 4]] 2))))
  (testing "splitting x at 1"
    (is (= [[[0 0] [0 4]] [[2 0] [4 4]]] (split-section-along-x [[0 0] [4 4]] 1))))
  (testing "splitting x at 3"
    (is (= [[[0 0] [2 4]] [[4 0] [4 4]]] (split-section-along-x [[0 0] [4 4]] 3))))
  (testing "splitting x at 4")
  (is (= [[[0 0] [0 5]] [[2 0] [3 5]]] (split-section-along-x [[0 0] [3 5]] 1)))
  (is (= [[1 0] [4 4]] (split-section-along-x [[0 0] [4 4]] 0)))
  (is (= [[0 0] [3 3]] (split-section-along-x [[0 0] [4 4]] 4))))

(deftest split-section-along-y-tests
  (is (= [[1 0] [4 4]] (split-section-along-y [[0 0] [4 4]] 0)))
  (is (= [[0 0] [4 3]] (split-section-along-y [[0 0] [4 4]] 4)))
  (is (= [[[0 0] [4 0]] [[0 2] [4 4]]] (split-section-along-y [[0 0] [4 4]] 1)))
  (is (= [[[0 0] [4 1]] [[0 3] [4 4]]] (split-section-along-y [[0 0] [4 4]] 2)))
  (is (= [[[0 0] [4 2]] [[0 4] [4 4]]] (split-section-along-y [[0 0] [4 4]] 3)))
  (is (= [[[0 0] [3 1]] [[0 3] [3 5]]] (split-section-along-y [[0 0] [3 5]] 2))))

(deftest can-section-be-split-tests
  (testing "[[0 0] [2 2]] can be split along x"
    (is (= true (can-section-be-split? [[0 0] [2 2]] :x))))
  (testing "testing [[0 0] [1 1]] can not be split along x"
    (is (= false (can-section-be-split? [[0 0] [1 1]] :x))))
  (testing "testing [[0 0] [1 1]] can not be split along y"
    (is (= false (can-section-be-split? [[0 0] [1 1]] :y)))))

