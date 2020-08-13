(ns clj-codewars.6kyu-ease-the-stockbroker
  (:require [clojure.string :as str]
            [clj-codewars.handy-functions :refer [round]]))

;; Ease the StockBroker
;
; Clients place orders to a stockbroker as strings. The order can be simple or multiple.
;
; Type of a simple order: Quote/white-space/Quantity/white-space/Price/white-space/Status
;
; where Quote is formed of non-whitespace character, Quantity is an int, Price a double (with mandatory decimal
; point "." ), Status is represented by the letter B (buy) or the letter S (sell).
;
; Example:
;
; "GOOG 300 542.0 B"
;
; A multiple order is the concatenation of simple orders with a comma between each.
;
; Example:
;
; "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B"
;
; or (C)
;
; "ZNGA 1300 2.66 B,CLH15.NYM 50 56.32 B,OWW 1000 11.623 B,OGG 20 580.1 B"
;
; To ease the stockbroker your task is to produce a string of type
;
; "Buy: b Sell: s" where b and s are 'double' formatted with no decimal, b representing the total price of
; bought stocks and s the total price of sold stocks.
;
; Example:
;
; "Buy: 294990 Sell: 0"
;
; Unfortunately sometimes clients make mistakes. When you find mistakes in orders, you must pinpoint these badly
; formed orders and produce a string of type:
;
; "Buy: b Sell: s; Badly formed nb: badly-formed 1st simple order ;badly-formed nth simple order ;"
;
; where nb is the number of badly formed simple orders, b representing the total price of bought stocks with
; correct simple order and s the total price of sold stocks with correct simple order.
;
; Examples:
;
; "Buy: 263 Sell: 11802; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000 11 S ;"
; "Buy: 100 Sell: 56041; Badly formed 1: ZNGA 1300 2.66 ;"

(defn is-double? [n]
  (some? (re-matches #"\d+(\.\d{1,3})" (str n))))

(defn is-integer? [n]
  (some? (re-matches #"(\d+)" (str n))))

(defn order-string->order-map [order]
  (let [[ticker quantity price status] (str/split order #" ")]
    {:ticker   ticker
     :quantity (read-string quantity)
     :price    (read-string price)
     :status   (if (some? status) status "")}))

(defn validate-order [order]
  (let [valid-quantity (is-integer? (:quantity order))
        valid-price (is-double? (:price order))
        valid-status (and (not= "" (:status order)) (str/includes? "BS" (:status order)))]
    (assoc order :valid (and valid-quantity valid-status valid-price))))

(defn invalid-order->string [order]
  (str (:ticker order) " "
       (:quantity order) " "
       (:price order)
       (if (= "" (:status order))
         (str " ")
         (str " " (:status order) " "))))

(defn balance [ords]
  (if (= "" ords)
    "Buy: 0 Sell: 0"
    (let [orders (->> (str/split ords #",")
                      (map str/trim)
                      (map order-string->order-map)
                      (map validate-order))
          valid-orders (filter #(true? (:valid %)) orders)
          invalid-orders (filter #(false? (:valid %)) orders)
          summary (reduce (fn [acc o]
                            (if (= "B" (:status o))
                              [(+ (first acc) (* (:quantity o) (:price o))) (second acc)]
                              [(first acc) (+ (second acc) (* (:quantity o) (:price o)))]))
                          [0 0] valid-orders)]
      (str "Buy: " (format "%.0f" (if (zero? (first summary))
                                    0.0
                                    (first summary)))
           " Sell: " (format "%.0f" (if (zero? (second summary))
                                      0.0
                                      (second summary)))
           (if (not= (count invalid-orders) 0)
             (str "; Badly formed " (count invalid-orders) ": "
                  (str/join ";" (map invalid-order->string invalid-orders))
                  ";"))))))