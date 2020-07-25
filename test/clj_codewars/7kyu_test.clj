(ns clj-codewars.7kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu :refer :all]
            [clj-codewars.7kyu-2 :refer :all]
            [clj-codewars.7kyu-3 :refer :all]
            [clj-codewars.7KYU-4 :refer :all]))

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

(def EPSILON 0.001)
(defn abs [n] (max n (- n)))
(defn do-test-blood-moon   [n exp]
  (let [actual (blood-moon n)]
    (is
      (<= (abs (- actual exp)) EPSILON)
      (str "Expected " exp " (+/- " EPSILON ")\nReceived " actual))))
(deftest basic-tests-blood-moon
  (testing "Testing for 0" (do-test-blood-moon 0 0))
  (testing "Testing for 1" (do-test-blood-moon 1 0.25))
  (testing "Testing for 2" (do-test-blood-moon 2 1))
  (testing "Testing for 3" (do-test-blood-moon 3 2.25)))

(defn tester-sum-of-powers-of-2 [n exp]
  (testing (str "Testing for " n)
    (is (= (powers n) exp))))

(deftest example-tests-sum-of-powers-of-2
  (tester-sum-of-powers-of-2 1 [1])
  (tester-sum-of-powers-of-2 2 [2])
  (tester-sum-of-powers-of-2 6 [2 4]))

(deftest sample-tests
  (are [inp exp] (= exp (sorted-and-how inp))
                 [1 2] "yes, ascending"
                 [15 7 3 -8] "yes, descending"
                 [4 2 30] "no"))

(deftest sample-tests
  (are [inp exp] (= (reverser inp) exp)
                 "How now brown cow" "woH won nworb woc"
                 "racecar." ".racecar"
                 "Hi mom!" "iH !mom"
                 " go away " " og yawa "
                 "I like noodles" "I ekil seldoon"
                 "The red pen wrote on the wall" "ehT der nep etorw no eht llaw"
                 "Green trucks drive fast" "neerG skcurt evird tsaf"
                 "Pink trucks drive slow" "kniP skcurt evird wols"
                 "Be happy" "eB yppah"))

