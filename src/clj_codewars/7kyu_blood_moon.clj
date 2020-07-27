(ns clj-codewars.7kyu-blood-moon)

;; Blood Moon
;
(defn blood-moon [n]
  (let [r n
        sq-acdf (* r r)
        cf (Math/sqrt (+ (* r r)(* r r)))
        c-acdf (* Math/PI (* cf cf))
        semi-ahf (/ (- c-acdf sq-acdf) 4)
        agf (* Math/PI (* r r))]
    (- (/ agf 2) semi-ahf)))
