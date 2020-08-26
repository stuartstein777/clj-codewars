(ns clj-codewars.scratch
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn debug [d o]
  (println d)
  o)

(def bad-map
  [[:o :o :o :w :o :o :o :o :o :o :o :o :o :o :o :o]
   [:o :o :o :w :g :w :o :o :o :w :o :o :w :o :o :o]
   [:o :o :w :w :w :w :w :w :w :w :w :w :w :w :o :o]
   [:o :o :w :o :o :o :o :o :o :o :o :o :o :w :w :o]
   [:o :o :w :w :w :w :w :w :o :o :o :o :o :w :w :o]
   [:o :o :o :o :o :o :o :o :o :o :s :w :o :w :o :o]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :w :o :o]])

(def test-map
  [[:o :o :o :w :o :o :o :o :o :o :o :o :o :o :o :o]
   [:o :o :o :w :g :w :o :o :o :w :o :o :w :o :o :o]
   [:o :o :w :w :w :w :w :w :w :w :w :w :w :w :o :o]
   [:o :o :w :o :o :o :o :o :o :o :o :o :o :w :w :o]
   [:o :o :w :w :w :w :w :w :o :o :o :o :o :w :w :o]
   [:o :o :o :o :o :o :o :o :o :o :s :w :o :w :o :o]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :o :o :o]])

(def test-map2
  [[:s :w :o :o :o :o :o :o :o :o :o :o :o :o :o :o]
   [:o :w :o :w :w :w :w :w :w :w :w :w :w :w :w :o]
   [:o :w :o :w :g :o :o :o :o :o :o :o :o :o :w :o]
   [:o :w :o :w :w :w :w :w :w :w :w :w :w :o :w :o]
   [:o :w :o :o :o :o :o :o :o :o :o :o :o :o :w :o]
   [:o :w :w :w :w :w :w :w :w :w :w :w :w :w :w :o]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :o :o :o]])

(def test-map2b
  [[:g :w :o :o :o :o :o :o :o :o :o :o :o :o :o :o]
   [:o :w :o :w :w :w :w :w :w :w :w :w :w :w :w :o]
   [:o :w :o :w :s :o :o :o :o :o :o :o :o :o :w :o]
   [:o :w :o :w :w :w :w :w :w :w :w :w :w :o :w :o]
   [:o :w :o :o :o :o :o :o :o :o :o :o :o :o :w :o]
   [:o :w :w :w :w :w :w :w :w :w :w :w :w :w :w :o]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :o :o :o]])

(def test-map3
  [[:s :w :o :o :o :w :o :o :o :w :o :o :o :w :o :g]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :o :o :w :o :o :o :w :o :o :o :w :o :o :o :w]])

(def test-map4
  [[:s :w :o :o :o :w :o :o :o :w :o :o :o :w :o :g]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :o :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :w :o :w :o :w :o :w :o :w :o :w :o :w :o :w]
   [:o :o :o :w :o :o :o :w :o :o :o :w :o :o :o :w]])

(def test-map5
  [[:w :w :w :w :w :w :w :w :o :o :o :o :o :o :o :w]
   [:w :w :w :w :w :w :w :w :g :w :o :o :w :o :o :w]
   [:w :w :w :w :w :w :w :w :w :w :w :w :w :w :s :w]
   [:w :w :w :w :w :w :w :w :w :w :w :w :w :w :w :w]
   [:w :w :w :w :w :w :w :w :w :w :w :w :w :w :w :w]
   [:w :w :w :w :w :w :w :w :w :w :w :w :w :w :w :w]
   [:w :w :w :w :w :w :w :w :w :w :w :w :w :w :w :w]])

(def test-map6
  [[:o :o :o :o :o :o :o :o :o :o :o :o :o :o :o :o]
   [:o :o :o :w :g :w :o :o :o :w :o :o :w :o :o :o]
   [:o :o :w :w :w :w :w :w :w :w :w :w :w :w :o :o]
   [:o :o :w :o :o :o :o :o :o :o :o :o :o :w :w :o]
   [:o :o :w :w :w :w :w :w :o :o :o :o :o :w :w :o]
   [:o :o :o :o :o :o :o :o :o :o :s :w :o :w :o :o]
   [:o :o :o :o :o :o :o :o :o :o :o :o :o :w :o :o]])

;;================================================================================================
;; Get the dimensions of the map.
;; The map is a 2d vector, so return the number of sub vectors and the length of the first sub
;; vector. All maps are MxN so we could return the length of any of the vectors, so lets just use
;; first.
;; e.g. given the map
;; [[:o :o :o :o]
;;  [:o :o :o :o]
;;  [:o :o :o :o]]
;;
;; Would return [4 3]
;;================================================================================================
(defn get-dimensions [map]
  [(count (first map)) (count map)])

