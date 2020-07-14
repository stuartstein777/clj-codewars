(ns clj-codewars.core-test
  (:require [clojure.test :refer :all]
            [clj-codewars.core :refer :all]
            [clj-codewars.4kyu :refer :all]
            [clj-codewars.beta :refer :all]))

(deftest solve
  (is (= (recover-secret ["tup" "whi" "tsu" "ats" "hap" "tis" "whs"]) "whatisup")))


