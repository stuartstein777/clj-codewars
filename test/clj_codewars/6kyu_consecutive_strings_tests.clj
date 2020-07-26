(ns clj-codewars.6kyu-consecutive-strings-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-consecutive-strings :refer :all]))

(deftest consecutive-string-tests
  (is (= "abigailtheta"
         (longest-cons ["zone", "abigail", "theta", "form", "libe", "zas"]  2)))
  (is (= "oocccffuucccjjjkkkjyyyeehh"
         (longest-cons ["ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"] 1)))
  (is (= "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
         (longest-cons ["itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"] 2)))
  (is (= "wlwsasphmxxowiaxujylentrklctozmymu"
         (longest-cons ["wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"] 2)))
  (is (= ""
         (longest-cons ["zone", "abigail", "theta", "form", "libe", "zas"] -2)))
  (is (= "ixoyx3452zzzzzzzzzzzz"
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 3)))
  (is (= ""
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 15)))
  (is (= ""
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 0))))
