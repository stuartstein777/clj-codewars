(ns clj-codewars.beta-car-depreciation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-car-depreciation :refer :all]))

(def test-values [[10000     1  "8000.00"]
                  [5681      2  "3635.84"]
                  [8000      3  "4608.00"]])

(deftest car-value-tests
  (doseq [[price years value] test-values]
    (is
      (= (car price years) value))))