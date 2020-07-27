(ns clj-codewars.8kyu-my-head-is-at-the-wrong-end-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-my-head-is-at-the-wrong-end :refer [fix-the-meerkat]]))

(defn tester-head-is-at-wrong-end [a exp]
  (testing (str "Testing for " a)
    (is (= (fix-the-meerkat a) exp))))

(deftest basic-tests-head-is-at-wrong-end
  (tester-head-is-at-wrong-end ["tail" "body" "head"] ["head" "body" "tail"])
  (tester-head-is-at-wrong-end ["tails" "body" "heads"] ["heads" "body" "tails"])
  (tester-head-is-at-wrong-end ["bottom" "middle" "top"] ["top" "middle" "bottom"])
  (tester-head-is-at-wrong-end ["lower legs" "torso" "upper legs"] ["upper legs" "torso" "lower legs"])
  (tester-head-is-at-wrong-end ["ground" "rainbow" "sky"] ["sky" "rainbow" "ground"]))
