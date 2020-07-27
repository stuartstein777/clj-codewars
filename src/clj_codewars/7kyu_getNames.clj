(ns clj-codewars.7kyu-getNames)

;; getNames()
; The following code is not giving the expected results. Can you figure out what the issue is?
; The following is an example of data that would be passed in to the function.
;   (def data [
;       {:name "Joe" :age 20}
;       {:name "Bill" :age 30}
;       {:name "Kate" :age 23}
;     ])
;
;   (get-names data) ; should return ["Joe" "Bill" "Kate"]

(defn get-names [data]
  (map #(:name %) data))
