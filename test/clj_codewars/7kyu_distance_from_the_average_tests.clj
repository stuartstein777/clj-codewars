(ns clj-codewars.7kyu-distance-from-the-average-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-distance-from-the-average :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest distances-from-average-tests
  (testing "distances-from-average"
    (do-test distances-from-average [55, 95, 62, 36, 48] [4.2, -35.8, -2.8, 23.2, 11.2])
    (do-test distances-from-average [1, 1, 1, 1, 1] [0.0, 0.0, 0.0, 0.0, 0.0])
    (do-test distances-from-average [1, -1, 1, -1, 1, -1] [-1.0, 1.0, -1.0, 1.0, -1.0, 1.0])
    (do-test distances-from-average [1, -1, 1, -1, 1] [-0.8, 1.2, -0.8, 1.2, -0.8])
    (do-test distances-from-average [2, -2] [-2.0, 2.0])
    (do-test distances-from-average [123 -65 32432 -353 -534] [6197.6 6385.6 -26111.4 6673.6 6854.6])))
