(ns clj-codewars.7kyu-alphabetical-addition)

;; Alphabetical Addition
; Your task is to add up letters to one letter.
;
; The function will be given a vector of letters, each one being a letter (chars) to add. Return a char.
; Notes:
;
;    Letters will always be lowercase.
;    Letters can overflow (see second to last example of the description)
;    If no letters are given, the function should return 'z'
;
; Examples:
;
;     (add-letters [\a \b \c]) ;; \f
;     (add-letters [\z]) ;; \z
;     (add-letters [\a \b]) ;; \c
;     (add-letters [\c]) ;; \c
;     (add-letters [\z \a]) ;; \a
;     (add-letters [\y \c \b]) ;; \d ;; notice the letters overflowing
;     (add-letters []) ;; \z

(def alphabet {\a 1 \b 2 \c 3 \d 4 \e 5 \f 6 \g 7 \h 8 \i 9 \j 10 \k 11 \l 12 \m 13
               \n 14 \o 15 \p 16 \q 17 \r 18 \s 19 \t 20 \u 21 \v 22 \w 23 \x 24 \y 25 \z 26})

(defn add-letters [letters]
  (cond (empty? letters) \z
        :else (as-> (map #(alphabet %) letters) v
                    (reduce + 0 v)
                    (mod v 26)
                    (cond (= 0 v) \z
                          :else (char (+ 96 v))))))
