(ns clj-codewars.7kyu-robinson-crusoe)

(defn solve
  [n d ang dist-multiplier angle-multiplier x y]
  (if (zero? n)
    [x y]
    (recur (dec n)
           (* d dist-multiplier)
           (* ang angle-multiplier)
           dist-multiplier
           angle-multiplier
           (+ x (* d (Math/cos (Math/toRadians ang))))
           (+ y (* d (Math/sin (Math/toRadians ang)))))))

(defn crusoe [n d ang dist-mult ang-mult]
  (solve n d ang dist-mult ang-mult 0 0))