;;================================================================================================
;; Find the goal.
;; Example map (0,0) is top left corner:
;; S 0 0 0 0
;; 0 0 0 0 0
;; 0 0 0 E 0   << here we would want to return (2,3)
;; 0 0 0 0 0
;;================================================================================================
(defn find-in-map [m to-find [max-x max-y]]
  (first (for [y (range max-y)
               x (range max-x)
               :when (= to-find (get-in m [y x]))]
           [y x])))

;;================================================================================================
;; Get all the co-ordinates of the walls as a set.
;; Walls are represented in the map vector as :w
;;================================================================================================
(defn get-walls [m [max-x max-y]]
  (set (for [x (range max-x)
             y (range max-y)
             :when (= :w (get-in m [y x]))]
         [y x])))

;;================================================================================================
;; Get information about the map into a hash-map
;;================================================================================================
(defn get-map-info [m]
  (let [dimensions (get-dimensions m)]
    {:dimensions dimensions
     :start      (find-in-map m :s dimensions)
     :goal       (find-in-map m :g dimensions)
     :walls      (get-walls m dimensions)}))

;;================================================================================================
;; Given a map dimension of max-x x max-y, we want to determine if x and y are within this range.
;; e.g.
;; Given dimensions [5 5] and co-ord [4 4] this will return true as a map of dimension [5 5]
;; will have a range from 0 to 4 on x and 0 to 4 on y, so [4 4] is within these bounds.
;; Given dimensions (5, 5) and co-ord [5 2] this will return false as a map of dimension [5 5]
;; will have a range from 0 to 4 for x and a range of 0 to 4 for y, and so a co-ord of [5 2] is
;; outwith this bound.
;;================================================================================================
(defn coord-in-grid? [max-x max-y [y x]]
  (and (<= 0 x (dec max-x)) (<= 0 y (dec max-y))))

;;================================================================================================
;; Given a cell xy and map dimensions (max-x by max-y), we want the cells neighbours.
;; A neighbour is either directly above, below, left or right. Not diagonal.
;; So map our deltas over xy then filter out the resulting points that are outwith the boundary.
;;================================================================================================
(defn get-neighbours [[max-x max-y] xy]
  (->> (map #(vec (map + (:cell xy) %)) [[-1 0] [1 0] [0 -1] [0 1]])
       (filter (partial coord-in-grid? max-x max-y))))

;;================================================================================================
;; The heuristics function.
;; G: cost to move from the start to the given cell, this is just the parent of this cells g cost
;;    incremented.
;; H: cost to move from the given cell to the goal by a naive Manhatten distance.
;; F: This is G + H
;; Return [G H]
;; e.g. in the following 1d map (where :S is the start and :X is the goal):
;;
;; [[0 0 :S] [0 1] [0 2] [0 3] [0 4 :X]]
;;
;; [0 1] would have G cost of 1 and H cost of 3
;; [0 2] would have G cost of 2 and H cost of 2 etc.
;;================================================================================================
(defn f-heuristic [[goal-x goal-y] [cur-x cur-y] current-g]
  [(inc current-g) (+ (Math/abs (- cur-x goal-x)) (Math/abs (- cur-y goal-y)))])

;;================================================================================================
;; Function to build a summary of a node.
;; Arguments: goal - the goal location so the heuristics function can calculate the Manhatten Distance to the goal.
;;            parent - this cells parent, we need this as we need to know the running g cost.
;;            node - the cell we are building a summary for.
;; Need to return
;;    {:cell [x y] :parent [x y] :g n :h n :f (+ g h)}
;;================================================================================================
(defn build-node-summary [goal parent node]
  (let [[g h] (f-heuristic goal node (:g parent))]
    {node {:cell node :parent (:cell parent) :g g :h h :f (+ g h)}}))

;;================================================================================================
;; Get the cell with the lowest f-cost from the collection of open cells.
;; If the f-costs are tied then get the cell with the lowest h cost.
;;================================================================================================
(defn get-next-cell-with-lowest-f-cost [open]
  (->> (map val open)
       (sort-by (juxt :f :h))
       (first)))

;;================================================================================================
;; This function is called once we have reached the goal and the closed list will contain the route.
;; So starting from the goal we can recursively walk backwards through the cells via the cells parent key.
;; Then reverse the path to get from start to goal
;;================================================================================================
(defn find-route [start closed route]
  (let [parent-of-next (:parent (closed (last route)))]
    (if (= start parent-of-next)
      (reverse (conj route parent-of-next))
      (recur start closed (conj route parent-of-next)))))

;;=======================================================================================================
;; This function takes the open nodes and a collection of candidate new nodes to add to open.
;; A node is added to the open map if it either:
;;    a) doesn't already exist
;;    b) exists but candidate has lower f-cost than the existing cell
;;    c) exists but candidate has the same f-cost than existing cell but lower g cost.
;;=======================================================================================================
(defn merge-with-open [open new]
  (reduce (fn [acc i]
            (let [new-cell (ffirst i)
                  new-values (second (first i))
                  existing (open new-cell)]
              (if (some? existing)
                  (if (or (< (:f new-values) (:f existing))
                         (and (= (:f new-values) (:f existing))
                              (< (:g new-values) (:g existing))))
                    (assoc acc (existing :cell) new-values)
                    acc)
                  (merge acc i)))) open new))

