(ns clj-codewars.7kyu-which-section-did-you-scroll-to-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-which-section-did-you-scroll-to :refer :all]))

(defn tester-get-section [y s exp]
  (testing (str "(get-section-id " y " " s ")")
    (is (= (get-section-id y s) exp))))

(deftest basic-tests-get-section
  (tester-get-section 1 [300 200 400 600 100] 0)
  (tester-get-section 299 [300 200 400 600 100] 0)
  (tester-get-section 300 [300 200 400 600 100] 1)
  (tester-get-section 1599 [300 200 400 600 100] 4)
  (tester-get-section 1600 [300 200 400 600 100] -1))