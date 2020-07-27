(ns clj-codewars.7kyu-simple-fun-152-invite-more-women-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-simple-fun-152-invite-more-women :refer :all]))

(defn tester-invite-more-women [l e]
  (testing (str "Testing for " l)
    (is (= (invite-more-women l) e))))

(deftest basic-tests-invite-more-women
  (tester-invite-more-women [1 -1 1] true)
  (tester-invite-more-women [-1 -1 -1] false)
  (tester-invite-more-women [1 -1] false)
  (tester-invite-more-women [1 1 1] true))
