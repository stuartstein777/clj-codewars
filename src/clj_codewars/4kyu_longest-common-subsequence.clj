(ns stuartstein777.4kyu-longest-common-subsequence)

(defn update-tbl-on-match [tbl mc idxn idxm]
  (assoc tbl [idxn idxm] (str (tbl [(dec idxn) (dec idxm)] "") mc)))

(defn update-tbl-on-compete [tbl idxn idxm]
  (let [nc (tbl [(dec idxn) idxm] "")
        mc (tbl [idxn (dec idxm)] "")]
    (if (> (count nc) (count mc))
      (assoc tbl [idxn idxm] nc)
      (assoc tbl [idxn idxm] mc))))

(defn lcs
  [^String m ^String n]
  (if (or (= "" m) (= "" n))
    ""
    (let [len-m (count m)
          len-n (count n)]
      (->> (loop [idxn 0
                  tbl (sorted-map)]
             (if (= len-n idxn)
               tbl
               (recur (inc idxn)
                      (loop [idxm 0
                             tbl tbl]
                        (if (= idxm len-m)
                          tbl
                          (let [mc (nth m idxm)
                                nc (nth n idxn)]
                            (if (= mc nc)
                              (recur (inc idxm)
                                     (update-tbl-on-match tbl mc idxn idxm))
                              (recur (inc idxm)
                                     (update-tbl-on-compete tbl idxn idxm)))))))))
           last
           val))))
