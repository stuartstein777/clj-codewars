(ns clj-codewars.7kyu-homogenous-arrays-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-homogenous-arrays :refer :all]))

(deftest sample-tests
  (is (= (filter-homogenous [[1 5 4] [\a 3 5] [\b] [] [\1 2 3]])
         [[1 5 4] [\b]]))
  (is (= (filter-homogenous [[123 234 432] ["" "abc"] [""] ["" 1] ["" "1"] []])
         [[123 234 432] ["" "abc"] [""] ["" "1"]]))
  (is (= (filter-homogenous [() [] ["a"] ["b"] ["c"]])
         [["a"] ["b"] ["c"]]))
  (is (= (filter-homogenous (list [] [1 2 3] ["z" \z] ["z"])) (list [1 2 3] ["z"])))
  (is (= (filter-homogenous [[{}] [#{} #{}]]) [[{}] [#{} #{}]])))
