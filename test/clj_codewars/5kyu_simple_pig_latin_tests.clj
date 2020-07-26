(ns clj-codewars.5kyu-simple-pig-latin-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-simple-pig-latin :refer :all]))

(deftest pig-latin-example-test
  (is (= (pig-it "Pig latin is cool") "igPay atinlay siay oolcay")))

(deftest pig-latin-example-test
  (is (= (pig-it "This is my string") "hisTay siay ymay tringsay")))
