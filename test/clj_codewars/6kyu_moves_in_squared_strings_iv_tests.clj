(ns clj-codewars.6kyu-moves-in-squared-strings-iv-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-moves-in-squared-strings-iv :refer :all]))


(defn test-assert [act exp]
  (is (= act exp)))

(deftest b-test2
  (testing "rot-90-counter"
    (test-assert(oper rot-90-counter "EcGcXJ\naaygcA\nNgIshN\nyOrCZE\neBEqpm\nNkxCgw"),
                "JANEmw\nXchZpg\ncgsCqC\nGyIrEx\ncagOBk\nEaNyeN")
    ))
(deftest b-test4
  (testing "diag-2-sym"
    (test-assert(oper diag-2-sym "LmvLyg\nDKELBm\nylJhui\nXRXqHD\nzlisCT\nhPqxYb"),
                "bTDimg\nYCHuBy\nxsqhLL\nqiXJEv\nPlRlKm\nhzXyDL")
    ))
(deftest b-test5
  (testing "selfie-diag2-counterclock"
    (test-assert(oper selfie-diag2-counterclock "NJVGhr\nMObsvw\ntPhCtl\nsoEnhi\nrtQRLK\nzjliWg"),
                "NJVGhr|gKilwr|rwliKg\nMObsvw|WLhtvh|hvthLW\ntPhCtl|iRnCsG|GsCnRi\nsoEnhi|lQEhbV|VbhEQl\nrtQRLK|jtoPOJ|JOPotj\nzjliWg|zrstMN|NMtsrz")
    ))
