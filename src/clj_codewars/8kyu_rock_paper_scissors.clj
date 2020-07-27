(ns clj-codewars.8kyu-rock-paper-scissors)

;; Rock Paper Scissors
; Let's play! You have to return which player won! In case of a draw return Draw!.
;
; Examples:
;
;     rps('scissors','paper') // Player 1 won!
;     rps('scissors','rock') // Player 2 won!
;     rps('paper','paper') // Draw!

(def beats
  {"rock" "scissors"
   "paper" "rock"
   "scissors" "paper"})

(defn rps [p1 p2]
  (cond (= p1 p2) "Draw!"
        (= (beats p1) p2) "Player 1 won!"
        :else "Player 2 won!"))