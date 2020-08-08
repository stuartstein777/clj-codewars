(ns clj-codewars.7kyu-easy-wallpaper)

;; Easy Wallpaper
;
; John wants to decorate a room with wallpaper. He's heard that making sure he has the right amount of wallpaper is
; more complex than it sounds. He wants a fool-proof method for getting it right.
; John knows that the rectangular room has a length of l meters, a width of w meters, a height of h meters. The
; standard width of the rolls he wants to buy is 52 centimeters. The length of a roll is 10 meters. He bears in mind
; however, that it’s best to have an extra length of wallpaper handy in case of mistakes or miscalculations so he
; wants to buy a length 15% greater than the one he needs.
; Last time he did these calculations he got a headache, so could you help John? Your function wallpaper(l, w, h)
; should return as a plain English word in lower case the number of rolls he must buy.
;
; Example:
;   wallpaper(4.0, 3.5, 3.0) should return "ten"
;   wallpaper(0.0, 3.5, 3.0) should return "zero"
; Notes:
;
;    all rolls (even with incomplete width) are put edge to edge
;    0 <= l, w, h (floating numbers), it can happens that w x h x l is zero
;    the integer r (number of rolls) will always be less or equal to 20

(defn number->english [n]
  (cond (=  0 n) "zero"
        (=  1 n) "one"
        (=  2 n) "two"
        (=  3 n) "three"
        (=  4 n) "four"
        (=  5 n) "five"
        (=  6 n) "six"
        (=  7 n) "seven"
        (=  8 n) "eight"
        (=  9 n) "nine"
        (= 10 n) "ten"
        (= 11 n) "eleven"
        (= 12 n) "twelve"
        (= 13 n) "thirteen"
        (= 14 n) "fourteen"
        (= 15 n) "fifteen"
        (= 16 n) "sixteen"
        (= 17 n) "seventeen"
        (= 18 n) "eighteen"
        (= 19 n) "nineteen"
        (= 20 n) "twenty"))

(defn wallpaper [l w h]
  (if (and (= 0.0 l) (= 0.0 w) (= 0.0 h))
    "zero"
    (let [total-area-cm (* 100 (+ (* 2 (* 100 w h))
                                  (* 2 (* 100 l h))))]
      (->> (/ total-area-cm 52000)
           (* 1.15)
           (Math/ceil)
           (int)
           (number->english)))))

(wallpaper 0.0 0.4 2.42)

(or (zero? 0.0) (zero? 0.4) (zero? 2.42))