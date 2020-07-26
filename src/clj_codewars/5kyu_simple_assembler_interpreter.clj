(ns clj-codewars.5kyu-simple-assembler-interpreter
  (:require [clojure.string :as str]))

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