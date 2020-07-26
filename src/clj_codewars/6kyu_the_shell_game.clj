(ns clj-codewars.6kyu-the-shell-game)

;; The Shell Game
; "The Shell Game" involves cups upturned on a playing surface, with a ball placed underneath one of them. The index of
; the cups are swapped around multiple times. After that the players will try to find which cup contains the ball.
;
; Your task is as follows. Given the cup that the ball starts under, and list of swaps, return the location of the ball
; at the end. Cups are given like array/list indices.
;
; For example, given the starting position 0 and the swaps [(0, 1), (1, 2), (1, 0)]:
; The first swap moves the ball from 0 to 1
; The second swap moves the ball from 1 to 2
; The final swap doesn't affect the position of the ball.
; So
;     (= (find-the-ball 0 [[0 1] [2 1] [0 1]]) 2)
;
; There aren't necessarily only three cups in this game, but there will be at least two. You can assume all swaps are
; valid, and involve two distinct indices.

(defn find-the-ball [start swaps]
  (if (empty? swaps)
    start
    (let [x (ffirst swaps)
          y (second (first swaps))]
      (cond (= start x) (recur y (rest swaps))
            (= start y) (recur x (rest swaps))
            :else (recur start (rest swaps))))))
