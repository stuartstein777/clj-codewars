(ns clj-codewars.7kyu-share-prices-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-share-prices :refer :all]))

(deftest share-price-tests
  (is (= (share-price 100 []) "100.00"))
  (is (= (share-price 100 [-50 50]) "75.00"))
  (is (= (share-price 100 [-50 100]) "100.00"))
  (is (= (share-price 100 [-20 30]) "104.00"))
  (is (= (share-price 1000 [0 2 3 6]) "1113.64")))
