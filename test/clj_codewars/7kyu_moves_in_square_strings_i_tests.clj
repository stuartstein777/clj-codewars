(ns clj-codewars.7kyu-moves-in-square-strings-i-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-moves-in-square-strings-i :refer :all]))

(deftest oper-vert-mirror-tests
  (testing "vert-mirror"
    (is (= (oper vert-mirror "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"),
           "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw")))
  (testing "hor-mirror"
    (is (= (oper hor-mirror "lVHt\nJVhv\nCSbg\nyeCt"),
           "yeCt\nCSbg\nJVhv\nlVHt"))))
