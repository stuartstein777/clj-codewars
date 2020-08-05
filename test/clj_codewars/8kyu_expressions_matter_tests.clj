(ns clj-codewars.8kyu-expressions-matter-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-expressions-matter :refer :all]))

(deftest basic-tests
  (testing "(expression-matter 2 1 2)" (is (= (expression-matter 2 1 2) 6)))
  (testing "(expression-matter 2 1 1)" (is (= (expression-matter 2 1 1) 4)))
  (testing "(expression-matter 1 1 1)" (is (= (expression-matter 1 1 1) 3)))
  (testing "(expression-matter 1 2 3)" (is (= (expression-matter 1 2 3) 9)))
  (testing "(expression-matter 1 3 1)" (is (= (expression-matter 1 3 1) 5)))
  (testing "(expression-matter 2 2 2)" (is (= (expression-matter 2 2 2) 8)))
  (testing "(expression-matter 5 1 3)" (is (= (expression-matter 5 1 3) 20)))
  (testing "(expression-matter 3 5 7)" (is (= (expression-matter 3 5 7) 105)))
  (testing "(expression-matter 5 6 1)" (is (= (expression-matter 5 6 1) 35)))
  (testing "(expression-matter 1 6 1)" (is (= (expression-matter 1 6 1) 8)))
  (testing "(expression-matter 2 6 1)" (is (= (expression-matter 2 6 1) 14)))
  (testing "(expression-matter 6 7 1)" (is (= (expression-matter 6 7 1) 48)))
  (testing "(expression-matter 2 10 3)" (is (= (expression-matter 2 10 3) 60)))
  (testing "(expression-matter 1 8 3)" (is (= (expression-matter 1 8 3) 27)))
  (testing "(expression-matter 9 7 2)" (is (= (expression-matter 9 7 2) 126)))
  (testing "(expression-matter 1 1 10)" (is (= (expression-matter 1 1 10) 20)))
  (testing "(expression-matter 9 1 1)" (is (= (expression-matter 9 1 1) 18)))
  (testing "(expression-matter 10 5 6)" (is (= (expression-matter 10 5 6) 300)))
  (testing "(expression-matter 1 10 1)" (is (= (expression-matter 1 10 1) 12))))