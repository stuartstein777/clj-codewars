(ns clj-codewars.6kyu-binaries)

(ns clj-codewars.6kyu-binaries
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))

;; Binaries
; Let us take a string composed of decimal digits: "10111213". We want to code this string as a string of 0 and 1 and
; after that be able to decode it.
; We decompose the given string in its decimal digits 1 0 1 1 1 2 1 3 and we will code each.
; Coding process to code a number n expressed in base 10:
;   a) Let k be the number of bits of n
;   b) Put k-1 times the digit 0 followed by the digit 1
;   c) Put number n in binary
;   d) Concat the result of b) and c)
; So we code 0 as 10, 1 as 11 ... etc...
; Repeating this process with the initial string
; "10111213" becomes : "11101111110110110111" resulting of concatenation of 11 10 11 11 11 0110 11 0111 .
; Task:
; Given strng a string of digits representing a decimal number the function code(strng) should return the coding of
; strng as explained above.
; Given a string strng resulting from the previous coding, decode it to get the corresponding decimal string.
; Examples:
;     code("77338855") --> "001111001111011101110001100000011000001101001101"
;     code("77338")  --> "0011110011110111011100011000"
;     code("0011121314") --> "1010111111011011011111001100"
;
;     decode("001111001111011101110001100000011000001101001101") -> "77338855"
;     decode("0011110011110111011100011000") -> "77338"
;     decode("1010111111011011011111001100") -> "0011121314"

(defn code [num]
  (let [digits (->> num str (map (comp read-string str)))]
    (reduce (fn [acc i]
              (str acc (let [bin (Integer/toBinaryString i)]
                         (str (apply str (repeat (dec (count bin)) "0")) "1" bin)))) "" digits )))

(defn decode [b]
  (loop [bin b res ""]
    (if (str/blank? bin)
      res
      (let [bits (inc (count (take-while #(not= \1 %) bin)))]
        (recur (subs bin (* 2 bits)) (str res (Integer/parseInt (subs bin bits (* 2 bits)) 2)))))))
