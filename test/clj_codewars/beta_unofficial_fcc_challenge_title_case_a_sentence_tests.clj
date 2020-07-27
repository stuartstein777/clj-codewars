(ns clj-codewars.beta-unofficial-fcc-challenge-title-case-a-sentence-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-title-case-a-sentence :refer :all]))

(deftest basic-tests
  (with-redefs
    [clojure.string/capitalize
     (fn [& _]
       (throw (Exception. "Sorry! The capitalize built-in is disabled for this kata!")))]

    (is (string? (title-case "I'm a little tea pot"))
        "should return a string")

    (is (= (title-case "I'm a little tea pot")
           "I'm A Little Tea Pot")
        "should return \"I'm A Little Tea Pot\"")

    (is (= (title-case "sHoRt AnD sToUt")
           "Short And Stout")
        "should return \"Short And Stout\"")

    (is (= (title-case "HERE IS MY HANDLE HERE IS MY SPOUT")
           "Here Is My Handle Here Is My Spout")
        "should return  \"Here Is My Handle Here Is My Spout\"")))