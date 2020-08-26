(ns clj-codewars.scratch
  (:require [clojure.set :as set]
            [clojure.string :as str]))

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

;;================================================================================================
;; Get the dimensions of the map
;;================================================================================================
(defn get-dimensions [map]
  [(count map)(count (first map))])

;;================================================================================================
;; Find the goal.
;; Example map (0,0) is top left corner:
;; S 0 0 0 0
;; 0 0 0 0 0
;; 0 0 0 E 0   << here we would want to return (2,3)
;; 0 0 0 0 0
;;================================================================================================
(defn find-in-map [m s]
  (first
    (for [y (range (count m))
          :let [x (.indexOf (m y) s)]
          :when (not= -1 x)] [y x])))

;;================================================================================================
;; Get the walls as a set.
;;================================================================================================
(defn get-walls [m [max-y max-x]]
  (set (apply concat (for [y (range 0 max-y)]
                       (for [x (range 0 max-x)
                             :when (= :w (nth (nth m y) x))]
                         [y x])))))

;;================================================================================================
;; Get information about the map into a hash-map
;;================================================================================================
(defn get-map-info [m]
  (let [dimensions (get-dimensions m)]
    {:dimensions dimensions
     :start      (find-in-map m :s)
     :goal       (find-in-map m :g)
     :walls      (get-walls m dimensions)}))

;;================================================================================================
;; Given a dimension of max-x * max-y, we want to determine if x and y are within this range.
;; e.g.
;; dimensions (5, 5) => (4,4) => true
;; dimensions (5, 5) => (5,2) => false (as 5,5 will go from 0,0 to 4,4 and so the x is outwith
;; the bounds.
;;================================================================================================
(defn coord-in-grid? [max-x max-y [x y]]
  (and (<= 0 x (dec max-x)) (<= 0 y (dec max-y))))

;;================================================================================================
;; Given a max dimensions (max-x * max-y) and a coordinate (x,y), we want its neighbours.
;; A neighbour is either directly above, below, left or right. Not diagonal.
;; So map our deltas over xy then filter out the resulting points that are outwith the boundary.
;;================================================================================================
(defn get-neighbours [[max-x max-y] xy]
  (->> (map #(vec (map + (:cell xy) %)) [[-1 0] [1 0] [0 -1] [0 1]])
       (filter (partial coord-in-grid? max-x max-y))))

;;================================================================================================
;; The heuristics function.
;; G: cost to move from the start to the given cell
;; H: cost to move from the given cell to the goal
;; Return [G H]
;;================================================================================================
(defn f-heuristic [[goal-x goal-y] [cur-x cur-y] current-g]
  [(inc current-g) (+ (Math/abs (- cur-x goal-x)) (Math/abs (- cur-y goal-y)))])

;;================================================================================================
;; Function to build a summary of a node.
;; We need the cells parent (which is the current cell),
;;         the cell to build the summary for
;;         the goal (so the heuristics function can calculate the Manhatten Distance to the goal).
;; Need to return
;;    {:cell [x y] :parent [x y] :g n :h n :f (+ g h)}
;;================================================================================================
(defn build-node-summary [goal parent node]
  (let [[g h] (f-heuristic goal node (:g parent))]
    {node {:cell node :parent (:cell parent) :g g :h h :f (+ g h)}}))

;;================================================================================================
;; Get the cell with the lowest f-cost, if f-costs are tied get the cell with the lowest h cost.
;;================================================================================================
(defn get-next-cell-with-lowest-f-cost [open]
  (->> (map val open)
       (sort-by (juxt :f :h))
       (first)))

;;================================================================================================
;; Recursively walk backwards through the cells going from parent -> cell from goal to start
;; then reverse the path to get from start to goal
;;================================================================================================
(defn find-route [start closed route]
  (let [parent-of-next (:parent (closed (last route)))]
    (if (= start parent-of-next)
      (reverse (conj route parent-of-next))
      (recur start closed (conj route parent-of-next)))))

;;================================================================================================
;; Pretty print the path with arrows between nodes.
;;================================================================================================
(defn pretty-print-path [path]
  (str/join "->" path))

;;=======================================================================================================
;; This function takes the open nodes and the candidate new nodes to add to open.
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

(defn debug [text o]
  (println text o)
  o)
;;=======================================================================================================
;; The function that finds the path. Prints it out pretty printed.
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


(comment (find-path test-map))
(comment (find-path test-map2))
(comment (find-path test-map3))
(comment (find-path test-map4))
(comment (find-path test-map5))
(comment (find-path bad-map))

(let [m test-map4
      route (find-path m)
      dimensions (get-dimensions m)]
  (str/join \newline (concat [(apply str (repeat (+ 2 (second dimensions)) "▓"))]
                             (map-indexed (fn [x r]
                                            (str "▓" (apply str (map-indexed (fn [y _]
                                                                               (let [square [x y]
                                                                                     map-square (nth (nth m x) y)
                                                                                     is-route? (some #{square} route)]
                                                                                 (cond (= map-square :w) "▓"
                                                                                       (= map-square :s) "s"
                                                                                       (= map-square :g) "g"
                                                                                       is-route? "*"
                                                                                       (= map-square :o) " "
                                                                                       :else " "))) r)) "▓")) m)
                             [(apply str (repeat (+ 2 (second dimensions)) "▓"))])))
