(ns clj-codewars.7kyu-deodorant-evaporator)

;; Deodorant Evaporator
; This program tests the life of an evaporator containing a gas.
;
; We know the content of the evaporator (content in ml), the percentage of foam or gas lost every day (evap_per_day)
; and the threshold (threshold) in percentage beyond which the evaporator is no longer useful. All numbers are
; strictly positive.
;
; The program reports the nth day (as an integer) on which the evaporator will be out of use.
;
; Note : Content is in fact not necessary in the body of the function "evaporator", you can use it or not use it,
; as you wish. Some people might prefer to reason with content, some other with percentages only. It's up to you but
; you must keep it as a parameter because the tests have it as an argument.

(defn get-evaporated-content [content evap-per-day]
  (* content (/ evap-per-day 100)))

(defn evaporator [content, evap_per_day, threshold]
  (let [target-content (* content (/ threshold 100))]
    (loop [current-content content
           days 1]
      (let [evaporated-content (get-evaporated-content current-content evap_per_day)]
        (if (< (- current-content evaporated-content) target-content)
          days
          (recur (- current-content evaporated-content) (inc days)))))))
