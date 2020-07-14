(ns clj-codewars.5kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu :refer :all]))

(deftest pig-latin-example-test
  (is (= (pig-it "Pig latin is cool") "igPay atinlay siay oolcay")))

(deftest pig-latin-example-test
  (is (= (pig-it "This is my string") "hisTay siay ymay tringsay")))

(deftest simple-maximum-subarray-sum
  (is (= (max-sequence [-2, 1, -3, 4, -1, 2, 1, -5, 4]) 6)))

(defn dotest [f n exp]
  (is (= (f n) exp)))

(deftest a-test1
  (testing "c (fixed 1)"
    (dotest sections 1 1)
    (dotest sections 4 4)
    (dotest sections 4096576 160)
    (dotest sections 2019 0)
    (dotest sections 423128 0)
    (dotest sections 1369 4)
    (dotest sections 2999824 28)
    (dotest sections 11710084 64)
    (dotest sections 14830201 4)))

(deftest a-test1-directions-reduction
  (testing "Test 1"
    (def ur ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"])
    (def vr ["WEST"])
    (is (= (dirReduc ur) vr))))

(deftest number-of-trailing-zeros-of-n
  (is (= (zeros 0) 0) "Zero has 0 trailing zeros")
  (is (= (zeros 6) 1))
  (is (= (zeros 30) 7)))

;; Simple assembler tests
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
;;----------------------------END---