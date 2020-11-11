(ns clj-codewars.scratch2
  (:require [flow-storm.api :as fs-api]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn debug [o]
  (tap> o)
  o)