;;=======================================================================================================
;; The function that finds the path.
;; Get the map information
;; Create the empty set for the closed cells
;; Create the set for the open cells and add the start cell to it.
;; Now we recur, on each recursive step we want to:
;;    a) get the cell in the open set that has the lowest heuristic cost.
;;    b) get all the neighbours for this cell that are within the bounds, isn't a wall and isn't closed
;;    c) calculate the heuristics and set the parent for each cell
;;    d) merge these neighbours into the open list. (see comment on merge function for how this merge is decided
;;    e) add the current cell to the closed set and remove from the open set.
;;    f) continue doing this until the open set is empty or we've reach the goal.
;;        if the open set is empty and we haven't reached the goal then there is no path from start to goal.
;;    g) once we have finished we will have the route in the closed set with the path set via each cells parent
;;    h) unwind that closed set starting from the goal to start (and reverse that to get start to goal).
;;
;; Return this unwound path.
;;=======================================================================================================
(defn find-path [m]
  (let [map-info (get-map-info m)]
    (loop [closed {}
           open (assoc {} (:start map-info) {:cell   (:start map-info)
                                             :parent nil
                                             :g      0
                                             :h      (apply + (:goal map-info))
                                             :f      (apply + (:goal map-info))})]
      (cond (empty? open)
            (println "no path exists!")
            :else
            (let [current (get-next-cell-with-lowest-f-cost open)
                  updated-open (as-> (get-neighbours (:dimensions map-info) current) o
                                     (set o)
                                     (set/difference o (set/union (:walls map-info) (set (keys closed))))
                                     (map (partial build-node-summary (map-info :goal) current) o)
                                     (merge-with-open open o)
                                     (dissoc o (:cell current)))
                  updated-closed (assoc closed (:cell current) current)]
              (if (= (:cell current) (map-info :goal))
                (find-route (map-info :start) updated-closed [(map-info :goal)])
                (recur updated-closed updated-open)))))))


;;=======================================================================================================
;; Gets the route marker so that the route is printed as a joined up line.
;; We need to look at 3 cells, the previous cell, the current cell and the next cell in the route to
;; determine the type of connector to add.
;;=======================================================================================================
(defn get-route-marker [route [y x]]
  (let [[prev-y prev-x] (nth route (dec (.indexOf route [y x])))
        [next-y next-x] (nth route (inc (.indexOf route [y x])))]
    (cond (= x next-x prev-x) "│"
          (= y next-y prev-y) "─"
          (and (> prev-y y) (> next-x x) (= y next-y)) "┌"
          (and (> prev-x x) (= prev-y y) (> next-y y)) "┌"
          (and (< prev-y y) (> next-x x) (= y next-y)) "└"
          (and (= next-x x) (< next-y y) (> prev-x x)) "└"
          (and (= prev-y y) (> next-y y) (< prev-x x)) "┐"
          (and (> x next-x) (> prev-y y) (= x prev-x)) "┐"
          (and (= prev-y y) (< next-y y) (< prev-x x)) "┘"
          (and (> x next-x) (= x prev-x) (< prev-y y)) "┘")))

;;=======================================================================================================
;; Get the map as a string with the route drawn.
;;=======================================================================================================
(defn get-map-with-route [m]
  (let [route (find-path m)
        [dx _] (get-dimensions m)]
    (str/join \newline
              (concat [(apply str (repeat (+ 2 dx) "▓"))]
                      (map-indexed (fn [x r]
                                     (str "▓" (apply str (map-indexed (fn [y _]
                                                                        (let [square [x y]
                                                                              map-square (nth (nth m x) y)
                                                                              is-route? (some #{square} route)]
                                                                          (cond (= map-square :w) "▓"
                                                                                (= map-square :s) "s"
                                                                                (= map-square :g) "g"
                                                                                is-route? (get-route-marker route square)
                                                                                (= map-square :o) " "
                                                                                :else " "))) r)) "▓")) m)
                      [(apply str (repeat (+ 2 dx) "▓"))]))))

;;=======================================================================================================
;; Prints the 2d vector representation of the original map.
;;=======================================================================================================
(defn print-map* [m]
  (println (str/join \newline (map str m))))

;;=======================================================================================================
;; Print the map as a 2d vector and then print the map graphically with the route.
;;=======================================================================================================
(defn print-map-and-route* [m]
  (println "Map:")
  (print-map* m)
  (println "\nRoute:")
  (println (get-map-with-route m)))

;; Call
(print-map-and-route* test-map)
(print-map-and-route* test-map2)
(print-map-and-route* test-map2b)
(print-map-and-route* test-map3)
(print-map-and-route* test-map4)
(print-map-and-route* test-map5)
(print-map-and-route* test-map6)