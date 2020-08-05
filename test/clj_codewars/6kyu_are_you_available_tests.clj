(ns clj-codewars.6kyu-are-you-available-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-are-you-available :refer :all]))

(deftest check-availability-tests
  (are [schedule current-time answer]
    (= (check-availability schedule current-time) answer)
    [["09:30" "10:15"] ["12:20" "15:50"]] "10:00" "10:15"
    [["09:30" "10:15"] ["12:20" "15:50"]] "11:00" true))