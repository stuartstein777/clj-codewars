;; WIP
(ns stuartstein777.2kyu-evaluate-mathematical-expression
  (:require [clojure.string :as str]))

(defn is-digit? [token]
  (Character/isDigit ^char token))

(defn is-operator? [token]
  (not (nil? (#{\+ \/ \* \( \)} token))))

(defn get-number [expr loc]
  (->> (drop loc expr)
       (take-while #(is-digit? %))
       (apply str)
       (Integer/parseInt)))

(defn type-of-dash [expr loc]
  (let [prev (nth expr (dec loc))
        next (nth expr (inc loc))]
    (cond (and (is-digit? prev) (is-digit? next))   :subtraction
          (and (is-digit? prev) (is-operator? next)) :subtraction
          (and (is-operator? prev) (is-digit? next)) :negation)))

(defn tokenize [expr]
  (let [expr (str/replace expr #" " "")]
    (loop [tokens []
           loc 0]
      (if (= loc (count expr))
        tokens
        (let [token (nth expr loc)]
          (cond
            ; token is a number
            ; so we need to keep taking digits till we don't hit a digit. Then parse it to an int.
            ; we then to move the location to the end of the number.
            (is-digit? token)
            (let [num (get-number expr loc)]
              (recur (conj tokens num) (+ loc (count (str num)))))

            ; token is an operator
            ; add it to the operators list and increase the location for the next token.
            (is-operator? token)
            (recur (conj tokens token) (inc loc))

            ; special case :: token is -
            ; this can mean either subtraction or negation.
            (= token \-)
            (let [dash-type (type-of-dash expr loc)]
              (cond (= dash-type :subtraction)
                    (recur (conj tokens token) (inc loc))
                    :else
                    ; its negation - so if the next char is a digit, then we have a negative number!
                    ; otherwise just add the - and carry on.
                    (if (is-digit? (nth expr (inc loc)))
                      (let [num (get-number expr (inc loc))]
                        (recur (conj tokens (- num)) (+ loc (inc (count (str num))))))
                      (recur (conj tokens token) (inc loc)))))

            ; ignore trash
            :else
            (recur tokens (inc loc))))))))

(defn precedence-check [op1 op2]
  (cond (or (= op1 \-) (= op1 \+)) (cond (= op2 \-) :same
                                         (= op2 \+) :same
                                         (= op2 \/) :lower
                                         (= op2 \*) :lower)

        (or (= op1 \*) (= op1 \/)) (cond (= op2 \-) :higher
                                         (= op2 \+) :higher
                                         (= op2 \/) :same
                                         (= op2 \*) :same)))


(defn get-lower-or-same-precedence-operators [token op-stack]
  (take-while (fn [t] (let [precedence (precedence-check token t)]
                        (or (= t \()
                            (= t \))
                            (= :same precedence)
                            (= :lower precedence)))) op-stack))

(defn format-state [token output op-stack]
  (let [output-str (str/join " " output)
        op-stack-str (str/join " " op-stack)
        token-str (str token)]
    (str
      "[" token-str "]" (apply str (repeat (- 20 (count token-str)) " "))
      "[" output-str "]" (apply str (repeat (- 50 (count output-str)) " "))
      "[" (str/join " " op-stack-str) "]")))

(defn to-rpn [tokens]
  (prn tokens)
  (loop [tokens tokens
         output []
         operators []]
    (if (empty? tokens)
      (apply conj output operators)
      (let [token (first tokens)]
        (println (format-state token output operators))
        (cond (number? token)
              (recur (rest tokens) (conj output token) operators)

              (= \( token)
              (recur (rest tokens) output (concat [token] operators))

              (= \) token)
              (let [paren-ops (take-while #(not= % \() operators)]
                (recur (rest tokens)
                       (apply conj output paren-ops)
                       (drop (inc (count paren-ops)) operators)))

              (or (= \+ token) (= \- token) (= \* token) (= \/ token))
              (let [popped-tokens (get-lower-or-same-precedence-operators token operators)]
                (recur (rest tokens)
                       (apply conj output popped-tokens)
                       (concat [token] (drop (count popped-tokens) operators))))

              :else
              (recur (rest tokens) output operators))))))


(defn get-function [i]
  (cond (= i \+) +
        (= i \-) -
        (= i \*) *
        (= i \/) /))

(defn evaluate-rpn [rpn]
  (loop [rpn rpn
         operand-stack []]
    (let [current (first rpn)]
      (if (empty? rpn)
        (first operand-stack)
        (if (number? current)
          (recur (rest rpn) (concat [current] operand-stack))
          (let [right (first operand-stack)
                left (second operand-stack)
                op-res (float ((get-function current) left right))]
            ;(println left (print-fun current) right "=" op-res)
            (recur (rest rpn) (concat [op-res] (drop 2 operand-stack)))))))))

(->> (tokenize "554521 + 33 - -6666 * (99)-(-41-1)- -2")
     (to-rpn)
     #_(evaluate-rpn))

"554521 + 33 - -6666 * (99)-(-41-1)- -2"
"554521 33 + -6666 99 * - -41 1 - - -2 -"
"1214532"

"1+2-3*4/5+(6)"
"1 2 + 3 4 * 5 / - 6 +"
" => 6.6"








;;==========================================================


(defn get-function [token]
  (cond (or (= token \() (= token \))) token
        (= token \+) +
        (= token \-) -
        (= token \/) /
        (= token \*) *))























(defn debug [d o]
  (println d "::" o)
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
    (str (if (nil? token) "    " (str "   " token)) (apply str (repeat 10 " "))
         "[" output-str "]" (apply str (repeat (- 50 (count output-str)) " "))
         "[" (str/join " " op-stack-str) "]")))
;;                                         *
;; Subtraction: "1-1"         number   operator number        subtraction
;;              "1--1"        number   operator operator      subtraction
;;              "1--1"        operator operator number        negation
;;              "1-(-1)       number operator paren           subtraction
;;              "1-(-1)       paren operator number           negation
;;              "1-(-(-1))
;;              "1-(-(-1))
;;              "1-(-(-1))
;;              "6+-(4)"

(defn subtraction-or-negation [expr loc]
  :subtraction
  )

(comment
  (prn (= :subtraction (subtraction-or-negation "1-1" 1)))
  (prn (= :subtraction (subtraction-or-negation "1--1" 1)))
  (prn (= :negation (subtraction-or-negation "1--1" 2)))
  (prn (= :negation (subtraction-or-negation "6+-(4)" 2)))
  (prn (= :negation (subtraction-or-negation "6+-(-4)" 4)))
  )

(defn parse [expr output op-stack loc]
  (let [expr (str/replace expr " " "")
        token (nth expr loc)]
    (if (not= token \space)
      (println (format-state token output op-stack)))
    (if (>= loc (count expr))
      (concat output op-stack)
      (cond (= token \()
            (recur expr output (concat [token] op-stack) (inc loc))

            (= token \))
            (let [paren-ops (get-ops-within-parens op-stack)]
              (recur expr
                     (apply conj output paren-ops)
                     (drop (inc (count paren-ops)) op-stack) (inc loc)))

            (= token \-)
            (cond (= \space (second expr))
                  (let [token-has-same-precedence (same-precedence? token (first op-stack))]
                    (if token-has-same-precedence
                      (recur expr (conj output (first op-stack)) (concat [token] (rest op-stack)) (inc loc))
                      (recur expr output (concat [token] op-stack) (inc loc))))

                  (= \( (second expr))
                  (recur expr (conj output "0") (concat [token] op-stack) (inc loc))

                  :else
                  (let [val (str token (handle-numbers (rest expr)))]
                    (recur expr (conj output val) op-stack (+ loc (count val)))))

            (is-operator? token)
            (let [token-has-same-precedence (same-precedence? token (first op-stack))]
              (if token-has-same-precedence
                (recur expr (conj output (first op-stack)) (concat [token] (rest op-stack)) (inc loc))
                (recur expr output (concat [token] op-stack) (inc loc))))

            (is-digit? token)
            (let [value (handle-numbers expr)]
              (recur expr
                     (conj output value)
                     op-stack
                     (+ loc (count value))))

            :else
            (recur expr output op-stack (inc loc))))))
(comment
  (let [expression "-(51) + (-80 / -55 * -(63)) - (-57 * ((((-97 + 95)))) / -75)"]
    (parse expression [] [] 0)))

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

(require '[clojure.spec.alpha :as s])

(binding [s/*recursion-limit* 50])
(defn foo [x]
  (prn x)
  (recur x))

(foo 5)

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

;-10688.0
(comment (let [expression "96 - 13 * 70 - 9929 + 55"]
           (println (str "Evaluating:: " expression))
           (->> (parse expression [] [])
                (debug "Converted to RPN")
                (evaluate-rpn))))
;1-1                  number,-,number                 => subtraction
;1 -1                 number,whitesapce,-,number      => subtraction


;; valid              @ -
;* 1-1    // 0         last was whitespace = false,    next is whitespace = true     =>    subtraction
;* 1 -1   // 0         last was whitespace = true,     next is whitespace = false    =>    subtraction
;* 1- 1   // 0         last was whitespace = false,    next is whitespace = true     =>    subtraction
; 1 - 1  // 0
; 1- -1  // 2
; 1 - -1 // 2
; 6 + -(4)   // 2
; 6 + -( -4) // 10
;; invalid
; 1 - - 1    // Invalid
; 1- - 1     // Invalid
; 6 + - (4)  // Invalid
; 6 + -(- 4) // Invalid