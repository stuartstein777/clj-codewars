(ns clj-codewars.6kyu-mexican-wave-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-mexican-wave :refer :all]))

(deftest sample-test-cases
  (testing "with non-letter characters"
    (is (= (wave "a       b    ") ["A       b    " "a       B    "])))
  (testing "with multiple words"
    (is (= (wave "this is a few words")
           ["This is a few words" "tHis is a few words" "thIs is a few words" "thiS is a few words" "this Is a few words" "this iS a few words" "this is A few words" "this is a Few words" "this is a fEw words" "this is a feW words" "this is a few Words" "this is a few wOrds" "this is a few woRds" "this is a few worDs" "this is a few wordS"])))
  (testing "with an empty string"
    (is (= (wave "") [])))
  (testing "with whitespace around the string"
    (is (= (wave " gap ") [" Gap " " gAp " " gaP "]))))
