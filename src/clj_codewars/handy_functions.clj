(ns clj-codewars.handy-functions
  (:require [clojure.string :as str]))

;; Creating a date and adding days to it
(-> (java.time.LocalDate/parse "2016-01-01") (.plusDays 1) str)

;; check
(defn is-vowel [s]
  (not= nil (re-matches #"(?i)[aeiou]" s)))

(defn is-vowel-char [c]
  (not (nil? (#{\a \e \i \o \u \A \E \I \O \U} c))))

;; precise pow
(defn int-pow [b ^long ex]
  (loop [acc 1 ex ex]
    (case ex
      0 acc
      (recur (* acc b) (dec ex)))))

;; remove items from list a that are in list b
(defn remove-b-from-a [a b]
  (remove (set b) a))

;; split a string on spaces
(str/split "a b c d e" #"\s+")

;; split a number into a sequence of its digits
(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn sum-of-digits [num]
  (reduce + (number->digits num)))

;; swap two items in a list
(defn swap [v i1 i2]
  (assoc v i2 (v i1) i1 (v i2)))

;; greatest common divisor (Euclid's algorithm)
(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

;; least-common-multiple
(defn lcmu [a b]
  (/ (* (Math/abs ^long a) (Math/abs ^long b)) (gcd a b)))

;; calculate if year is a leap year.
(defn leap-year? [year]
  (or (zero? (mod year 400)) (and (zero? (mod year 4)) (not (zero? (mod year 100))))))

;; round down to n decimal places
(defn round-down [n]
  (let [scale (Math/pow 10 2)]
    (/ (Math/round (- (* n scale) 0.5))
       scale)))

;; round n to places decimal places.
(defn round [n places]
  (let [scale (Math/pow 10 places)]
    (/ (Math/round (* n scale))
       scale)))

; say you want the first item from each list, then second item from each list etc...
; (amv [[:a :b :c] [:d :e :f] [:g :h :i]])
; => ([:a :d :g] [:b :e :h] [:c :f :i])
(defn amv [xs]
  (apply map vector xs))

(defn bytes->num
  [data]
  (reduce bit-or (map-indexed (fn [i x] (bit-shift-left (bit-and x 0x0FF) (* 8 (- (count data) i 1)))) data)))

(defn int->ipaddress-string [n]
  (let [a (bit-and (bit-shift-right n 24) 0xFF)
        b (bit-and (bit-shift-right n 16) 0xFF)
        c (bit-and (bit-shift-right n 8) 0xFF)
        d (bit-and n 0xFF)]
    (str a "." b "." c "." d)))

(defn reciprocal [n]
  (if (ratio? n)
    (/ (denominator n) (numerator n))
    (/ 1 n)))

(defn factorial [n]
  (apply *' (range 1 (inc n))))

;; calculate binomial coefficient
(defn binom [n k]
  (/ (factorial n)
     (* (factorial k) (factorial (- n k)))))

(defn decimal->ratio [dec]
  (loop [n dec
         d 1
         i 1]
    (let [nxi (* n i)
          dxi (* d i)]
      (if (== (int (* n i)) (* n i))
        (/ (int nxi) (int dxi))
        (recur n d (* 10 i))))))

