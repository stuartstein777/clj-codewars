(ns clj-codewars.4kyu-recover-a-secret-string-from-random-triplets-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.4kyu-recover-a-secret-string-from-random-triplets :refer :all]))

(deftest solve
  (is (= (recover-secret ["tup" "whi" "tsu" "ats" "hap" "tis" "whs"]) "whatisup")))
