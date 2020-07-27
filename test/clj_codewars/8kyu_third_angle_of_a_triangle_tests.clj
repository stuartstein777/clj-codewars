(ns clj-codewars.8kyu-third-angle-of-a-triangle-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-third-angle-of-a-triangle :refer :all]))

(deftest a-test1-third-angle-of-a-triangle
  (testing "Test 1"
    (let [a 30
          b 60
          c 90]
      (is (= (third-angle a b) c)))))
