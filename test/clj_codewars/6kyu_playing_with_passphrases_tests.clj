(ns clj-codewars.6kyu-playing-with-passphrases-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-playing-with-passphrases :refer :all]))

(deftest playing-with-passphrases-tests
  (is (= (play-pass "I LOVE YOU!!!" 1) "!!!vPz fWpM J"))
  (is (= (play-pass "BORN IN 2015!" 1) "!4897 Oj oSpC"))
  (is (= (play-pass "MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015" 2)
         "4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO")))