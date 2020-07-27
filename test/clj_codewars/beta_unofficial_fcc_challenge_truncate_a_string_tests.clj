(ns clj-codewars.beta-unofficial-fcc-challenge-truncate-a-string-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-unofficial-fcc-challenge-truncate-a-string :refer :all]))

(deftest truncate-string-test

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket" 11)
         "A-tisket...")
      "should return \"A-tisket...\"")

  (is (= (truncate-string "Peter Piper picked a peck of pickled peppers" 14)
         "Peter Piper...")
      "should return \"Peter Piper...\"")

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket"
                          (count "A-tisket a-tasket A green and yellow basket"))
         "A-tisket a-tasket A green and yellow basket")
      "should return \"A-tisket a-tasket A green and yellow basket\"")

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket"
                          (+ 2 (count "A-tisket a-tasket A green and yellow basket")))
         "A-tisket a-tasket A green and yellow basket")
      "should return \"A-tisket a-tasket A green and yellow basket\"")

  (is (= (truncate-string "A-" 1)
         "A...")
      "should return \"A...\"")

  (is (= (truncate-string "Absolutely Longer" 2)
         "Ab...")
      "should return \"Ab...\""))
