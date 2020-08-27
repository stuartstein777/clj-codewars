(ns clj-codewars.7kyu-friends)

;; Friends
;
 ;Andrzej was given a task:
; There are n jars with pills. In every jar there is a different type of pill and the amount of pills in each jar is
; infinite. One type of pill makes a person glow about 30 minutes after taking and none of the other types has any
; effect.
;
; His job is to determine, in which jar are the pills that make a person glow. But there is one catch, he only has
; 35 minutes to do so.(so he can't take a pill, wait for the results and then take another one, because he wouldn't
; be able to see the results) Fortunetely, he can take any number of friends he needs with him. On completing the
; task Andrzej receives one million dollars. You know that Andrzej is very honest, so he will split the money equally
; with his friends.
;
; Your job is to determine how many friends does Andrzej need to complete the task.(He also wants to make the
; highest amount of money.)
;
; For example for n = 2
;
; The answer is 0 because he doesn't need any friends, he just needs to take a pill from the first jar and wait for
; the effects.
;
; For another example for n = 4
; The answer is 1 because having pills A B C D Andrzej can take pills A B and the friend can take pills B C
; Note: Andrzej is not able to accurately measure time during the task.

(defn friends [n]
  (if (<= n 1)
    0
    (dec (int (Math/ceil (/ (Math/log n)
                            (Math/log 2)))))))

;; Solution notes
; For 9 jars, ABCDEFGHI, we can split the jars up as:
;     Alex    Bob   Claire  David   Eve
; A=> 1       0     0       0       0
; B=> 1       1     0       0       0
; C=> 1       0     1       0       0
; D=> 1       0     0       1       0
; E=> 1       0     0       0       1
; F=> 0       1     1       0       0
; G=> 0       1     0       1       0
; H=> 0       0     1       1       0
; I=> 0       0     0       0       0
;
; We know if only Alex glows then the pill was in jar A
; if Alex and Bob glows it was in jar B
; if Alex and Claire glows it was in jar C etc
; All we need to know then is how many bits do we need to represent n.
; This is just (ceil (/ log(n) log (2))
; Then take away 1 to get the number of friends (as we don't want to count Alex).