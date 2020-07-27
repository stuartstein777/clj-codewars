(ns clj-codewars.7kyu-drying-potatoes-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-drying-potatoes :refer :all]))

(defn dotest-potatoes [p0 w0 p1 sol]
  (is (= (potatoes p0 w0 p1) sol)))

(deftest a-test
  (println "Basic Tests")
  (dotest-potatoes 82 127 80 114)
  (dotest-potatoes 93 129 91 100))
