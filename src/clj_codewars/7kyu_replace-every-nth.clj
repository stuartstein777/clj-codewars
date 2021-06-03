(ns stuartstein777.7kyu-replace-every-nth)

(defn reducer [old-val new-val n {:keys [result c] :as acc} i]
  (if (= i old-val)
    (-> acc
        (assoc :result (str result (if (and (>= c n) (zero? (rem c n)))
                                     new-val
                                     old-val)))
        (update :c inc))
    (-> acc
        (assoc :result (str result i)))))


(defn replace-nth [text n old-val new-val]
  (if (or (neg? n) (zero? n))
    text
    (->> text
         (reduce (partial reducer old-val new-val n) {:result "" :c 1})
         :result)))