(deftest sample-tests
  (is (= (filter-homogenous [[1 5 4] [\a 3 5] [\b] [] [\1 2 3]])
         [[1 5 4] [\b]]))
  (is (= (filter-homogenous [[123 234 432] ["" "abc"] [""] ["" 1] ["" "1"] []])
         [[123 234 432] ["" "abc"] [""] ["" "1"]]))
  (is (= (filter-homogenous [() [] ["a"] ["b"] ["c"]])
         [["a"] ["b"] ["c"]]))
  (is (= (filter-homogenous (list [] [1 2 3] ["z" \z] ["z"])) (list [1 2 3] ["z"])))
  (is (= (filter-homogenous [[{}] [#{} #{}]]) [[{}] [#{} #{}]])))

(deftest decode-example-test
  (is (= (decode-pass '["password123" "admin" "admin1"] "01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011") "password123"))
  (is (=(decode-pass '["password" "admin" "admin1"] "01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011") false))
  (is (=(decode-pass '["password" "pass" "test"] "01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011") false)))

(deftest basic-tests-men-from-boys
  (do-test men-from-boys [7 3 14 17] [14 17 7 3])
  (do-test men-from-boys [2 43 95 90 37] [2 90 95 43 37])
  (do-test men-from-boys [20 33 50 34 43 46] [20 34 46 50 43 33])
  (do-test men-from-boys [82 91 72 76 76 100 85] [72 76 82 100 91 85])
  (do-test men-from-boys [2 15 17 15 2 10 10 17 1 1] [2 10 17 15 1])
  (do-test men-from-boys [-32 -39 -35 -41] [-32 -35 -39 -41])
  (do-test men-from-boys [-64 -71 -63 -66 -65] [-66 -64 -63 -65 -71])
  (do-test men-from-boys [-94 -99 -100 -99 -96 -99] [-100 -96 -94 -99])
  (do-test men-from-boys [-53 -26 -53 -27 -49 -51 -14] [-26 -14 -27 -49 -51 -53])
  (do-test men-from-boys [-17 -45 -15 -33 -85 -56 -86 -30] [-86 -56 -30 -15 -17 -33 -45 -85])
  (do-test men-from-boys [12 89 -38 -78] [-78 -38 12 89])
  (do-test men-from-boys [2 -43 95 -90 37] [-90 2 95 37 -43])
  (do-test men-from-boys [82 -61 -87 -12 21 1] [-12 82 21 1 -61 -87])
  (do-test men-from-boys [63 -57 76 -85 88 2 -28] [-28 2 76 88 63 -57 -85])
  (do-test men-from-boys [49 818 -282 900 928 281 -282 -1] [-282 818 900 928 281 49 -1]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest test-vowel-indices
  (testing "vowel-indices"
    (test-assert(vowel-indices "super"), [2,4])))

(deftest zero-test
  (is (= (->> (range 1 101) shuffle missing-no) 0)))

(deftest twelve-test
  (is (= (->> (range 101) (remove (partial = 12)) shuffle missing-no) 12)))

(deftest covfefe-tests
  (is (= (covfefe "coverage") "covfefe"))
  (is (= (covfefe "I have coverage of them") "I have covfefe of them"))
  (is (= (covfefe "I dont know") "I dont know covfefe")))

(deftest accum-tests
  (testing "Accum, Basic tests"
    (is (= (accum "ZpglnRxqenU"), "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu"))
    (is (= (accum "NyffsGeyylB"), "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb"))
    (is (= (accum "MjtkuBovqrU"), "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu"))
    (is (= (accum "EvidjUnokmM"), "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm"))
    (is (= (accum "HbideVbxncC"), "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc"))))

(deftest number-pairs-tests
  (is (vector? (get-larger-numbers [] [])))
  (are [xs ys res] (= (get-larger-numbers xs ys) res)
                   [13 64 15 17 88] [23 14 53 17 80] [23 64 53 17 88]
                   [34 -64 15 17 88] [23 14 53 17 80] [34 14 53 17 88]))

(deftest first-class-function-factory-tests
  (let [xs [1 2 3]]
    (are [x expected] (= expected ((factory x) xs))
                      3 [3 6 9]
                      5 [5 10 15])))

(deftest a-test1
  (testing "find-even-index"
    (println "Fixed Tests validate-word")
    (do-test validate-word "abcabc", true)
    (do-test validate-word "abc123", true)
    (do-test validate-word "abcabcd", false)
    (do-test validate-word "abc!abc!", true)
    (do-test validate-word "abc!abc", false)))

(deftest vowel-test
  (testing "Basic Tests"
    (do-test vowel "" false)
    (do-test vowel "a" true)
    (do-test vowel "E" true)
    (do-test vowel "ou" false)
    (do-test vowel "z" false)
    (do-test vowel "lol" false)))

(deftest test-last-function
  (let [input1 [1 9 13 1 99 9 9 13]]
    (testing (str "Testing: " (prn-str input1))
      (are [x y] (= x y)
                 (element-at input1 1) 1
                 (element-at input1 2) 9
                 (element-at input1 3) 13
                 (element-at input1 4) 1
                 (element-at input1 5) 99))))

(deftest KISS-sample-tests
  (testing "word count: 5"
    (is (= (kiss? "Joe had a bad day") "Good work Joe!"))
    (is (= (kiss? "Joe had some bad days") "Good work Joe!"))
    (is (= (kiss? "Joe is having no fun") "Keep It Simple Stupid"))
    (is (= (kiss? "Sometimes Joe cries for hours") "Keep It Simple Stupid")))
  (testing "word count: 6"
    (is (= (kiss? "Joe is having lots of fun") "Good work Joe!"))
    (is (= (kiss? "Joe is working hard a lot") "Keep It Simple Stupid")))
  (testing "word count: 10"
    (is (= (kiss? "Joe listened to the noise and it was an onamonapia") "Good work Joe!"))
    (is (= (kiss? "Joe listened to the noises and there were some onamonapias") "Keep It Simple Stupid"))))

(deftest test-last-function
  (are [x y] (= x y)
             (seqlist 0 1 20) [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]))

(deftest examples
  (is (= (spread-cw + [1 2 3 4 5]) 15), "Spread isn't working!"))

(deftest ean-validation-tests
  (are [code answer] (= (validate-ean code) answer)
                     "9783815820865" true
                     "9783815820864" false
                     "9783827317100" true))

(defn tester-get-section [y s exp]
  (testing (str "(get-section-id " y " " s ")")
    (is (= (get-section-id y s) exp))))

(deftest basic-tests-get-section
  (tester-get-section 1 [300 200 400 600 100] 0)
  (tester-get-section 299 [300 200 400 600 100] 0)
  (tester-get-section 300 [300 200 400 600 100] 1)
  (tester-get-section 1599 [300 200 400 600 100] 4)
  (tester-get-section 1600 [300 200 400 600 100] -1))

(deftest circle-of-numbers-tests
  (is (= (circle-of-numbers 10 2) 7))
  (is (= (circle-of-numbers 10 7) 2))
  (is (= (circle-of-numbers 4 1) 3))
  (is (= (circle-of-numbers 6 3) 0)))

(defn tester-invite-more-women [l e]
  (testing (str "Testing for " l)
    (is (= (invite-more-women l) e))))

(deftest basic-tests-invite-more-women
  (tester-invite-more-women [1 -1 1] true)
  (tester-invite-more-women [-1 -1 -1] false)
  (tester-invite-more-women [1 -1] false)
  (tester-invite-more-women [1 1 1] true))

(deftest largest-power-tests
  (testing "Small cases"
    (is (= (largest-power 2) 0))
    (is (= (largest-power 3) 0))
    (is (= (largest-power 4) 1))
    (is (= (largest-power 5) 1))
    (is (= (largest-power 7) 1)))
  (testing "Large cases"
    (is (= (largest-power 81) 3))
    (is (= (largest-power 82) 4))
    (is (= (largest-power 59049) 9))
    (is (= (largest-power 59050) 10))
    (is (= (largest-power 123456789) 16))
    (is (= (largest-power 987654321) 18)))
  (testing "Edge case"
    (is (= (largest-power 1) -1))))

(deftest distances-from-average-tests
  (testing "distances-from-average"
    (do-test distances-from-average [55, 95, 62, 36, 48] [4.2, -35.8, -2.8, 23.2, 11.2])
    (do-test distances-from-average [1, 1, 1, 1, 1] [0.0, 0.0, 0.0, 0.0, 0.0])
    (do-test distances-from-average [1, -1, 1, -1, 1, -1] [-1.0, 1.0, -1.0, 1.0, -1.0, 1.0])
    (do-test distances-from-average [1, -1, 1, -1, 1] [-0.8, 1.2, -0.8, 1.2, -0.8])
    (do-test distances-from-average [2, -2] [-2.0, 2.0])
    (do-test distances-from-average [123 -65 32432 -353 -534] [6197.6 6385.6 -26111.4 6673.6 6854.6])))

(deftest basic-tests
  (is (= (save [4 4 4 3 3] 12) 3))
  (is (= (save [4 4 4 3 3] 11) 2))
  (is (= (save [4 8 15 16 23 42] 108) 6))
  (is (= (save [13] 13) 1))
  (is (= (save [1 2 3 4] 250) 4))
  (is (= (save [100] 500) 1))
  (is (= (save [11 13 15 17 19] 8) 0))
  (is (= (save [45] 12) 0)))

(deftest head-tail-init-last-tests
  (is (= (head [5 1]) 5))
  (is (= (tail [1]) []))
  (is (= (init [1 5 7 9]) [1 5 7]))
  (is (= (last_ [7 2]) 2)))

(deftest test-reverse-function
  (let [input1 [1 9 13 1 99 9 9 13]
        input2 (repeatedly (+ 5 (rand-int 10)) #(rand-int 100))
        input3 "\"There are only two kinds of languages: the ones people complain about and the ones nobody uses\" - Bjarne Stroustrup"]

    (testing (str input1)
      (is (= (reverse input1) (reverse input1))))

    (testing (str input2)
      (is (= (reverse input2) (reverse input2))))

    (testing (str "String: " (prn-str input3))
      (is (= (reverse input3) (reverse input3))))

    (testing "[]"
      (is (= (esrever []) [])))

    (testing "[1]"
      (is (= (esrever [1]) [1])))))

(deftest easy-line-tests
  (testing "Basic test easy-line"
    (do-test easy-line 7 3432N)
    (do-test easy-line 13 10400600N)
    (do-test easy-line 17 2333606220N)
    (do-test easy-line 19 35345263800N)))

(deftest a-test1
  (testing "nb-dig"
    (test-assert(nb-dig 5750, 0), 4700)
    (test-assert(nb-dig 11011, 2), 9481)
    (test-assert(nb-dig 12224, 8), 7733)
    (test-assert(nb-dig 11549, 1), 11905)))

(deftest alphabetical-addition-tests
  (testing "Testing for [\\a \\b \\c]" (is (= (add-letters [\a \b \c]) \f)))
  (testing "Testing for [\\z]" (is (= (add-letters [\z]) \z)))
  (testing "Testing for [\\a \\b]" (is (= (add-letters [\a \b]) \c)))
  (testing "Testing for [\\c]" (is (= (add-letters [\c]) \c)))
  (testing "Testing for [\\z \\a]" (is (= (add-letters [\z \a]) \a)))
  (testing "Testing for [\\y \\c \\b]" (is (= (add-letters [\y \c \b]) \d)))
  (testing "Testing for []" (is (= (add-letters []) \z))))

(deftest oper-vert-mirror-tests
  (testing "vert-mirror"
    (is (= (oper vert-mirror "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"),
           "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw")))
  (testing "hor-mirror"
    (is (= (oper hor-mirror "lVHt\nJVhv\nCSbg\nyeCt"),
           "yeCt\nCSbg\nJVhv\nlVHt"))))

(deftest printer-error-tests
  (testing "printer-error"
    (is (= (printer-error "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz") "3/56"))))

(deftest growing-plant-tests
  (is (= (growing-plant 100 10 910) 10))
  (is (= (growing-plant 10 9 4) 1))
  (is (= (growing-plant 5 2 5) 1))
  (is (= (growing-plant 5 2 6) 2)))

(deftest sum-of-odd-numbers-tests
  (is (= 1 (row-sum-odd-numbers 1)))
  (is (= 125 (row-sum-odd-numbers 5)))
  (is (= 343 (row-sum-odd-numbers 7))))

(deftest sum-first-nth-terms-of-series-tests
  (testing "Test 1"
    (is (= (series-sum 9) "1.77")))
  (testing "Test 2"
    (is (= (series-sum 0) "0.00")))
  (testing "Test 3"
    (is (= (series-sum 15) "1.94"))))

(deftest basic-tests
  (is (= (max-multiple 2 7) 6))
  (is (= (max-multiple 3 10) 9))
  (is (= (max-multiple 7 17) 14))
  (is (= (max-multiple 10 50) 50))
  (is (= (max-multiple 37 200) 185))
  (is (= (max-multiple 7 100) 98)))

(deftest letter?-tests
  (testing "letter"
    (doseq [s ["a" "X"]]
      (testing (prn-str s)
        (is (true? (letter? s))))))
  (testing "non-letter"
    (doseq [s ["" "7" "*" "ab" "a\n"]]
      (testing (prn-str s)
        (is (false? (letter? s)))))))

(deftest persistent-bugger-tests
  (testing "Initial Tests"
    (is (= (persistence 39) 3))
    (is (= (persistence 4) 0))
    (is (= (persistence 25) 2))
    (is (= (persistence 999) 4))))

(deftest testing-1-2-3-tests
  (do-test number [] [])
  (do-test number ["a" "b" "c"] ["1: a" "2: b" "3: c"])
  (do-test number ["" "" "" "" ""] ["1: " "2: " "3: " "4: " "5: "]))

(deftest complementary-dna-tests
  (do-test dna-strand "ATCG" "TAGC"))

(deftest get-the-middle-chracter-tests
  (testing "get-middle"
    (do-test get-middle "test", "es")
    (do-test get-middle "testing", "t")
    (do-test get-middle "middle", "dd")
    (do-test get-middle "A", "A")))

(deftest descending-order-tests
  (are [n expected]
    (= expected (desc-order n))
    0          0
    1          1
    15         51))

(deftest consecutive-letters-tests
  (is (= (consecutive-letters "abc") true))
  (is (= (consecutive-letters "dabc") true))
  (is (= (consecutive-letters "abd") false))
  (is (= (consecutive-letters "v") true))
  (is (= (consecutive-letters "abbc") false)))

(deftest indexed-capitalization-tests
  (is (= (capitalize "abcdef" [1 2 5]) "aBCdeF"))
  (is (= (capitalize "abcdef" [1 2 5 100]) "aBCdeF"))
  (is (= (capitalize "codewars" [1 3 5 50]) "cOdEwArs"))
  (is (= (capitalize "abracadabra" [2 6 9 10]) "abRacaDabRA"))
  (is (= (capitalize "indexinglessons" [0]) "Indexinglessons")))

(deftest unlucky-days-tests
  (is (= (unlucky-days 2015) 3))
  (is (= (unlucky-days 1986) 1)))