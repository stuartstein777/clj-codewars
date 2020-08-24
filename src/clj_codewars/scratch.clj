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
;; Get the dimensions of the map
;;================================================================================================
(defn get-dimensions [map]
  [(count map)(count (first map))])

;;================================================================================================
;; Given a dimension of max-x * max-y, we want to determine if x and y are within this range.
;; e.g.
;; dimensions (5, 5) => (4,4) => true
;; dimensions (5, 5) => (5,2) => false (as 5,5 will go from 0,0 to 4,4 and so the x is outwith
;; the bounds.
;;================================================================================================
(defn coord-in-grid? [max-x max-y [x y]]
  (and (<= 0 x (dec max-x)) (<= 0 y (dec max-y))))

(defn is-wall? [mp [x y]]
  (= :o (nth (nth mp x) y)))

;;================================================================================================
;; Given a max dimensions (max-x * max-y) and a coordinate (x,y), we want its neighbours.
;; A neighbour is either directly above, below, left or right. Not diagonal.
;; So map our deltas over xy then filter out the resulting points that are outwith the boundary.
;;================================================================================================
(defn get-neighbours [[max-x max-y] xy closed open walls]
  (let [open (set (map :cell open))
      closed (set (map :cell closed))]
    (set/difference (->> (map #(vec (map + xy %)) [[-1 0] [1 0] [0 -1] [0 1]])
                         (filter (partial coord-in-grid? max-x max-y))
                         (set))
                    open closed walls)))

;;================================================================================================
;; The heuristics function.
;; G: cost to move from the start to the given cell
;; H: cost to move from the given cell to the goal
;; Return [G H]
;;================================================================================================
(defn f-heuristic [[start-x start-y] [goal-x goal-y] [cur-x cur-y]]
  [(+ (Math/abs (- cur-x start-x)) (Math/abs (- cur-y start-y)))
   (+ (Math/abs (- cur-x goal-x)) (Math/abs (- cur-y goal-y)))])

;;================================================================================================
;; Function to build a summary of a node.
;; Need to return
;;    {:cell [x y] :parent [x y] :g n :h n :f (+ g h)}
;;================================================================================================
(defn build-node-summary [start goal parent node]
  (let [f (f-heuristic start goal node)]
    {:cell node :parent parent :g (first f) :h (second f) :f (+ (first f) (second f))}))

;;================================================================================================
;; Get the cell with the lowest f-cost, if f-costs are tied get the cell with the lowest h cost.
;;================================================================================================
(defn get-next-cell-with-lowest-f-cost [open]
  (first (sort-by (juxt :f :h) open)))

;;================================================================================================
;; Recursively walk backwards through the cells going from parent -> cell from goal to start
;; then reverse the path to get from start to goal
;;================================================================================================
(defn get-path [start goal closed]
  ((fn [current path n]
     (if (= start (:cell current))
       (reverse path)
       (let [parent (first (filter #(= (:cell %) (:parent current)) closed))]
         (recur parent (conj path (:cell parent)) (inc n)))))
   (first (filter #(= (:cell %) goal) closed))
   [goal] 0))

;;================================================================================================
;; Pretty print the path with arrows between nodes.
;;================================================================================================
(defn pretty-print-path [path]
  (str/join "->" path))

;;================================================================================================
;; Find the path from start to goal avoiding going through walls.
;;================================================================================================
(defn find-path [the-map]
  (let [dimensions      (get-dimensions the-map)
        start           (find-in-map the-map :s)
        goal            (find-in-map the-map :g)
        walls           (get-walls the-map dimensions)]
    (loop [open #{{:cell start :parent nil :g 0 :h 0 :f 0}}
           closed []]
      (if (empty? open)
        (println "no path exists.")
        (let [current (get-next-cell-with-lowest-f-cost open)
              cell-summary-fn (partial build-node-summary start goal (:cell current))
              neighbours (get-neighbours dimensions (:cell current) closed open walls)]
          (cond (= (:cell current) goal)
                (pretty-print-path (get-path start goal (conj closed current)))
                :else
                (recur
                  (set (remove #(= (:cell %) (:cell current)) (into open (map cell-summary-fn neighbours))))
                  (conj closed current))))))))

(comment (find-path test-map))
(comment (find-path test-map2))
(comment (find-path bad-map))