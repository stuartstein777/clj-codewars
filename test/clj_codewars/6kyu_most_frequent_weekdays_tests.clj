(ns clj-codewars.6kyu-most-frequent-weekdays-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-most-frequent-weekdays :refer :all]))

(deftest most-frequent-weekdays-tests
  (is (= ["Friday" "Saturday"] (most-frequent-weekdays 2016)))
  (is (= ["Sunday" "Monday"] (most-frequent-weekdays 1984)))
  (is (= ["Monday"] (most-frequent-weekdays 1770)))
  (is (= ["Monday"] (most-frequent-weekdays 2001)))
  (is (= ["Monday" "Tuesday"] (most-frequent-weekdays 1968)))
  (is (= ["Saturday"] (most-frequent-weekdays 1785)))
  (is (= ["Saturday"] (most-frequent-weekdays 1910)))
  (is (= ["Saturday"] (most-frequent-weekdays 2135)))
  (is (= ["Sunday"] (most-frequent-weekdays 3043)))
  (is (= ["Sunday"] (most-frequent-weekdays 3150)))
  (is (= ["Thursday"] (most-frequent-weekdays 3361)))
  (is (= ["Tuesday"] (most-frequent-weekdays 1901)))
  (is (= ["Tuesday"] (most-frequent-weekdays 3230)))
  (is (= ["Wednesday"] (most-frequent-weekdays 1794)))
  (is (= ["Wednesday"] (most-frequent-weekdays 1986))))
