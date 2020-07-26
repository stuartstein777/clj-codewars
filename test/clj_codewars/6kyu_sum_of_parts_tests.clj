(ns clj-codewars.6kyu-sum-of-parts-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-sum-of-parts :refer :all]))

(deftest sum-of-parts-tests
  (testing "parts-sums"
    (is (= (parts-sums '()) '(0)))
    (is (= (parts-sums '(0 1 3 6 10)) '(20 20 19 16 10 0)))
    (is (= (parts-sums '(1 2 3 4 5 6)) '(21 20 18 15 11 6 0)))
    (is (= (parts-sums '(744125 935 407 454 430 90 144 6710213 889 810 2579358))
           '(10037855 9293730 9292795 9292388 9291934 9291504 9291414 9291270 2581057 2580168 2579358 0)))))
