(ns clj-codewars.7kyu-product-of-maximums-of-array-array-series-2-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-product-of-maximums-of-array-array-series-2 :refer :all]))

(defn tester [a s r]
  (testing (str "(max-product " a " " s ")")
    (is (= (max-product a s) r))))

(deftest basic-tests
  (tester [4 3 5] 2 20)
  (tester [10 8 7 9] 3 720)
  (tester [8 6 4 6] 3 288)
  (tester [10 2 3 8 1 10 4] 5 9600)
  (tester [13 12 -27 -302 25 37 133 155 -14] 5 247895375)
  (tester [-4 -27 -15 -6 -1] 2 4)
  (tester [-17 -8 -102 -309] 2 136)
  (tester [10 3 -27 -1] 3 -30)
  (tester [14 29 -28 39 -16 -48] 4 -253344)
  (tester [1] 1 1))