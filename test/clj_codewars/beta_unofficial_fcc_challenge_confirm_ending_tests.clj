(ns clj-codewars.beta-unofficial-fcc-challenge-confirm-ending-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-confirm-ending :refer :all]))

(deftest basic-tests
  (with-redefs
    [clojure.string/capitalize
     (fn [& _]
       (throw (Exception. "Sorry! The ends-with? built-in is disabled for this kata!")))]

    (is (confirm-ending "Bastian" "n")
        "should return true")

    (is (not (confirm-ending "Connor" "n"))
        "should return false")

    (is (not (confirm-ending "Walking on water and developing software from a specification are easy if both are frozen"
                             "specification"))
        "should return false")

    (is (confirm-ending "He has to give me a new name" "name")
        "should return true")

    (is (confirm-ending "Open sesame" "same")
        "should return true")

    (is (not (confirm-ending "Open sesame", "pen"))
        "should return false")

    (is (not (confirm-ending "If you want to save our world, you must hurry. We dont know how much longer we can withstand the nothing"
                             "mountain"))
        "should return false")))
