(ns clj-codewars.6kyu-positions-average-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-positions-average :refer :all]
            [clojure.string :as strg]))


(defn test-fuzzy [s exp]
  (defn error [act exp merr]
    (< (Math/abs (- act exp)) merr))
  (println (format "s: %s\nexpect: %.10f" s exp))
  (let [merr 1e-9
        actual (pos-average s)
        inrange (error actual exp merr)]
    (if (not inrange)
      (println "Expected value must be near: " exp ", got: " actual))
    (is (= inrange true))))

(deftest a-test1
  (testing "pos-average"
    (test-fuzzy "466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096" 26.6666666667)
    (test-fuzzy "444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490" 29.2592592593)
    (test-fuzzy "449404, 099090, 600999, 694460, 996066, 906406, 644994, 699094, 064990, 696046" 24.4444444444)
    (test-fuzzy "660999, 969060, 044604, 009494, 609009, 640090, 994446, 949940, 046999, 609444" 22.9629629630)))