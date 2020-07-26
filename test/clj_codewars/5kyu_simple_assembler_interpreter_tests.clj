(ns clj-codewars.5kyu-simple-assembler-interpreter-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-simple-assembler-interpreter :refer :all]))

(deftest simple-assembler-mov-1
  (is (= (assembler ["mov x 5"]) {:x 5})))

(deftest simple-assembler-mov-2
  (is (= (assembler ["mov y 6"]) {:y 6})))

(deftest simple-assembler-multi-instructions-1
  (is (= (assembler ["mov x 5" "mov y 6"]) {:x 5 :y 6})))

(deftest simple-assembler-multi-instructions-2
  (is (= (assembler ["mov x 5" "mov y 6" "inc x"]) {:x 6 :y 6})))

(deftest simple-assembler-multi-instructions-3
  (is (= (assembler ["mov x 5" "mov y 6" "inc x" "inc y"]) {:x 6 :y 7})))

(deftest simple-assembler-multi-instructions-4
  (is (= (assembler ["mov x 5" "mov y 6" "inc x" "inc y" "dec x"]) {:x 5 :y 7})))

(deftest simple-assembler-multi-instructions-5
  (is (= (assembler ["mov a 5" "inc a" "dec a" "dec a" "jnz a -1" "inc a"]) {:a 1})))

(deftest simple-assembler-multi-instructions-6
  (is (= (assembler ["mov c 12"
                     "mov b 0"
                     "mov a 200"
                     "dec a"
                     "inc b"
                     "jnz a -2"
                     "dec c"
                     "mov a b"
                     "jnz c -5"
                     "jnz 0 1"
                     "mov c a"]) {:a 409600 :b 409600 :c 409600})))

(deftest simple-assembler-mov-basic-1
  (is (= {:x 6} (asm-mov {:x 5} "x"  "6"))))

(deftest simple-assembler-mov-between-two-registers
  (is (= {:x 6 :y 6} (asm-mov {:x 5 :y 6} "x" "y"))))

(deftest simple-assembler-inc
  (is (= (asm-inc {:x 5} "x") {:x 6})))

(deftest simple-assembler-dec
  (is (= (asm-dec {:x 5} "x") {:x 4})))

(deftest simple-assembler-jnz-basic-1
  (is (= 9 (asm-jnz {:x 1} "x" "4" 5))))

(deftest simple-assembler-jnz-basic-conditional-is-zero
  (is (= 6 (asm-jnz {:x 0} "x" "4" 5))))

(deftest simple-assembler-jnz-basic-conditional-is-not-zero-y-is-reg
  (is (= 7 (asm-jnz {:x 1 :y 2} "x" "y" 5))))

(deftest simple-assembler-jnz-basic-conditional-is-zero-y-is-reg
  (is (= 6 (asm-jnz {:x 0 :y 6} "x" "y" 5))))
