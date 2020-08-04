(ns clj-codewars.7kyu-speed-control-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-speed-control :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "gps"
    (def d [0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61])
    (test-assert(gps 20 d) 41)
    (def d [0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25])
    (test-assert(gps 12 d) 219)
    (def d [0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84])
    (test-assert(gps 20 d) 80)))