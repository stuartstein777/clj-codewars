(ns clj-codewars.6kyu-parse-html-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-parse-html :refer :all]))

(deftest example-tests-parse-html
  (is (= (parse-html-color "#80FFA0")   {:r 128 :g 255 :b 160}))
  (is (= (parse-html-color "#3B7")      {:r 51  :g 187 :b 119}))
  (is (= (parse-html-color "LimeGreen") {:r 50  :g 205 :b 50})))
