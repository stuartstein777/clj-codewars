(ns clj-codewars.6kyu-calculate-string-rotation)

(defn shifted-diff [first second]
  (let [first first
        second second]
    (if (= first second)
      0
      (let [cnt (count first)]
        (loop [s first
               c 1]
          (let [rot (str (last s) (apply str (butlast s)))]
            (cond (= c cnt) -1
                  (= rot second) c
                  :else (recur rot (inc c)))))))))