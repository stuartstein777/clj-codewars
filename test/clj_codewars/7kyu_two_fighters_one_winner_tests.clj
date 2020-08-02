(ns clj-codewars.7kyu-two-fighters-one-winner-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-two-fighters-one-winner :refer :all]))

(deftest simple-test
  (is (= "Harald" (declare-winner (->Fighter "Harald" 20 5) (->Fighter "Harry" 5 4))))
  (is (= "Harald" (declare-winner (->Fighter "Harald" 20 5) (->Fighter "Jerry" 30 3)))))