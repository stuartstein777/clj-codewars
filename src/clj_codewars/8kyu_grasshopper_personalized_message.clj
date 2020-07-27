(ns clj-codewars.8kyu-grasshopper-personalized-message)

;; Grasshopper - Personalized Message
; Personalized greeting
; Create a function that gives a personalized greeting. This function takes two parameters: name and owner.
; Use conditionals to return the proper message:
;   case 	name equals owner return 'Hello boss'
;   case  otherwise         return 'Hello guest'

(defn greet [name_ owner]
  (cond (= name_ owner) "Hello boss"
        :else "Hello guest"))
