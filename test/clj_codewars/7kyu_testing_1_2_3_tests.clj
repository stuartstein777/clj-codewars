(ns clj-codewars.7kyu-testing-1-2-3-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-testing-1-2-3 :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest testing-1-2-3-tests
  (do-test number [] [])
  (do-test number ["a" "b" "c"] ["1: a" "2: b" "3: c"])
  (do-test number ["" "" "" "" ""] ["1: " "2: " "3: " "4: " "5: "]))