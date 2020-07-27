(ns clj-codewars.7kyu-computer-problem-series-1-fill-hard-disk-drive-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-computer-problem-series-1-fill-hard-disk-drive :refer :all]))

(deftest basic-tests
  (is (= (save [4 4 4 3 3] 12) 3))
  (is (= (save [4 4 4 3 3] 11) 2))
  (is (= (save [4 8 15 16 23 42] 108) 6))
  (is (= (save [13] 13) 1))
  (is (= (save [1 2 3 4] 250) 4))
  (is (= (save [100] 500) 1))
  (is (= (save [11 13 15 17 19] 8) 0))
  (is (= (save [45] 12) 0)))
