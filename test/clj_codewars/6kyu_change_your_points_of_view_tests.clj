(ns clj-codewars.6kyu-change-your-points-of-view-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-change-your-points-of-view :refer :all]))

(defn- dotest1-pov [a b]
  (let [actual1 (point a b)
        actual2 (fst (point a b))
        actual3 (snd (point a b))
        ]
    (is (= (fn? actual1) true))
    (is (= actual2 a))
    (is (= actual3 b))
    ))

(defn- dotest2-pov [a1 b1 a2 b2 expect]
  (let [actual (sqr-dist (point a1 b1) (point a2 b2))]
    (is (= actual expect))
    ))
(defn- dotest3-pov [a1 b1 a2 b2 expect]
  (defn- detAC [a b c d]
    (- (* a d) (* b c)))
  (defn- line-equalAC? [line1 line2]
    (let [[l1 m1 n1] line1
          [l2 m2 n2] line2
          ]
      (and (not= line1 '(0 0 0))
           (= 0 (detAC l1 m1 l2 m2))
           (= 0 (detAC m1 n1 m2 n2))
           (= 0 (detAC l1 n1 l2 n2)))))
  (let [actual (line (point a1 b1) (point a2 b2))]
    (is (= (line-equalAC? actual expect) true))))

(deftest a-test1-pov
  (testing "point"
    (dotest1-pov 3 5)
    (dotest1-pov  81 45)))

(deftest a-test2
  (testing "point sqr-dist"
    (dotest2-pov 22 55 75 66 2930)
    (dotest2-pov 11 22 65 44 3400)))

(deftest a-test3
  (testing "point tests line"
    (dotest3-pov 20 22 29 10 (list 12 9 -438))
    (dotest3-pov 38 32 14 8 (list 24 -24 -144))))
