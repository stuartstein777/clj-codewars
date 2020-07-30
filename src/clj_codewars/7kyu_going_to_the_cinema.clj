(ns clj-codewars.7kyu-going-to-the-cinema)

;; Going to the cinema
; My friend John likes to go to the cinema. He can choose between system A and system B.
;
; System A : he buys a ticket (15 dollars) every time
; System B : he buys a card (500 dollars) and a first ticket for 0.90 times the ticket price,
; then for each additional ticket he pays 0.90 times the price paid for the previous ticket.
;
; #Example: If John goes to the cinema 3 times:
;   System A : 15 * 3 = 45
;   System B : 500 + 15 * 0.90 + (15 * 0.90) * 0.90 + (15 * 0.90 * 0.90) * 0.90
;              ( = 536.5849999999999, no rounding for each ticket)
;
; John wants to know how many times he must go to the cinema so that the final result of System B, when rounded up to
; the next dollar, will be cheaper than System A.
;
; The function movie has 3 parameters:
;     card (price of the card),
;     ticket (normal price of a ticket),
;     perc (fraction of what he paid for the previous ticket) and returns the first n such that
;
; ceil(price of System B) < price of System A.
; More examples:
; movie(500, 15, 0.9) should return 43  :: (with card the total price is 634, with tickets 645)
; movie(100, 10, 0.95) should return 24 :: (with card the total price is 235, with tickets 240)

;; Solution notes:
; We can calculate the same of a partial sequence using the formula:
;  a_1 * (1 - r^k) / (1 - r)
; where k is the kth in the series
; a1 is the first item
; r is the ratio.

(defn get-total [^double card ^double ticket ^double discount n]
  (let [a1 (* ticket discount)]
    (+ card (* a1 (/ (- 1.0 (Math/pow discount n))
                     (- 1.0 discount))))))

(defn movie [card ticket discount]
  (loop [count 1]
    (let [a (* count ticket)
        b (get-total card ticket discount count)]
      (if (> (- a b) 1)
        (do
          (int count))
        (recur (inc count))))))