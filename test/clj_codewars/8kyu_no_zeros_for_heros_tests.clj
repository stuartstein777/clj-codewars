(ns clj-codewars.8kyu-no-zeros-for-heros-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-no-zeros-for-heros :refer :all]))

(deftest no-zeros-for-heros-tests
  (testing "noboringzeros"
    (is (= (no-boring-zeros 1450) 145))
    (is (= (no-boring-zeros 960000) 96))
    (is (= (no-boring-zeros 1050) 105))
    (is (= (no-boring-zeros -960000) -96))))
