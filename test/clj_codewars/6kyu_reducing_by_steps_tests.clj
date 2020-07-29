(ns clj-codewars.6kyu-reducing-by-steps-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-reducing-by-steps :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "Basic test 1"
    ;(def a [18, 69, -90, -78, 65, 40])
    ;(test-assert (oper-array gcdi a (a 0)) [18, 3, 3, 3, 1, 1])
    ;(test-assert (oper-array lcmu a (a 0)) [18, 414, 2070, 26910, 26910, 107640])
    ;(test-assert (oper-array som a 0) [18, 87, -3, -81, -16, 24])
    ;(test-assert (oper-array mini a (a 0)) [18, 18, -90, -90, -90, -90])
    ;(test-assert (oper-array maxi a (a 0)) [18, 69, 69, 69, 69, 69])
    ;(test-assert (oper-array lcmu [-73 -79 19 -15 99 84] -73) [ 73 5767 109573 1643595 54238635 1518681780 ])

    (is (= [53 4399 237546 6888834 68888340 964436760 18324298440 18324298440]
           (oper-array lcmu [53 83 54 -58 -20 56 57 10] 53)))))

;
