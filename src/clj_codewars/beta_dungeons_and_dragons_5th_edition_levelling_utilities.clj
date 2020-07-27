(ns clj-codewars.beta-dungeons-and-dragons-5th-edition-levelling-utilities)

;; Dungeons And Dragons 5th edition leveling utilities
;; Estimated 7 KYU

(def level-requirements {:1 0 :2 300 :3 900 :4 2700 :5 6500 :6 14000 :7 23000 :8 34000 :9 48000 :10 64000
                         :11 85000 :12 100000 :13 120000 :14 140000 :15 165000 :16 195000 :17 225000
                         :18 265000 :19 305000 :20 355000})

(defn- cap-level [level cap]
  (if (> level cap)
    cap
    level))

(defn- level->keyword [level]
  (keyword (str level)))

(defn- cur-level-number [current-xp]
  (cap-level (count (filter #(>= current-xp (second %)) level-requirements)) 20))

(defn- next-level-number [current-xp]
  (cap-level (inc (cur-level-number current-xp)) 20))

(defn current-level [current-xp]
  (level->keyword (cur-level-number current-xp)))

(defn next-level [current-xp]
  (level->keyword (next-level-number current-xp)))

(defn xp-until-next-level [current-xp]
  (let [next-lvl (next-level current-xp)
        cur-level (cur-level-number current-xp)
        target-xp (get level-requirements next-lvl)]
    (if (= cur-level 20)
      0
      (- target-xp current-xp))))


