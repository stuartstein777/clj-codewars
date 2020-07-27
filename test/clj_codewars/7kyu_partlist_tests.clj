(ns clj-codewars.7kyu-partlist-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-partlist :refer :all]))

(defn test-assert-parts-of-a-list [act exp]
  (is (= act exp)))

(deftest a-test1-parts-of-a-list
  (testing "partlist"
    (test-assert-parts-of-a-list (partlist ["I", "wish", "I", "hadn't", "come"]),
                                 '[("I", "wish I hadn't come"), ("I wish", "I hadn't come"), ("I wish I", "hadn't come"), ("I wish I hadn't", "come")])
    (test-assert-parts-of-a-list (partlist ["cdIw", "tzIy", "xDu", "rThG"]),
                                 '[("cdIw", "tzIy xDu rThG"), ("cdIw tzIy", "xDu rThG"), ("cdIw tzIy xDu", "rThG")])
    (test-assert-parts-of-a-list (partlist ["vJQ", "anj", "mQDq", "sOZ"]),
                                 '[("vJQ", "anj mQDq sOZ"), ("vJQ anj", "mQDq sOZ"), ("vJQ anj mQDq", "sOZ")])))
