(ns clj-codewars.5kyu
  (:require [clojure.string :as str]))

;; Simple Pig Latin
; Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
; Examples
;   (piglatin/pig-it "Pig latin is cool") ; "igPay atinlay siay oolcay"
;   (piglatin/pig-it "Hello world !")     ; "elloHay orldway !"


(def letters #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z
               \A \B \C \D \E \F \G \H \I \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z})

(defn to-pig-latin [word]
  (let [a    (take-while letters word)
        punc (apply str (drop (count a) word))]
    (cond (zero? (count a)) word
          :else (str (apply str (rest a)) (str (first a)) "ay" punc))))

(defn pig-it [s]
  (->> (str/split s #" ")
       (map to-pig-latin)
       (str/join " ")))
;; -------------------------------------------END---

;; Maximum subarray sum
; The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list
; of integers:
;
; (max-sequence [-2, 1, -3, 4, -1, 2, 1, -5, 4])
; should be 6: [4, -1, 2, 1]
;
; Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If
; the list is made up of only negative numbers, return 0 instead.
;
; Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid
; sublist/subarray.

(defn max-sequence [xs]
  (loop [max-found 0
         arr xs]
    (if (empty? arr)
      max-found
      (let [m (apply max (reductions + arr))]
        (recur (if (> m max-found) m max-found) (rest arr))))))
;; -------------------------------------------END---

;; Sections
; Consider the following equation of a surface S: z*z*z = x*x * y*y. Take a cross section of S by a plane P: z = k
; where k is a positive integer (k > 0). Call this cross section C(k).
; Task
; Find the number of points of C(k) whose coordinates are positive integers.
; Examples
;
; If we call c(k) the function which returns this number we have
;
;     c(1) -> 1
;     c(4) -> 4
;     c(4096576) -> 160
;     c(2019) -> 0 which means that no point of C(2019) has integer coordinates.
;
; Notes
;    k can go up to about 10,000,000,000
;    Prolog: the function cis called section.
;    Please could you ask before translating : some translations are already written.

(defn solve [^double n]
  (let [xy (*' n n n)
        s (Math/sqrt xy)]
    (loop [x 1.0 solutions 0]
      (if (> x s)
        solutions
        (if (zero? (mod xy x))
          (let [y (/ xy x)]
            (if (= x y)
              (recur (inc x) (inc solutions))
              (recur (inc x) (+ 2 solutions))))
          (recur (inc x) solutions))))))

(defn sections [n] (solve (Math/sqrt n)))
;; -------------------------------------------END---

;; Directions Reduction
; Once upon a time, on a way through the old wild mountainous west,…
; … a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST".
; Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
; Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild
; west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die
; of thirst!
; How I crossed a mountain desert the smart way.
; The directions given to the man are, for example, the following (depending on the language):
;     ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
; or
;     { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
; or
;     [North, South, South, East, West, North, West]
; You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place!
; So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
;     ["WEST"]
;
; or
;
;     { "WEST" }
;
; or
;
;     [West]
; In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
; The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is []
; (nil in Clojure).
; In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become
; directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
; Task
; Write a function dirReduc which will take an array of strings and returns an array of strings with the needless
; directions removed (W<->E or S<->N side by side).
;
;    The Clojure version returns nil when the path is reduced to nothing.

(defn dirReduc
  [arr]
  ((fn [directions]
     (let [red (str/replace directions #"NORTHSOUTH|EASTWEST|SOUTHNORTH|WESTEAST" "")]
       (if (= red directions)
         (re-seq #"EAST|NORTH|WEST|SOUTH" red)
         (recur red)))) (str/join "" arr)))
;; -------------------------------------------END---

;; Number of trailing zeros of N!
; Write a program that will calculate the number of trailing zeros in a factorial of a given number.
;
;     N! = 1 * 2 * 3 * ... * N
;
; Be careful 1000! has 2568 digits...
;
; For more info, see: http://mathworld.wolfram.com/Factorial.html
; Examples
;
;       zeros(6) = 1
;       # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
;
;       zeros(12) = 2
;       # 12! = 479001600 --> 2 trailing zeros
;
; Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.

(defn zeros [n]
  (loop [i 5.0
         c 0.0]
    (if (< (/ n i) 1)
      (int (Math/floor c))
      (recur (* i 5) (+ c (/ n i))))))
;; -------------------------------------------END---

;; Simple assembler interpreter
; We want to create a simple interpreter of assembler which will support the following instructions:
;
;    mov x y - copies y (either a constant value or the content of a register) into register x
;    inc x - increases the content of the register x by one
;    dec x - decreases the content of the register x by one
;    jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward, y can be a
;              register or a constant), but only if x (a constant or a register) is not zero
;
; Register names are alphabetical (letters only). Constants are always integers (positive or negative).
; Note: the jnz instruction moves relative to itself. For example, an offset of -1 would continue at the previous
; instruction, while an offset of 2 would skip over the next instruction.
; The function will take an input list with the sequence of the program instructions and will execute them. The program
; ends when there are no more instructions to execute, then it returns a dictionary with the contents of the registers.
; Also, every inc/dec/jnz on a register will always be preceeded by a mov on the register first, so you don't need to
; worry about uninitialized registers.
;
; Example
;       (simple-assembler ["mov a 5" "inc a" "dec a" "dec a" "jnz a -1" "inc a"])
;
;       (comment "visualized:
;         mov a 5
;         inc a
;         dec a
;         dec a
;         jnz a -1
;         inc a")
;
; The above code will:
;
; set register a to 5,
; increase its value by 1,
; decrease its value by 2,
; then decrease its value until it is zero (jnz a -1 jumps to the previous instruction if a is not zero)
; and then increase its value by 1, leaving register a at 1
; So, the function should return
;
;     {:a 1}
(defn- is-register? [x]
  (nil? (re-find #"[0-9]" x)))

(defn- get-register-value [registers register]
  (get registers (keyword register)))

(defn asm-mov [registers op1 op2]
  (cond (is-register? op2) (assoc registers (keyword op1) (get-register-value registers op2))
        :else              (assoc registers (keyword op1) (Integer/parseInt op2))))

(defn asm-inc [registers register]
  (update registers (keyword register) inc))

(defn asm-dec [registers register]
  (update registers (keyword register) dec))

(defn asm-jnz [registers op1 op2 ip]
  (let [x-val (if (is-register? op1) (get-register-value registers op1) (Integer/parseInt op1))
        y-val (if (is-register? op2) (get-register-value registers op2) (Integer/parseInt op2))]
    (cond (not (zero? x-val)) (+ ip y-val)
          :else             (inc ip))))

(defn assembler
  ([instructions]
   (assembler instructions {} 0))
  ([instructions registers ip]
   (if (>= ip (count instructions))
     registers
     (let [[operator register value] (str/split (nth instructions ip) #" ")]
       (cond (= operator "mov") (recur instructions (asm-mov registers register value) (inc ip))
             (= operator "inc") (recur instructions (asm-inc registers register) (inc ip))
             (= operator "dec") (recur instructions (asm-dec registers register) (inc ip))
             (= operator "jnz") (recur instructions registers (asm-jnz registers register value ip)))))))
;; -------------------------------------------END---