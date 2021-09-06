(ns stuartstein777.7kyu-vaporcode
  (:require [clojure.string :as str]))

(defn vaporcode [s]
  (->> s
       (str/upper-case)
       (remove #(= % \space))
       (interpose "  ")
       (apply str)))
