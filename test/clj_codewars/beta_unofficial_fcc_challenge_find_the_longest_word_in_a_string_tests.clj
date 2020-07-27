(ns clj-codewars.beta-unofficial-fcc-challenge-find-the-longest-word-in-a-string-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-find-the-longest-word-in-a-string :refer :all]))

(deftest basic-tests

  (is (number? (find-longest-word "The quick brown fox jumped over the lazy dog"))
      "should return a number")

  (is (= (find-longest-word "The quick brown fox jumped over the lazy dog")
         6)
      "should return 6")

  (is (= (find-longest-word "May the force be with you")
         5)
      "should return 5")

  (is (= (find-longest-word "Google do a barrel roll")
         6)
      "should return 6")

  (is (= (find-longest-word "What is the average airspeed velocity of an unladen swallow")
         8)
      "should return 8")

  (is (= (find-longest-word "What if we try a super-long word such as otorhinolaryngology")
         19)
      "should return 19"))

