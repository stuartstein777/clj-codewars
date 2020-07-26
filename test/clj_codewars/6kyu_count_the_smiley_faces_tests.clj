(ns clj-codewars.6kyu-count-the-smiley-faces-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-count-the-smily-faces :refer :all]))

(deftest count-the-smiley-face-tests
  (is (= (count-smileys [])  0))
  (is (= (count-smileys [":)"  ";("  ";}"  ":-D"])  2))
  (is (= (count-smileys [";]"  ":["  ";*"  ":$"  ";-D"])  1))
  (is (= (count-smileys [":)" ":(" ":D" ":O" ":;"])  2))
  (is (= (count-smileys [":-)" ";~D" ":-D" ":_D"])  3)))
