(ns clj-codewars.6kyu-traffic-lights-one-car)

(defn road-string->road-map [road]
  (let [car (.indexOf road "C")
      traffic-lights (->> (map (fn [l]
                                 [l (.indexOf road l) 0]) ["G" "O" "R"])
                          (filter #(not= -1 (second %))))]
    {:car car
     :traffic-lights traffic-lights
     :road-length (count road)}))

(defn advance-traffic-light-state [[color square time-in-state]]
  (cond (and (= color "G") (= time-in-state 5))
        ["O" square 0]
        (and (= color "O") (= time-in-state 1))
        ["R" square 0]
        (and (= color "R") (= time-in-state 5))
        ["G" square 0]
        :else
        [color square (inc time-in-state)]))

(defn advance-car-position [car traffic-lights]
  (if (some #{["O" (inc car)] ["R" (inc car)]} traffic-lights)
    car
    (inc car)))

(defn advance-road-state [{:keys [car traffic-lights road-length]}]
  (let [new-traffic-lights (map advance-traffic-light-state traffic-lights)
        new-car-position   (advance-car-position car (map (fn [tl] [(first tl) (second tl)]) new-traffic-lights))]
    {:car new-car-position
     :traffic-lights new-traffic-lights
     :road-length road-length}))

(defn add-traffic-light-to-road-string [traffic-light road]

  road)


(defn add-car-to-road-string [car road]
  (str (subs road 0 (dec car)) "C" (subs road (dec car))))

;; Need a function to go from road-map > road-string
(defn road-map->road-string [{:keys [car traffic-lights road-length]}]
  (->> (apply str (repeat road-length "."))
       ((partial add-traffic-light-to-road-string traffic-lights))
       ((partial add-car-to-road-string car))))

(road-map->road-string {:car 6 :traffic-lights [["R" 17 0] ["G" 4 2]] :road-length 24})



(let [initial-state (road-string->road-map "C...R............G.....")]
  (loop [road-state initial-state
         n 0]
    (if (= n 10)
      road-state
      (recur (advance-road-state road-state) (inc n)))))


(defn triangle [depth]
  (let [rowfn (fn [n] (apply str (repeat n "#")))
      depth-range (range depth)]
    (clojure.string/join "\n" (concat (map rowfn depth-range)
                                      (map rowfn (reverse (butlast depth-range)))))))

(println (triangle 5))