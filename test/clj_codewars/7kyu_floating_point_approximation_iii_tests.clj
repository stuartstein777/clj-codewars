(ns clj-codewars.7kyu-floating-point-approximation-iii-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-floating-point-approximation-iii :refer :all]))

(defn- error [act merr]
  (< (Math/abs act) merr))
(defn- calc [a b c x] (+ (* a x x) (* b x) c))

(defn test-fuzzy [a b c]
  (println "Testing " a b c)
  (let [merr 1e-12
        x (quadratic a b c)
        good-one (< (Math/abs x) 1.e-1)
        actual (calc a b c x)
        inrange (error actual merr)]
    (if (not good-one)
      (println "This root is not the good one")
      (if (not (and good-one inrange))
        (println "Expected value must be near: " 0.0 ", got: " actual)))
    (is (= (and good-one inrange) true))))

(deftest a-test1
  (testing "quadratic"
    (test-fuzzy 9, 1.00e+14, 1)
    (test-fuzzy 3, 3.00e+09, 1)
    (test-fuzzy 7, 4.00e+09, 7)
    (test-fuzzy 5, 5.00e+13, 3)))


