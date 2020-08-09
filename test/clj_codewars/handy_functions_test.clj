(ns clj-codewars.handy-functions-test
  (:require [clojure.test :refer :all]
            [clj-codewars.handy-functions :refer :all]))

(deftest aeiou-are-vowels
  (is (= true (is-vowel "a")))
  (is (= true (is-vowel "e")))
  (is (= true (is-vowel "i")))
  (is (= true (is-vowel "o")))
  (is (= true (is-vowel "u"))))
    ()

(deftest other-letters-are-not-vowels
  (is (= false (is-vowel "b")))
  (is (= false (is-vowel "c")))
  (is (= false (is-vowel "d")))
  (is (= false (is-vowel "f")))
  (is (= false (is-vowel "g"))))

(deftest remove-b-from-a-test
  (let [a [1 1 2 2 2 3 3 4 5 6]
        b [3 4]]
    (is (= [1 1 2 2 2 5 6] (remove-b-from-a a b)))))

(deftest number->digits-test
  (is (= [1 2 3 4 5] (number->digits 12345))))

(deftest swap-test
  (is (= (swap [:o :# :#] 0 1) [:# :o :#])))

(deftest gcd-tests
  (is (= 5 (gcd 25 30)))
  (is (= 1 (gcd 19 25))))

(deftest leap-year?-tests
  (is (false? (leap-year? 1582)))
  (is (true? (leap-year? 1736)))
  (is (false? (leap-year? 1770)))
  (is (true? (leap-year? 2000)))
  (is (true? (leap-year? 1984)))
  (is (false? (leap-year? 2001)))
  (is (false? (leap-year? 2002)))
  (is (false? (leap-year? 2003)))
  (is (true? (leap-year? 2004))))

(defn bytes->num
  [data]
  (reduce bit-or (map-indexed (fn [i x] (bit-shift-left (bit-and x 0x0FF) (* 8 (- (count data) i 1)))) data)))

(defn int->ipaddress-string [n]
  (let [a (bit-and (bit-shift-right n 24) 0xFF)
        b (bit-and (bit-shift-right n 16) 0xFF)
        c (bit-and (bit-shift-right n 8) 0xFF)
        d (bit-and n 0xFF)]
    (str a "." b "." c "." d)))