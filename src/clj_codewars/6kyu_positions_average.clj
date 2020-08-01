(ns clj-codewars.6kyu-positions-average
  (:require [clojure.string :as str]))

; combinations for n strings is (1+2+3...+ n-1)
;
(defn pos-average [s]
  (let [parts (map str/trim (str/split s #","))
        combinations (reduce + (range 1 (count parts)))]

    ))

(pos-average "444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490")

