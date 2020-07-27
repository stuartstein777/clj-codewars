(ns clj-codewars.7kyu-char-code-calculation-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-char-code-calculation :refer :all]))

(deftest sample-tests
  (are [inp exp] (= exp (calc inp))
                 "ABC" 6
                 "abcdef" 6
                 "ifkhchlhfd" 6
                 "aaaaaddddr" 30
                 "jfmgklf8hglbe" 6
                 "jaam" 12))
