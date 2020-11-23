(ns clj-codewars.2kyu-evaluate-mathematical-expression
  (:require [clojure.string :as str]))

(defn debug [o]
  (tap> o)
  o)

(defn is-digit? [token]
  (not (nil? (#{\0 \1 \2 \3 \4 \5 \6 \7 \8 \9} token))))

(defn handle-numbers [expr]
  (apply str (take-while is-digit? expr)))

(defn get-ops-within-parens [op-stack]
  (take-while #(not= \( %) op-stack))

(defn is-operator? [token]
  (or (= \+ token)
      (= \* token)
      (= \/ token)))

(defn same-precedence? [token top-stack]
  (or (and (or (= token \/)
               (= token \*))
           (or (= top-stack \/)
               (= top-stack \*)))
      (and (or (= token \-)
               (= token \+))
           (or (= top-stack \+)
               (= top-stack \-)))))

(defn format-state [token output op-stack]
  (let [output-str (str/join " " output)
        op-stack-str (str/join " " op-stack)]
    (str (if (nil? token) " " token) (apply str (repeat 10 " "))
         "[" output-str "]" (apply str (repeat (- 50 (count output-str)) " "))
         "[" (str/join " " op-stack-str) "]")))

(defn parse [expr output op-stack]
  (let [token (first expr)]
    #_(if (not= token \space)
        (println (format-state token output op-stack)))
    (if (empty? expr)
      (concat output op-stack)
      #_(println "\nResult:: [" (str/join " " (concat output op-stack)) "]")
      (cond (= token \()
            (recur (rest expr) output (concat [token] op-stack))

            (= token \))
            (let [paren-ops (get-ops-within-parens op-stack)]
              (recur (rest expr)
                     (apply conj output paren-ops)
                     (drop (inc (count paren-ops)) op-stack)))

            (= token \-)
            (cond (= \space (second expr))
                  (let [token-has-same-precedence (same-precedence? token (first op-stack))]
                    (if token-has-same-precedence
                      (recur (rest expr) (conj output (first op-stack)) (concat [token] (rest op-stack)))
                      (recur (rest expr) output (concat [token] op-stack))))

                  (= \( (second expr))
                  (recur (rest expr) (conj output "0") (concat [token] op-stack))

                  :else
                  (let [val (str token (handle-numbers (rest expr)))]
                    (recur (drop (count val) expr) (conj output val) op-stack)))


            (is-operator? token)
            (let [token-has-same-precedence (same-precedence? token (first op-stack))]
              (if token-has-same-precedence
                (recur (rest expr) (conj output (first op-stack)) (concat [token] (rest op-stack)))
                (recur (rest expr) output (concat [token] op-stack))))

            (is-digit? token)
            (let [value (handle-numbers expr)]
              (recur (drop (count value) expr)
                     (conj output value)
                     op-stack))

            :else
            (recur (rest expr) output op-stack)))))

(let [expression "-(51) + (-80 / -55 * -(63)) - (-57 * ((((-97 + 95)))) / -75)"]
  (parse expression [] []))

;; https://www.free-online-calculator-use.com/postfix-evaluator.html#

(defn print-fun [f]
  (cond (= f +) "+"
        (= f -) "-"
        (= f /) "/"
        (= f *) "*"))

(defn get-function [i]
  (cond (= i \+) +
        (= i \-) -
        (= i \*) *
        (= i \/) /))

(defn evaluate-rpn [rpn]
  (loop [rpn (map (fn [i] (if (char? i) (get-function i) (Integer/parseInt i))) rpn)
         operand-stack []]
    (let [current (first rpn)]
      (if (empty? rpn)
        (first operand-stack)
        (if (number? current)
          (recur (rest rpn) (concat [current] operand-stack))
          (let [right (first operand-stack)
                left (second operand-stack)
                op-res (float (current left right))]
            (println left (print-fun current) right "=" op-res)
            (recur (rest rpn) (concat [op-res] (drop 2 operand-stack)))))))))

(let [expression "-(51) + (-80 / -55 * -(63)) - (-57 * ((((-97 + 95)))) / -75)"]
  (->> (parse expression [] [])
       (evaluate-rpn)))




