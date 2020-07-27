(ns clj-codewars.7kyu-alternate-capitalization-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-alternate-capitlization :refer :all]))

(defn dotest [n ans]
  (is (= (solve-alternate-capitalization n) ans)))

(deftest Example-tests
  (testing "Basic Tests"
    (dotest  "abcdef" ["AbCdEf" "aBcDeF"])
    (dotest  "codewars" ["CoDeWaRs", "cOdEwArS"])
    (dotest "abracadabra" ["AbRaCaDaBrA", "aBrAcAdAbRa"])
    (dotest "indexinglessons" ["InDeXiNgLeSsOnS", "iNdExInGlEsSoNs"])))