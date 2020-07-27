(ns clj-codewars.beta-card-checker-world-series-of-poker-task-0)

;; Card Checker -- World Series of Poker -- [Task 0]
; Your task will be:
; Write a function checkCard it gets one parameter card, so it wants to confirm that all cards are going to be correct. Don't worry it's always a string with two chars and return boolean true/false.
; Please use cards format 2 3 4 5 6 7 8 9 T J Q K A
; and suit format ♠ ♣ ♥ ♦ for JavaScript or s c h d for other languages.
;
; For example:
;
;    A♠ => true or As => true
;    5♦ => true or 5d => true
;    10♥ => false or 10h => false
;    k♣ => false or kc => false
;    8♧ => false or 8C => false

(defn check-card [card]
  (let [valid-ranks #{\2 \3 \4 \5 \6 \7 \8 \9 \T \J \Q \K}
        valid-suits #{\♠ \♣ \♥ \♦}]
    (not (nil? (and (valid-ranks (first card))
                    (valid-suits (second card)))))))