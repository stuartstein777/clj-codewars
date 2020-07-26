(ns clj-codewars.6kyu-basics-08-find-next-higher-number-with-same-bits-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-basics-08-find-next-higher-number-with-same-bits :refer :all]))

(deftest basics-08-tests
  (is (= (next-higher 128) 256))
  (is (= (next-higher 1) 2))
  (is (= (next-higher 1022) 1279))
  (is (= (next-higher 127) 191))
  (is (= (next-higher 1253343) 1253359)))
