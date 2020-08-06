(ns clj-codewars.6kyu-street-fighter-2-character-selection)

;; Street Fighter 2 Character Selection
;
; Short Intro
;
; Some of you might remember spending afternoons playing Street Fighter 2 in some Arcade back in the 90s or emulating it
; nowadays with the numerous emulators for retro consoles.
;
; Can you solve this kata? Suuure-You-Can!
;
; UPDATE: a new kata's harder version is available here.
;
; The Kata
;
; You'll have to simulate the video game's character selection screen behaviour, more specifically the selection grid.
; Such screen looks like this:
;
; Selection Grid Layout in text:
;
;   | Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
;   | Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |
;
; Input
;
;    the list of game characters in a 2x6 grid;
;    the initial position of the selection cursor (top-left is (0,0));
;    a list of moves of the selection cursor (which are up, down, left, right);
;
; Output
;
;    the list of characters who have been hovered by the selection cursor after all the moves (ordered and with
;    repetition, all the ones after a move, wether successful or not, see tests);
;
; Rules
;
; Selection cursor is circular horizontally but not vertically!
; As you might remember from the game, the selection cursor rotates horizontally but not vertically; that means that if
; I'm in the leftmost and I try to go left again I'll get to the rightmost (examples: from Ryu to Vega, from Ken to
; M.Bison) and vice versa from rightmost to leftmost.
;
; Instead, if I try to go further up from the upmost or further down from the downmost, I'll just stay where I am
; located (examples: you can't go lower than lowest row: Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the above
; image; you can't go upper than highest row: Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).
;
; Test
;
; For this easy version the fighters grid layout and the initial position will always be the same in all tests,
; only the list of moves change.

(defn get-fighter-at-position [fighters pos]
  (let [[x y] pos]
    (nth (nth fighters y) x)))

(defn move-horizontally [x move]
  (let [new-pos (+ x move)]
    (cond (> new-pos 5) 0
          (< new-pos 0) 5
          :else new-pos)))

(defn move-vertically [y move]
  (let [new-pos (+ y move)]
    (cond (neg? new-pos) 0
          (> new-pos 1) 1
          :else new-pos)))

(defn street-fighter-selection [fighters position moves]
  (map (partial get-fighter-at-position fighters)
       (rest (reduce (fn [acc move]
                       (let [x (first (last acc))
                             y (second (last acc))]
                         (cond (= move "up") (conj acc [x (move-vertically y -1)])
                               (= move "down") (conj acc [x (move-vertically y 1)])
                               (= move "right") (conj acc [(move-horizontally x 1) y])
                               (= move "left") (conj acc [(move-horizontally x -1) y])))
                       ) [position] moves))))