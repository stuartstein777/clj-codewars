(ns clj-codewars.7kyu-ipv4-validator-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-ipv4-validator :refer :all]))

(deftest IPv4-validator-tests
  (testing "Testing how old"
    (is (false? (validate-ip "")))
    (is (false? (validate-ip "12.b.3.a")))
    (is (validate-ip "32.64.128.255"))))
