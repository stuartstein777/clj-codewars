(ns clj-codewars.8kyu-grasshopper-personalized-message-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu-grasshopper-personalized-message :refer [greet]]))

(defn tester-personalised-message [a b exp]
  (testing (str "(greet \"" a "\" \"" b "\")")
    (is (= (greet a b) exp))))

(deftest basic-tests-personalised-message
  (tester-personalised-message "Daniel" "Daniel" "Hello boss")
  (tester-personalised-message "Greg" "Daniel" "Hello guest"))


