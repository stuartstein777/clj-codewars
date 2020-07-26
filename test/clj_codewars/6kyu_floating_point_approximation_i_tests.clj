(ns clj-codewars.6kyu-floating-point-approximation-i-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-floating-point-approximation-i :refer :all]))

(defn error [act exp]
  (if (= 0.0 exp)
    (Math/abs act)
    (Math/abs (/ (- act exp) exp))))

(defn test-fuzzy [act exp]
  (let [e (error act exp) inrange (<= e 1e-12)]
    (if (= inrange false)
      (println "Expected value must be near: " exp " but got: " act ". Relative error: " e))
    (is (= inrange true))))

(deftest fpa-1-tests
  (testing "fpa-i"
    (test-fuzzy (fpa-i 2.6e-08) 1.29999999155e-08)
    (test-fuzzy (fpa-i 1.4e-09) 6.999999997549999e-10)
    (test-fuzzy (fpa-i 5.0e-06) 2.499996875007812e-06)
    (test-fuzzy (fpa-i 2.4e-07) 1.1999999280000085e-07)))
