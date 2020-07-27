(ns clj-codewars.7kyu-ipv4-validator
  (:require [clojure.string :as str]))

;; IPv4 Validator
; In this kata you have to write a method to verify the validity of IPv4 addresses.
;
; Example of valid inputs:
;   "1.1.1.1"
;   "127.0.0.1"
;   "255.255.255.255"
; Example of invalid input:
;   "1444.23.9"
;   "153.500.234.444"
;   "-12.344.43.11"

(defn validate-ip [ip]
  (let [octets (str/split ip #"\.")]
    (and (= 4 (count octets))
         (every? #(and (not= nil (re-matches #"\d+" %))
                       (<= 0 (Integer/parseInt %) 255)) octets))))
