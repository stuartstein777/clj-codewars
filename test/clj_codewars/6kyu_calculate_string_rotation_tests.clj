(ns clj-codewars.6kyu-calculate-string-rotation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-calculate-string-rotation :refer :all]))

(deftest example-tests
  (are [s1 s2 answer] (= (shifted-diff s1 s2) answer)
                      "hoop" "pooh" -1
                      "coffee" "eecoff" 2
                      "eecoff" "coffee" 4
                      ))
