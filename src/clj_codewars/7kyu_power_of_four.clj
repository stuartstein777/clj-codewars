(ns clj-codewars.7kyu-power-of-four)

;; Power of 4
;
; Write a method that returns true if a given parameter is a power of 4, and false if it's not. If parameter is not an
; Integer (eg String, Array) method should return false as well.
;
; Examples
;
; (power-of-four? 3) ; returns false
; (power-of-four? 4) ; returns true


(defn isPowerOf4? [n]
  (if (zero? n)
    true
    (let [bn (->> (Integer/toBinaryString n)
                  (map identity))]
      (if (= 1 (count (filter #(= \1 %) bn)))
        (even? (count (rest (drop-while #(= \0 %) bn))))
        false))))