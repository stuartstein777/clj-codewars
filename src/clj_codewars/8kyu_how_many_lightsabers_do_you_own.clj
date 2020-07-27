(ns clj-codewars.8kyu-how-many-lightsabers-do-you-own)

;; How many lightsabers do you own?
; Inspired by the development team at Vooza, write the function howManyLightsabersDoYouOwn/how_many_light_sabers_do_you_own that
;
;    accepts the name of a programmer, and
;    returns the number of lightsabers owned by that person.
;
; The only person who owns lightsabers is Zach, by the way. He owns 18, which is an awesome number of lightsabers. Anyone else owns 0.
;
; (howManyLightsabersDoYouOwn "Anny Wan-Else")     == 0
; (howManyLightsabersDoYouOwn "Hugh R. Dareader")  == 0
; (howManyLightsabersDoYouOwn "Zach")              == 18

(defn howManyLightsabersDoYouOwn [name]
  (if (= name "Zach")
    18
    0))
