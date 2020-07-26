(ns clj-codewars.6kyu-moves-in-squared-strings-ii-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-moves-in-squared-strings-ii :refer :all]))

(defn test-assert-moves-in-squared-strings-2 [act exp]
  (is (= act exp)))

(deftest -moves-in-squared-strings-2-tests
  (testing "rot"
    (test-assert-moves-in-squared-strings-2
      (oper rot "rkKv\ncofM\nzXkh\nflCB"), "BClf\nhkXz\nMfoc\nvKkr")
    (test-assert-moves-in-squared-strings-2
      (oper rot  "fijuoo\nCqYVct\nDrPmMJ\nerfpBA\nkWjFUG\nCVUfyL"), "LyfUVC\nGUFjWk\nABpfre\nJMmPrD\ntcVYqC\nooujif"))
  (testing "selfie-and-rot"
    (test-assert-moves-in-squared-strings-2
      (oper selfie-and-rot "xZBV\njsbS\nJcpN\nfVnP"),
      "xZBV....\njsbS....\nJcpN....\nfVnP....\n....PnVf\n....NpcJ\n....Sbsj\n....VBZx")
    (test-assert-moves-in-squared-strings-2
      (oper selfie-and-rot "uLcq\nJkuL\nYirX\nnwMB"),
      "uLcq....\nJkuL....\nYirX....\nnwMB....\n....BMwn\n....XriY\n....LukJ\n....qcLu")))
