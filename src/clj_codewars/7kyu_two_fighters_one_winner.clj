(ns clj-codewars.7kyu-two-fighters-one-winner)

;; Two figers, one winner
;
; Create a function that returns the name of the winner in a fight between two fighters.
;
; Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as
; having health <= 0.
;
; Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
;
; Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the
; Fighter objects.

(defrecord Fighter [name hp attack])

(defn declare-winner [f1 f2]
  (cond (or (neg? (:hp f1)) (zero? (:hp f1))) (:name f2)
        (or (neg? (:hp f2)) (zero? (:hp f2))) (:name f1)
        :else (recur (->Fighter (:name f1) (- (:hp f1) (:attack f2)) (:attack f1))
                     (->Fighter (:name f2) (- (:hp f2) (:attack f1)) (:attack f2)))))