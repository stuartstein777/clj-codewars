(ns clj-codewars.6kyu-take-a-number-sum-its-digits-raised-powers)

;; Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
; The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the
; title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
;
; In effect: 89 = 8^1 + 9^2
;
; The next number in having this property is 135.
;
; See this property again: 135 = 1^1 + 3^2 + 5^3
;
; We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b]
; (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
;
; Let's see some cases:
;     sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
;     sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
; If there are no numbers of this kind in the range [a, b] the function should output an empty list.
;     sum_dig_pow(90, 100) == []

(defn is-eureka? [n]
  (let [digits (->> n str (map (comp read-string str)))]
    (= n (reduce + (map #(int (Math/pow %1 %2)) digits (range 1 (inc (count digits))))))))

(defn sum-dig-pow [a, b]
  (->> (range a (inc b))
       (reduce (fn [acc i] (if (is-eureka? i) (conj acc i) acc)) [])))
