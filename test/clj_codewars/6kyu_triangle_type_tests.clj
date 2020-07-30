(ns clj-codewars.6kyu-triangle-type-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-triangle-type :refer :all]))

(deftest simple-all
  (is (== (triangle-type 7 3 2) 0))                         ; Not triangle
  (is (== (triangle-type 2 4 6) 0))                         ; Not triangle
  (is (== (triangle-type 8 5 7) 1))                         ; Acute
  (is (== (triangle-type 3 4 5) 2))                         ; Right
  (is (== (triangle-type 7 12 8) 3))                        ; Obtuse
  (is (= (triangle-type 105 100 6) 3))                      ; Obtuse
  (is (= (triangle-type 65 55 33) 3)))                       ; Obtuse