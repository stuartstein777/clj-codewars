(ns clj-codewars.6kyu-hidden-cubic-numbers
  (require [clojure.string :as str]))

;; Hidden "Cubic" Numbers
;
; We search non-negative integer numbers, with at most 3 digits, such as the sum of the cubes of their digits is the
; number itself; we will call them "cubic" numbers.
;
; 153 is such a "cubic" number : 1^3 + 5^3 + 3^3 = 153
;
; These "cubic" numbers of at most 3 digits are easy to find, even by hand, so they are "hidden" with other
; numbers and characters in a string.
;
; The task is to find, or not, the "cubic" numbers in the string and then to make the sum of these "cubic"
; numbers found in the string, if any, and to return a string such as:
;
; "number1 number2 (and so on if necessary) sumOfCubicNumbers Lucky"
;
; if "cubic" numbers number1, number2, ... were found. The numbers in the output are to be in the order in
; which they are encountered in the input string.
;
; If no cubic numbers are found return the string:
;
; "Unlucky".
;
; Examples:
;
; s = "aqdf& 0 1 xyz 153 777.777" must return "0 1 153 154 Lucky"
;
; s = "QK29 45[&erui" must return "Unlucky".
;
; Note: In the string "001234" where 3 digits or more follow each other the first packet to examine is "001"
; and the following is "234". If a packet of at most three digits has been taken, whether or not "cubic",
; it's over for that packet.
;
; When a continuous string of digits exceeds 3, the string is split into groups of 3 from the left. The last
; grouping could have 3, 2 or 1 digits. e.g "24172410" becomes 3 strings comprising "241", "724" and "10"
; e.g "0785" becomes 2 strings comprising "078" and "5".

(defn number->digits [num]
  (->> num str (map (comp read-string str))))

(defn is-cubic? [n]
  (let [digits (number->digits n)]
    (= n (reduce (fn [acc i] (+ acc (* i i i))) 0 digits))))

(defn chars->numbers [cs]
  (->> (map str cs)
       (apply str)
       (read-string)))

(defn sum-cubes [s]
  (let [cubics (->> (re-seq #"\d+" s)
                    (mapcat (partial partition-all 3))
                    (map chars->numbers)
                    (filter is-cubic?)
                    )]
    (if (empty? cubics)
      "Unlucky"
      (str (str/join #" " cubics) " " (apply + cubics) " Lucky"))))