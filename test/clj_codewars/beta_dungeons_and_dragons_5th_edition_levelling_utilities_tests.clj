(ns clj-codewars.beta-dungeons-and-dragons-5th-edition-levelling-utilities-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.beta-dungeons-and-dragons-5th-edition-levelling-utilities :refer :all]))

(deftest current-level-test
  (is (=(current-level 600) :2))
  (is (=(current-level 0) :1)))

(deftest next-level-test
  (is (=(next-level 400) :3))
  (is (=(next-level 0) :2)))

(deftest xp-until-next-level-test
  (is (=(xp-until-next-level 0) 300))
  (is (=(xp-until-next-level 400) 500)))


