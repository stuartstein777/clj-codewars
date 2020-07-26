(ns clj-codewars.6kyu-which-are-in-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-which-are-in :refer :all]))

(deftest which-are-in-test
  (is (= ["love" "olp" "string"] (in-array ["olp" "love" "string" "xyz"] ["ulove" "alove" "holp" "sholp" "vfmstring"])))
  (is (= ["duplicates"] (in-array ["duplicates" "duplicates"] ["duplicates"])))
  (is (= [] (in-array ["abc" "zyz"] ["zdf" "jfk" "hfi"]))))

