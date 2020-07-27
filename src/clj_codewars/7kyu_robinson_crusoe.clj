(ns clj-codewars.7kyu-robinson-crusoe)

(defn crusoe [n d ang distance-multiplier angle-multiplier]
  ((fn [n d ang x y]
     (if (zero? n)
       [x y]
       (recur (dec n)
              (* d distance-multiplier)
              (* ang angle-multiplier)
              (+ x (* d (Math/cos (Math/toRadians ang))))
              (+ y (* d (Math/sin (Math/toRadians ang))))))) n d ang 0 0))