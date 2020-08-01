(ns clj-codewars.6kyu-moves-in-squared-strings-iii-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-moves-in-squared-strings-iii :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest b-test1
  (testing "rot-90-clock"
    (test-assert(oper rot-90-clock "rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb"),
                "Sixdvr\ndJNCGg\nmBWhca\nEYgZEv\nKDXVKc\nbORWle")))

(deftest b-test3
  (testing "diag-1-sym"
    (test-assert(oper diag-1-sym "wuUyPC\neNHWxw\nehifmi\ntBTlFI\nvWNpdv\nIFkGjZ"),
                "weetvI\nuNhBWF\nUHiTNk\nyWflpG\nPxmFdj\nCwiIvZ")))

(deftest b-test5
  (testing "selfie-and-diag1"
    (test-assert(oper selfie-and-diag1 "NJVGhr\nMObsvw\ntPhCtl\nsoEnhi\nrtQRLK\nzjliWg"),
                "NJVGhr|NMtsrz\nMObsvw|JOPotj\ntPhCtl|VbhEQl\nsoEnhi|GsCnRi\nrtQRLK|hvthLW\nzjliWg|rwliKg")))
