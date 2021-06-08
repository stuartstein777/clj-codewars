(ns dubstep
  (:require [clojure.string :as str]))

(defn song-decoder [song]
  (->> (str/split song #"WUB")
     (remove #(= "" %))
     (str/join " ")))
