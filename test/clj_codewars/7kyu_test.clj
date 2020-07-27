(ns clj-codewars.7kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu :refer :all]))

(defn do-test [fn param exp]
  (is (= (fn param) exp)))

(deftest sample-tests
  (are [inp exp] (= exp (calc inp))
                 "ABC" 6
                 "abcdef" 6
                 "ifkhchlhfd" 6
                 "aaaaaddddr" 30
                 "jfmgklf8hglbe" 6
                 "jaam" 12))

(defn assert-equals [act exp]
  (is (= act exp)))

(deftest score-tests
  (testing "Basic"
    (assert-equals (score 0) 0)
    (assert-equals (score 1) 1)
    (assert-equals (score 49) 63)
    (assert-equals (score 1000000) 1048575)))

(deftest test-quote
  (is (= "How Can Mirrors Be Real If Our Eyes Aren't Real"
         (jaden-case "How can mirrors be real if our eyes aren't real"))))

(deftest a-test1
  (testing "Test 1"
    (is (= (evaporator 10 10 10) 22))))

(defn dotest [n ans]
  (is (= (solve-alternate-capitalization n) ans)))

(deftest Example-tests
  (testing "Basic Tests"
    (dotest  "abcdef" ["AbCdEf" "aBcDeF"])
    (dotest  "codewars" ["CoDeWaRs", "cOdEwArS"])
    (dotest "abracadabra" ["AbRaCaDaBrA", "aBrAcAdAbRa"])
    (dotest "indexinglessons" ["InDeXiNgLeSsOnS", "iNdExInGlEsSoNs"])))

(deftest Testing...
  (is (= (disemvowel "This website is for losers LOL!") "Ths wbst s fr lsrs LL!")))

(deftest hydrate-test1
  (def text "1 beer")
  (def expected "1 glass of water")
  (def actual (hydrate text))
  (is (= actual expected)))

(deftest hydrate-test3
  (def text "1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer")
  (def expected "10 glasses of water")
  (def actual (hydrate text))
  (is (= actual expected)))

(defn tester [n e]
  (testing (str "Testing for " n)
    (is (= (late-ride n) e))))

(deftest basic-tests
  (tester 240 4)
  (tester 808 14)
  (tester 1439 19)
  (tester 0 0)
  (tester 23 5)
  (tester 8 8))

(defn tester-cd [n exp]
  (testing (str "Testing for " n)
    (is (= (consecutive-ducks n) exp))))

(deftest check-small-values
  (tester-cd 69 true)
  (tester-cd 8 false)
  (tester-cd 57 true)
  (tester-cd 6 true)
  (tester-cd 13 true)
  (tester-cd 16 false)
  (tester-cd 91 true)
  (tester-cd 75 true)
  (tester-cd 38 true)
  (tester-cd 25 true)
  (tester-cd 32 false)
  (tester-cd 65 true)
  (tester-cd 13 true)
  (tester-cd 16 false)
  (tester-cd 99 true))

(deftest check-medium-values
  (tester-cd 522 true)
  (tester-cd 974 true)
  (tester-cd 755 true)
  (tester-cd 512 false)
  (tester-cd 739 true)
  (tester-cd 1006 true)
  (tester-cd 838 true)
  (tester-cd 1092 true)
  (tester-cd 727 true)
  (tester-cd 648 true)
  (tester-cd 1024 false)
  (tester-cd 851 true)
  (tester-cd 541 true)
  (tester-cd 1011 true)
  (tester-cd 822 true))

(deftest check-large-values
  (tester-cd 382131 true)
  (tester-cd 118070 true)
  (tester-cd 17209 true)
  (tester-cd 32768 false)
  (tester-cd 161997 true)
  (tester-cd 400779 true)
  (tester-cd 198331 true)
  (tester-cd 325482 true)
  (tester-cd 88441 true)
  (tester-cd 648 true)
  (tester-cd 65536 false)
  (tester-cd 323744 true)
  (tester-cd 183540 true)
  (tester-cd 65271 true)
  (tester-cd 5263987 true))

(deftest IPv4-validator-tests
  (testing "Testing how old"
    (is (false? (validate-ip "")))
    (is (false? (validate-ip "12.b.3.a")))
    (is (validate-ip "32.64.128.255"))))

(deftest test-penultimate
  (let [input1 [1 9 13 1 99 9 9 13]]
    (testing (prn-str input1)
      (is (= (penultimate input1) 9)))))

(deftest basic-test-average-scores
  (testing "Empty collection"
    (is (= 0 (average []))))
  (testing "One-element collection"
    (is (= 3 (average [3]))))
  (testing "Normal collection"
    (is (= 4 (average [5 3 3 5]))))
  (testing "When mean isn't int"
    (is (= 8 (average [7 8 9 10])))))

(defn test-assert-parts-of-a-list [act exp]
  (is (= act exp)))

