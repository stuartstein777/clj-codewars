(ns clj-codewars.8kyu-how-many-lightsabers-do-you-own-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-how-many-lightsabers-do-you-own :refer :all]))

(deftest Testing-lightsaber-count
  (is (= (howManyLightsabersDoYouOwn"") 0) "Blank string should return 0")
  (is (= (howManyLightsabersDoYouOwn "Adam") 0) "Other names should return 0")
  (is (= (howManyLightsabersDoYouOwn "Zach") 18) "Zach should return 18"))