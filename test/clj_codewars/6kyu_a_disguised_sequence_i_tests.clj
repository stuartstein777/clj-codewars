(ns clj-codewars.6kyu-a-disguised-sequence-i-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-a-disguised-sequence-i :refer :all]))

(defn do-test [fn s expect]
  (let [actual (fn s)]
    (is (= actual expect))))

(deftest a-test1-disguised-sequence
  (testing "fcn"
    (do-test fcn 17 131072)
    (do-test fcn 21 2097152)
    (do-test fcn 14 16384)
    (do-test fcn 43 8796093022208)
    (do-test fcn 19 524288)))