(deftest a-test1-parts-of-a-list
  (testing "partlist"
    (test-assert-parts-of-a-list (partlist ["I", "wish", "I", "hadn't", "come"]),
                                 '[("I", "wish I hadn't come"), ("I wish", "I hadn't come"), ("I wish I", "hadn't come"), ("I wish I hadn't", "come")])
    (test-assert-parts-of-a-list (partlist ["cdIw", "tzIy", "xDu", "rThG"]),
                                 '[("cdIw", "tzIy xDu rThG"), ("cdIw tzIy", "xDu rThG"), ("cdIw tzIy xDu", "rThG")])
    (test-assert-parts-of-a-list (partlist ["vJQ", "anj", "mQDq", "sOZ"]),
                                 '[("vJQ", "anj mQDq sOZ"), ("vJQ anj", "mQDq sOZ"), ("vJQ anj mQDq", "sOZ")])))

(deftest is-triangular-test
  (testing "Triangular Numbers"
    (is (is-triangular 1)  "Failed when t = 1")
    (is (is-triangular 3)  "Failed when t = 3")
    (is (is-triangular 6)  "Failed when t = 6")
    (is (is-triangular 10) "Failed when t = 10")
    (is (is-triangular 15) "Failed when t = 15")
    (is (is-triangular 21) "Failed when t = 21")
    (is (is-triangular 28) "Failed when t = 28"))
  (testing "Non Triangular Numbers"
    (is (not (is-triangular 2))  "Failed when t = 2")
    (is (not (is-triangular 7))  "Failed when t = 7")
    (is (not (is-triangular 14)) "Failed when t = 14")
    (is (not (is-triangular 27)) "Failed when t = 27")))

(defn dotest-potatoes [p0 w0 p1 sol]
  (is (= (potatoes p0 w0 p1) sol)))

(deftest a-test
  (println "Basic Tests")
  (dotest-potatoes 82 127 80 114)
  (dotest-potatoes 93 129 91 100))

(deftest SampleTests-reverse-longer
  (is (= (reverseLonger "first" "abcde") "abcdetsrifabcde" ))
  (is (= (reverseLonger "hello" "bau") "bauollehbau"))
  (is (= (reverseLonger "abcde" "fghi") "fghiedcbafghi"))
  (is (= (reverseLonger "abc" "123") "123cba123"))
  (is (= (reverseLonger "" "123") "321"))
  (is (= (reverseLonger "abc" "") "cba")))

(defn tester-strong-numbers [n exp]
  (testing (str "Testing for " n)
    (is (= (strong n) exp))))

(deftest basic-tests-strong-numbers
  (tester-strong-numbers 1 "STRONG!!!!")
  (tester-strong-numbers 2 "STRONG!!!!")
  (tester-strong-numbers 145 "STRONG!!!!")
  (tester-strong-numbers 40585 "STRONG!!!!")
  (tester-strong-numbers 7 "Not Strong !!")
  (tester-strong-numbers 93 "Not Strong !!")
  (tester-strong-numbers 185 "Not Strong !!"))

(deftest test-last-function
  (testing "[1 9 13 1 99 9 9 13]"
    (is (= (last-cw [1 9 13 1 99 9 9 13]) 13)))
  (testing "Empty list"
    (is (= (last-cw '()) nil)))
  (testing "String: \"I suppose I should learn Lisp, but it seems so foreign.\" - Paul Graham, Nov 1983"
    (is (= (last-cw "\"I suppose I should learn Lisp, but it seems so foreign.\" - Paul Graham, Nov 1983") \3))))

(deftest averages-test
  (are [in out] (= (averages in) out)
                '(2 2 2 2 2) '(2.0 2.0 2.0 2.0)
                '(2 -2 2 -2 2) '(0.0 0.0 0.0 0.0)
                '(1 3 5 1 -10) '(2.0 4.0 3.0 -4.5)))

(deftest excel-sheet-column-numbers
  (testing "Basic tests"
    (is (= (title-to-nb "A") 1))
    (is (= (title-to-nb "Z") 26))
    (is (= (title-to-nb "AA") 27))
    (is (= (title-to-nb "AZ") 52))
    (is (= (title-to-nb "BA") 53))
    (is (= (title-to-nb "CODEWARS") 28779382963))))

(deftest share-price-tests
  (is (= (share-price 100 []) "100.00"))
  (is (= (share-price 100 [-50 50]) "75.00"))
  (is (= (share-price 100 [-50 100]) "100.00"))
  (is (= (share-price 100 [-20 30]) "104.00"))
  (is (= (share-price 1000 [0 2 3 6]) "1113.64")))

(deftest basic-test-more-than-one-way-to-skin-a-cat
  (testing "two parameters"
    (is (= (sum 5 5) 10)))
  (testing "one parameter"
    (is (= ((sum 5) 5) 10))))

(defn test-assert-benefactor [act exp]
  (is (= act exp)))

(deftest a-test1-benefactor
  (testing "new-avg"
    (test-assert-benefactor (new-avg [14, 30, 5, 7, 9, 11, 16] 90) 628)
    (test-assert-benefactor (new-avg [14, 30, 5, 7, 9, 11, 15] 92) 645)
    (is (thrown? IllegalArgumentException (new-avg [14, 30, 5, 7, 9, 11, 15] 2)))))