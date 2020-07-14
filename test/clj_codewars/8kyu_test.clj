(ns clj-codewars.8kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.8kyu :refer :all]))

(deftest number-to-string-test-example
  (is (= (number-to-string 67) "67")))


(deftest opposite-test
  (is (= (opposite 1) -1)))

(deftest Tests
  (is (= (slope [19,3,20,3]) "0"))
  (is (= (slope [-7,2,-7,4]) "undefined"))
  (is (= (slope [10,50,30,150]) "5"))
  (is (= (slope [15,45,12,60]) "-5"))
  (is (= (slope [10,20,20,80]) "6"))
  (is (= (slope [-10,6,-10,3]) "undefined")))

(deftest kata-example-twist-tests
  (is (pos? (count websites)))
  (is (= 1000 (count websites)))
  (is (every? #(= "codewars" %) websites)))

(deftest simple-tests
  (is (= "Congratulations! You're going to have a son." (chromosome-check "XY")))
  (is (= "Congratulations! You're going to have a daughter." (chromosome-check "XX"))))

(deftest Tests-2
  (is (= (xor false false) false) "false xor false === false")
  (is (= (xor true false) true) "true xor false === true")
  (is (= (xor false true) true) "false xor true === true")
  (is (= (xor true true) false) "true xor true === false")
  (is (not= (xor true true) true) "'xor' is NOT identical to 'or'"))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "rental-car-cost"
    (test-assert (rental-car-cost  1) 40)
    (test-assert (rental-car-cost  3) 100)
    (test-assert (rental-car-cost  8) 270)))

(deftest Banjo-test
  (is (= (plays-banjo? "Adam") "Adam does not play banjo"))
  (is (= (plays-banjo? "Paul") "Paul does not play banjo"))
  (is (= (plays-banjo? "Ringo") "Ringo plays banjo"))
  (is (= (plays-banjo? "bravo") "bravo does not play banjo"))
  (is (= (plays-banjo? "rolf") "rolf plays banjo")))

(deftest Testing-lightsaber-count
  (is (= (howManyLightsabersDoYouOwn"") 0) "Blank string should return 0")
  (is (= (howManyLightsabersDoYouOwn "Adam") 0) "Other names should return 0")
  (is (= (howManyLightsabersDoYouOwn "Zach") 18) "Zach should return 18"))

(deftest examples
  (is (string-to-number "1234") 1234)
  (is (string-to-number "605") 605)
  (is (string-to-number "1405") 1405)
  (is (string-to-number "-7") -7))

(deftest hello-world
  (testing "Is it a function?"
    (is (function? greet-hw) "greet should be a function"))
  (testing "Does it return the correct value?"
    (is (= (greet-hw) "hello world!") "greet should return \"hello world!\"")))

(defn tester-1 [n e]
  (testing (str "Testing for " n)
    (is (= (summation n) e))))

(deftest basic-tests-0
  (tester-1 1 1)
  (tester-1 8 36)
  (tester-1 22 253)
  (tester-1 100 5050)
  (tester-1 213 22791))


(defn tester-2 [a b c d e]
  (testing (str "(seats-in-theater " a " " b " " c " " d ")")
    (is (= (seats-in-theater a b c d) e))))

(deftest basic-tests-1
  (tester-2 16 11 5 3 96)
  (tester-2 1 1 1 1 0)
  (tester-2 13 6 8 3 18)
  (tester-2 60 100 60 1 99)
  (tester-2 1000 1000 1000 1000 0))

(deftest basic-tests-terminal-mov
  (testing "(move 0 4)" (is (= (move 0 4) 8)))
  (testing "(move 3 6)" (is (= (move 3 6) 15)))
  (testing "(move 2 5)" (is (= (move 2 5) 12))))

(deftest basic-tests-monkey-counting
  (testing "Testing for 5" (is (= (monkey-count 5) [1 2 3 4 5])))
  (testing "Testing for 3" (is (= (monkey-count 3) [1 2 3])))
  (testing "Testing for 9" (is (= (monkey-count 9) [1 2 3 4 5 6 7 8 9])))
  (testing "Testing for 10" (is (= (monkey-count 10) [1 2 3 4 5 6 7 8 9 10])))
  (testing "Testing for 20" (is (= (monkey-count 20) [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20]))))

(defn tester-is-n-divisible-by-x-and-y [a b c exp]
  (testing (str "(isDivisible " a " " b " " c ")")
    (is (= (is-divisible a b c) exp))))

(deftest basic-tests-is-n-divisible-by-x-and-y
  (tester-is-n-divisible-by-x-and-y 3 3 4 false)
  (tester-is-n-divisible-by-x-and-y 12 3 4 true)
  (tester-is-n-divisible-by-x-and-y 8 3 4 false)
  (tester-is-n-divisible-by-x-and-y 48 3 4 true)
  (tester-is-n-divisible-by-x-and-y 100 5 10 true)
  (tester-is-n-divisible-by-x-and-y 100 5 3 false)
  (tester-is-n-divisible-by-x-and-y 4 4 2 true)
  (tester-is-n-divisible-by-x-and-y 5 2 3 false)
  (tester-is-n-divisible-by-x-and-y 17 17 17 true)
  (tester-is-n-divisible-by-x-and-y 17 1 17 true))

(defn test-assert-growth-of-a-population [act exp]
  (is (= act exp)))

(deftest a-test1-growth-of-a-population
  (testing "nb-year"
    (test-assert-growth-of-a-population(nb-year 1500, 5, 100, 5000), 15)
    (test-assert-growth-of-a-population(nb-year 1500000, 2.5, 10000, 2000000), 10)
    (test-assert-growth-of-a-population(nb-year 1500000, 0.25, 1000, 2000000), 94)))

(deftest a-test1-third-angle-of-a-triangle
  (testing "Test 1"
    (let [a 30
          b 60
          c 90]
      (is (= (third-angle a b) c)))))

(deftest even-or-odd-tests
  (is (= (even-or-odd 2) "Even"))
  (is (= (even-or-odd 0) "Even"))
  (is (= (even-or-odd 7) "Odd"))
  (is (= (even-or-odd 1) "Odd"))
  (is (= (even-or-odd -1) "Odd")))

(deftest basic-tests-nth-even-number
  (testing "Testing for 1" (is (= (nth-even 1) 0)))
  (testing "Testing for 2" (is (= (nth-even 2) 2)))
  (testing "Testing for 3" (is (= (nth-even 3) 4)))
  (testing "Testing for 100" (is (= (nth-even 100) 198)))
  (testing "Testing for 1298734" (is (= (nth-even 1298734) 2597466))))

(deftest Tests-sun-arrays
  (is (= (sum []) 0))
  (is (= (sum [1 2 3]) 6))
  (is (= (sum [1.1 2.2 3.3]) 6.6))
  (is (= (sum '(4 5 6)) 15))
  (is (= (sum (range 101)) 5050)))

(defn assert-equals-2 [act exp]
  (is (= act exp)))

(deftest better_than_average_test
  (testing "Basic Tests"
    (assert-equals-2 (better_than_average [2 3] 5) true)
    (assert-equals-2 (better_than_average [100 40 34 57 29 72 57 88] 75) true)
    (assert-equals-2 (better_than_average [12 23 34 45 56 67 78 89 90] 69) true) ))

(deftest simple-test-string-repeat
  (is (= (repeat-str 4 "a") "aaaa"))
  (is (= (repeat-str 3 "hello ") "hello hello hello "))
  (is (= (repeat-str 2 "abc") "abcabc")))

(deftest tests-compare-numbers
  (are [x answer] (= (what-is x) answer)
                  0 "nothing"
                  123 "nothing"
                  -1 "nothing"
                  42 "everything"
                  (* 42 42) "everything squared"))

(deftest testing-double-integer
  (is (= (double-integer 2) 4))
  (is (= (double-integer 4) 8))
  (is (= (double-integer -10) -20))
  (is (= (double-integer 0) 0))
  (is (= (double-integer 100) 200)))

(deftest testing-squaring-argument
  (is (= (square 2) 4) )
  (is (= (square 3) 9) ))

(defn tester-head-is-at-wrong-end [a exp]
  (testing (str "Testing for " a)
    (is (= (fix-the-meerkat a) exp))))

(deftest basic-tests-head-is-at-wrong-end
  (tester-head-is-at-wrong-end ["tail" "body" "head"] ["head" "body" "tail"])
  (tester-head-is-at-wrong-end ["tails" "body" "heads"] ["heads" "body" "tails"])
  (tester-head-is-at-wrong-end ["bottom" "middle" "top"] ["top" "middle" "bottom"])
  (tester-head-is-at-wrong-end ["lower legs" "torso" "upper legs"] ["upper legs" "torso" "lower legs"])
  (tester-head-is-at-wrong-end ["ground" "rainbow" "sky"] ["sky" "rainbow" "ground"]))

(deftest a-test1-sort-and-star
  (testing "Test1"
    (is (= (star-sort ["bitcoin" "take" "over" "the" "world" "maybe" "who" "knows" "perhaps"])
           "b***i***t***c***o***i***n"))))
(deftest a-test2-sort-and-star
  (testing "Test 2"
    (is (= (star-sort ["turns" "out" "random" "test" "cases" "are" "easier" "than" "writing" "out" "basic" "ones"])
           "a***r***e"))))
(deftest a-test3-sort-and-star
  (testing "Test 3"
    (is (= (star-sort ["lets" "talk" "about" "javascript" "the" "best" "language"])
           "a***b***o***u***t"))))
(deftest a-test4-sort-and-star
  (testing "Test 4"
    (is (= (star-sort ["i" "want" "to" "travel" "the" "world" "writing" "code" "one" "day"])
           "c***o***d***e"))))
(deftest a-test5-sort-and-star
  (testing "Test 5"
    (is (= (star-sort ["Lets" "all" "go" "on" "holiday" "somewhere" "very" "cold"])
           "L***e***t***s"))))

(defn tester-personalised-message [a b exp]
  (testing (str "(greet \"" a "\" \"" b "\")")
    (is (= (greet a b) exp))))

(deftest basic-tests-personalised-message
  (tester-personalised-message "Daniel" "Daniel" "Hello boss")
  (tester-personalised-message "Greg" "Daniel" "Hello guest"))

(deftest basic-tests-do-i-get-a-bonus
  (is (= (bonus-time 10000 true) "$100000"))
  (is (= (bonus-time 25000 true) "$250000"))
  (is (= (bonus-time 10000 false) "$10000"))
  (is (= (bonus-time 60000 false) "$60000"))
  (is (= (bonus-time 2 true) "$20"))
  (is (= (bonus-time 78 false) "$78"))
  (is (= (bonus-time 67890 true) "$678900")))

(deftest basic-tests-messi-goals
  (testing "(goals 0 0 0)" (is (= (goals 0 0 0) 0)))
  (testing "(goals 43 10 5)" (is (= (goals 43 10 5) 58))))

(defn tester-check-for-factor [base factor exp]
  (testing (str "(check-for-factor " base " " factor ")")
    (is (= (check-for-factor base factor) exp))))

(deftest basic-tests-check-for-factor
  (tester-check-for-factor 10 2 true)
  (tester-check-for-factor 63 7 true)
  (tester-check-for-factor 2450 5 true)
  (tester-check-for-factor 24612 3 true)
  (tester-check-for-factor 9 2 false)
  (tester-check-for-factor 653 7 false)
  (tester-check-for-factor 2453 5 false)
  (tester-check-for-factor 24617 3 false))

(deftest century-from-year-tests
  (testing "Year 1705"
    (is (= (century 1705) 18)))
  (testing "Year 1900"
    (is (= (century 1900) 19)))
  (testing "Year 1601"
    (is (= (century 1601) 17)))
  (testing "Year 2000"
    (is (= (century 2000) 20))))

(deftest get-the-mean-of-an-array-tests
  (is (= (get-average [2, 2, 2, 2]) 2))
  (is (= (get-average [1, 5, 87, 45, 8, 8]) 25))
  (is (= (get-average [2,5,13,20,16,16,10]) 11))
  (is (= (get-average [1,2,15,15,17,11,12,17,17,14,13,15,6,11,8,7]) 11)))

(deftest calculate-average-tests
  (is (= 1 (find-average [1 1 1])))
  (is (= 2 (find-average [1 2 3])))
  (is (= 2.5 (double (find-average [1 2 3 4])))))

(deftest whats-up-next-tests
  (is (= (next-item (range 1 25) 12) 13))
  (is (= (next-item "testing" \t) \e))
  (is (nil? (next-item [:a :b :c] :d)))
  (is (nil? (next-item [:a :b :c] :c))))

(deftest regex-count-lowercase-letters-tests
  (testing "Basic Tests"
    (is (= (lowercase_count "abc") 3))
    (is (= (lowercase_count "abcABC123") 3))
    ;note that this had to remove an escape character because of clojure's string rules
    (is (= (lowercase_count "abcABC123!@#$%^&*()_-+=}{[]|':;?/>.<,~") 3))
    (is (= (lowercase_count "") 0))
    ;note that this had to remove an escape character because of clojure's string rules
    (is (= (lowercase_count "ABC123!@#$%^&*()_-+=}{[]|':;?/>.<,~") 0))
    (is (= (lowercase_count "abcdefghijklmnopqrstuvwxyz") 26))))

(deftest barycenter-tests
  (testing "Basic tests"
    (is (= (bar-triang [4, 6], [12, 4], [10, 10]) [8.6667, 6.6667]))
    (is (= (bar-triang [4, 2], [12, 2], [6, 10]) [7.3333, 4.6667]))
    (is (= (bar-triang [4, 8], [8, 2], [16, 6]) [9.3333, 5.3333]))
    (is (= (bar-triang [0, 0], [1, 3], [-1, 6]) [0.0, 3.0]))
    (is (= (bar-triang [0, 0], [1, 6], [8, -6]) [3.0, 0.0]))))

(deftest no-zeros-for-heros-tests
  (testing "noboringzeros"
    (is (= (no-boring-zeros 1450) 145))
    (is (= (no-boring-zeros 960000) 96))
    (is (= (no-boring-zeros 1050) 105))
    (is (= (no-boring-zeros -960000) -96))))

(deftest exclamation-marks-series-4-tests
  (let [greetings ["Hi", "Hi!", "Hi!!!!", "!Hi", "!Hi!", "Hi Hi!!", "Hi!\nHi", "!!!!!!!"]
        expected ["Hi!", "Hi!", "Hi!", "Hi!", "Hi!", "Hi Hi!", "Hi\nHi!", "!"]]
    (doall (map #(is (= (remove-bang %1) %2) "Basic tests") greetings expected))))

(deftest fcc-reverse-test
  (is (string? (reverse-string "hello"))
      "should return a string")
  (is (= (reverse-string "hello")
         "olleh")
      "should return \"olleh\"")
  (is (= (reverse-string "Howdy")
         "ydwoH")
      "should return \"ydwoH\"")
  (is (= (reverse-string "Greetings from Earth")
         "htraE morf sgniteerG")
      "should return \"htraE morf sgniteerG\""))

(deftest rps-tests
  (testing "player 1 win"
    (are [p1 p2] (= "Player 1 won!" (rps p1 p2))
                 "rock" "scissors"
                 "scissors" "paper"
                 "paper" "rock"))
  (testing "player 2 win"
    (are [p1 p2] (= "Player 2 won!" (rps p1 p2))
                 "scissors" "rock"
                 "paper" "scissors"
                 "rock" "paper"))
  (testing "draw"
    (are [p1 p2] (= "Draw!" (rps p1 p2))
                 "rock" "rock"
                 "scissors" "scissors"
                 "paper" "paper")))

(deftest digitize-tests
  (is (= (digitize 35231) [1 3 2 5 3])))

(deftest
  how-old-test
  (testing "Testing how old"
    (is (= (how-old "1 year old") 1))
    (is (= (how-old "6 years old") 6))))