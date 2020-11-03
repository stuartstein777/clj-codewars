(ns clj-codewars.6kyu-address-book-by-state
  (:require [clojure.string :as str]))

;; Address Book by State
;
; Given a string with friends to visit in different states:
;
;ad3="John Daggett, 341 King Road, Plymouth MA
;Alice Ford, 22 East Broadway, Richmond VA
;Sal Carpenter, 73 6th Street, Boston MA"
;
; we want to produce a result that sorts the names by state and lists the name of the state followed by the name of each
; person residing in that state (people's names sorted). When the result is printed we get:
;
; Massachusetts
; .....^John Daggett 341 King Road Plymouth Massachusetts
; .....^Sal Carpenter 73 6th Street Boston Massachusetts
; ^Virginia
; .....^Alice Ford 22 East Broadway Richmond Virginia
;
; Spaces not being always well seen, in the above result ^ means a white space.
;
; The resulting string (when not printed) will be:
;
; "Massachusetts\n..... John Daggett 341 King Road Plymouth Massachusetts\n..... Sal Carpenter 73 6th Street Boston Massachusetts\n Virginia\n..... Alice Ford 22 East Broadway Richmond Virginia"
;
; or (the separator is \n or \r\n depending on the language)
;
; "Massachusetts\r\n..... John Daggett 341 King Road Plymouth Massachusetts\r\n..... Sal Carpenter 73 6th Street Boston Massachusetts\r\n Virginia\r\n..... Alice Ford 22 East Broadway Richmond Virginia"

(def states {"AZ"  "Arizona"
             "CA" "California"
             "ID" "Idaho"
             "IN" "Indiana"
             "MA" "Massachusetts"
             "OK" "Oklahoma"
             "PA" "Pennsylvania"
             "VA" "Virginia"})

(defn vec->map [[friend address city-and-state]]
  (let [city              (str/trim (subs city-and-state 0 (- (count city-and-state) 2)))
        state             (str/trim (subs city-and-state (- (count city-and-state) 2)))]
    (prn state)
    {:name  friend
     :address (str/trim address)
     :state   (states state)
     :city    city}))

(defn friend->address-string [{:keys [name address state city]}]
  (str "..... " name " " address " " city  " " state "\n"))

(defn by-state [addresses]
  (let [friends-by-state (->> (str/split-lines addresses)
                              (map #(str/split % #","))
                              (map vec->map)
                              (sort-by (juxt :state :name))
                              (group-by :state))]
    friends-by-state
    (->> (for [state (keys friends-by-state)]
           [state (->> (map friend->address-string (friends-by-state state))
                       (apply str))])
         (map #(str " " (first %) "\n" (second %)))
         (apply str)
         (str/trim))))