(ns clj-codewars.scratch
  (:require [clojure.set :as set]
            [clojure.string :as str]
            [clj-codewars.handy-functions :as helpers]
            [flow-storm.api :as fsa]))

(defn debug [d o]
  (tap> d)
  o)

;; todo - numbers with multiple digits
;; todo -- only apply numbers to the bit within parens e.g. "7(pgwh9(f)k)"
(defn solve [s]
  (prn s)
  (->> (reduce (fn [acc i] (if (#{\( \)} i) acc (conj acc i))) [] s)
       (reverse)
       (reduce (fn [acc i]
                 (if (#{\1 \2 \3 \4 \5 \6 \7 \8 \9 \0} i)
                   (flatten (repeat (Integer/parseInt (str i)) acc))
                   (concat acc [i]))) [])
       (reverse)
       (str/join "")))

(solve "ukq10(x)")                                          ;ukqxxxxxxxxxx

(defn is-digit [c]
  (<= (int \0) (int c) (int \9)))

(partition-by is-digit "ukq10(x)")

;; "7(pgwh9(f)k)"  => pgwhfffffffffkpgwhfffffffffkpgwhfffffffffkpgwhfffffffffkpgwhfffffffffkpgwhfffffffffkpgwhfffffffffk
;; 2(a3(bc)d4(e))f => abcbcbcdeeeeabcbcbcdeeeef

;;                    REPEATS               IN-BRACKET        VALUES
;; 2                  STACK [2      ]       0
;; (                  STACK [2      ]       1
;; a                  STACK [2      ]       1                 [a                        ]
;; 3                  STACK [2 3    ]       1                 [a                        ]
;; (                  STACK [2 3    ]       2                 [a                        ]
;; b                  STACK [2 3    ]       2                 [a, b                     ]
;; c                  STACK [2 3    ]       2                 [a, bc                    ]
;; )                  STACK [2      ]       1                 [abcbcbc                  ]
;; d                  STACK [2      ]       1                 [abcbcbcd                 ]
;; 4                  STACK [2 4    ]       1                 [abcbcbcd                 ]
;; (                  STACK [2 4    ]       2                 [abcbcbcd                 ]
;; e                  STACK [2 4    ]       2                 [abcbcbcd e               ]
;; )                  STACK [2      ]       1                 [abcbcbcdeeee             ]
;; )                  STACK [       ]       0                 [abcbcbcdeeeeabcbcbcdeeee ]
;; F                  STACK [       ]       0                 [abcbcbcdeeeeabcbcbcdeeeef]



