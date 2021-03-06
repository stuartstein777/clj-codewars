(ns clj-codewars.7kyu-consecutive-ducks-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-consecutive-ducks :refer :all]))

(defn tester-cd [n exp]
  (testing (str "Testing for " n)
    (is (= (consecutive-ducks n) exp))))

(deftest check-small-values
  (tester-cd 69 true)
  (tester-cd 8 false)
  (tester-cd 57 true)
  (tester-cd 6 true)
  (tester-cd 13 true)
  (tester-cd 16 false)
  (tester-cd 91 true)
  (tester-cd 75 true)
  (tester-cd 38 true)
  (tester-cd 25 true)
  (tester-cd 32 false)
  (tester-cd 65 true)
  (tester-cd 13 true)
  (tester-cd 16 false)
  (tester-cd 99 true))

(deftest check-medium-values
  (tester-cd 522 true)
  (tester-cd 974 true)
  (tester-cd 755 true)
  (tester-cd 512 false)
  (tester-cd 739 true)
  (tester-cd 1006 true)
  (tester-cd 838 true)
  (tester-cd 1092 true)
  (tester-cd 727 true)
  (tester-cd 648 true)
  (tester-cd 1024 false)
  (tester-cd 851 true)
  (tester-cd 541 true)
  (tester-cd 1011 true)
  (tester-cd 822 true))

(deftest check-large-values
  (tester-cd 382131 true)
  (tester-cd 118070 true)
  (tester-cd 17209 true)
  (tester-cd 32768 false)
  (tester-cd 161997 true)
  (tester-cd 400779 true)
  (tester-cd 198331 true)
  (tester-cd 325482 true)
  (tester-cd 88441 true)
  (tester-cd 648 true)
  (tester-cd 65536 false)
  (tester-cd 323744 true)
  (tester-cd 183540 true)
  (tester-cd 65271 true)
  (tester-cd 5263987 true))
