(ns clj-codewars.beta-a-function-within-a-function-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-a-function-within-a-function :refer :all]))

(deftest always-tests
  (is (= ((always 1)) 1)))