(ns clj-codewars.7kyu-scaling-squared-strings-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-scaling-squared-strings :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "scale"
    (def a "abcd\nefgh\nijkl\nmnop")
    (def r (str "aabbccdd\naabbccdd\naabbccdd\neeffgghh\neeffgghh\neeffgghh\niijjkkll\niijjkkll\niijjkkll\n"
                "mmnnoopp\nmmnnoopp\nmmnnoopp"))
    (test-assert (scale a 2 3) r)
    (test-assert(scale "", 5, 5), "")
    (test-assert(scale "Kj\nSH", 1, 2),"Kj\nKj\nSH\nSH")))