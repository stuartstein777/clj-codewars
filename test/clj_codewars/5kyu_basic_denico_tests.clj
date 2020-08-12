(ns clj-codewars.5kyu-basic-denico-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-basic-denico :refer :all]))

(deftest basic-tests
  (is (= "secretinformation" (denico "crazy" "cseerntiofarmit on  ")))
  (is (= "secretinformation" (denico "crazy" "cseerntiofarmit on")))
  (is (= "abcd" (denico "abc" "abcd")))
  (is (= "1234567890" (denico "ba" "2143658709")))
  (is (= "message" (denico "a" "message")))
  (is (= "key" (denico "key" "eky"))))