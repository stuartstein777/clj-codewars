(ns clj-codewars.6kyu-test
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu :refer :all]))

; Sample function:
(defn id [n] (do n))

(deftest composition-example-test
  (is (= ((compose (partial + 1) id) 0) 1)))

(defn do-test [fn s expect]
  (let [actual (fn s)]
    (is (= actual expect))))

(deftest meeting-tests
  (testing "meeting"
    (do-test meeting
             "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"
             "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)")
    (do-test meeting
             "John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell"
             "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)")))

(deftest array-diff-tests
  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1,2,2,2,3] [2]) [1,3])))

(deftest twosum-example-tests
  (is (= (sort < (twosum '[1 2 3] 4)) '[0 2]))
  (is (= (sort < (twosum '[1234 5678 9012] 14690)) '[1 2]))
  (is (= (sort < (twosum '[2 2 3] 4)) '[0 1])))

(deftest a-test1-disguised-sequence
  (testing "fcn"
    (do-test fcn 17 131072)
    (do-test fcn 21 2097152)
    (do-test fcn 14 16384)
    (do-test fcn 43 8796093022208)
    (do-test fcn 19 524288)))

(deftest example-tests-find-the-odd-int
  (are [xs answer] (= (find-odd xs) answer)
                   [20 1 -1 2 -2 3 3 5 5 1 2 4 20 4 -1 -2 5] 5
                   [1 1 2 -2 5 2 4 4 -1 -2 5] -1
                   [20 1 1 2 2 3 3 5 5 4 20 4 5] 5
                   [10] 10
                   [1 1 1 1 1 1 10 1 1 1 1] 10
                   [5 4 3 2 1 5 4 3 2 10 10] 1))

(deftest example-tests-parse-html
  (is (= (parse-html-color "#80FFA0")   {:r 128 :g 255 :b 160}))
  (is (= (parse-html-color "#3B7")      {:r 51  :g 187 :b 119}))
  (is (= (parse-html-color "LimeGreen") {:r 50  :g 205 :b 50})))

(defn do-test-histogram [s expect]
  (let [actual (hist s)]
    (is (= actual expect))))

(deftest a-test1-histogram
  (testing "hist"
    (do-test-histogram "uuaaaxbbbbyyhwawiwjjjwwxymzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
             "u  2     **\rw  5     *****\rx  2     **\rz  31    *******************************")
    (do-test-histogram "tpwaemuqxdmwqbqrjbeosjnejqorxdozsxnrgpgqkeihqwybzyymqeazfkyiucesxwutgszbenzvgxibxrlvmzihcb"
             "u  3     ***\rw  4     ****\rx  6     ******\rz  6     ******")
    (do-test-histogram "aaifzlnderpeurcuqjqeywdq" "u  2     **\rw  1     *\rz  1     *");
    (do-test-histogram "sjeneccyhrcpfvpujfaoaykqllteovskclebmzjeqepilxygdmzvdfmxbqdzubkzturnuqxsewrwgmdfwgdx"
             "u  4     ****\rw  3     ***\rx  4     ****\rz  4     ****")
    (do-test-histogram "kwlrizwobqwbtlfwwbnt" "w  5     *****\rz  1     *")))

(deftest a-test1-are-they-the-same
  (testing "Test 1"
    (def ur [121, 144, 19, 161, 19, 144, 19, 11])
    (def vr [121, 14641, 20736, 361, 25921, 361, 20736, 361])
    (is (= (compSame ur vr) true))))

(deftest a-test1-playing-on-a-chessboard
  (testing "test1"
    (is (= (game 0) [0]))))

(deftest a-test2-playing-on-a-chessboard
  (testing "test2"
    (is (= (game 1) [1, 2]))))

(deftest a-test3-playing-on-a-chessboard
  (testing "test3"
    (is (= (game 8) [32]))))

(deftest binaries-coding
  (testing "fixed test code"
    (do-test code "62" "0011100110")
    (do-test code "55337700" "001101001101011101110011110011111010")
    (do-test code "1119441933000055" "1111110001100100110000110011000110010111011110101010001101001101")
    (do-test code "69" "00111000011001")
    (do-test code "86" "00011000001110")))

(deftest binaries-decoding
  (testing "fixed tests decode"
    (do-test decode "10001111" "07")
    (do-test decode "001100001100001100001110001110001110011101110111001110001110001110001111001111001111001100001100001100" "444666333666777444")
    (do-test decode "01110111110001100100011000000110000011110011110111011100110000110001100110" "33198877334422")
    (do-test decode "0011010011010011011010101111110011000011000011000011100011100011100011100011100011100001100100011001000110011100011001001111001111001111001111001111001111" "55500011144466666699919777777")
    (do-test decode "01110111011111000110010011110011110011110011110011110011110111011101110110011001100110011001101111111010101100011001000110000001100000011000" "3331977777733322222211100019888")))

(deftest help-the-bookseller-test
  (testing "Test 1"
    (def ur ["BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"])
    (def vr ["A" "B" "C" "D"])
    (def res [["A" 0] ["B" 1290] ["C" 515] ["D" 600]])
    (is (= (stock-list ur vr) res))))

(deftest sample-test-cases
  (testing "with non-letter characters"
    do-test wave "a       b    " ["A       b    " "a       B    "])
  (testing "with multiple words"
    (do-test wave "this is a few words"
      ["This is a few words" "tHis is a few words" "thIs is a few words" "thiS is a few words" "this Is a few words" "this iS a few words" "this is A few words" "this is a Few words" "this is a fEw words" "this is a feW words" "this is a few Words" "this is a few wOrds" "this is a few woRds" "this is a few worDs" "this is a few wordS"]))
  (testing "with an empty string"
    (do-test wave "" []))
  (testing "with whitespace around the string"
    (do-test wave " gap " [" Gap " " gAp " " gaP "])))

(deftest one-word-test
  (is (= (spin-words "Welcome") "emocleW")))

(deftest digital-root-example-test
  (is (= (digital-root 16) 7))
  (is (= (digital-root 456) 6)))

(defn test-assert-moves-in-squared-strings-2 [act exp]
  (is (= act exp)))

(deftest -moves-in-squared-strings-2-tests
  (testing "rot"
    (test-assert-moves-in-squared-strings-2
      (oper rot "rkKv\ncofM\nzXkh\nflCB"), "BClf\nhkXz\nMfoc\nvKkr")
    (test-assert-moves-in-squared-strings-2
      (oper rot  "fijuoo\nCqYVct\nDrPmMJ\nerfpBA\nkWjFUG\nCVUfyL"), "LyfUVC\nGUFjWk\nABpfre\nJMmPrD\ntcVYqC\nooujif"))
  (testing "selfie-and-rot"
    (test-assert-moves-in-squared-strings-2
      (oper selfie-and-rot "xZBV\njsbS\nJcpN\nfVnP"),
                           "xZBV....\njsbS....\nJcpN....\nfVnP....\n....PnVf\n....NpcJ\n....Sbsj\n....VBZx")
    (test-assert-moves-in-squared-strings-2
      (oper selfie-and-rot "uLcq\nJkuL\nYirX\nnwMB"),
                           "uLcq....\nJkuL....\nYirX....\nnwMB....\n....BMwn\n....XriY\n....LukJ\n....qcLu")))

(deftest sum-dig-pow-tests
  (println "Basic Tests sum-dig-pow")
  (= (sum-dig-pow 1 10) [1, 2, 3, 4, 5, 6, 7, 8, 9])
  (= (sum-dig-pow 1 100) [1, 2, 3, 4, 5, 6, 7, 8, 9, 89])
  (= (sum-dig-pow 10 100) [89])
  (= (sum-dig-pow 90 100) [])
  (= (sum-dig-pow 90 150) [135])
  (= (sum-dig-pow 50 150) [89, 135])
  (= (sum-dig-pow 10 150) [89, 135]))

(deftest sum-of-parts-tests
  (testing "parts-sums"
    (is (= (parts-sums '()) '(0)))
    (is (= (parts-sums '(0 1 3 6 10)) '(20 20 19 16 10 0)))
    (is (= (parts-sums '(1 2 3 4 5 6)) '(21 20 18 15 11 6 0)))
    (is (= (parts-sums '(744125 935 407 454 430 90 144 6710213 889 810 2579358))
           '(10037855 9293730 9292795 9292388 9291934 9291504 9291414 9291270 2581057 2580168 2579358 0)))))

(deftest playing-with-digits-tests
  (testing "Test1"
    (is (= (dig-pow 89 1) 1)))
  (testing "Test2"
    (is (= (dig-pow 92 1) -1))))

(deftest a-test1
  (testing "find-even-index"
    (println "Fixed Tests find-even-index")
    (is (= (find-even-index [1, 2, 3, 4, 3, 2, 1]), 3))
    (is (= (find-even-index [1, 100, 50, -51, 1, 1]), 1))
    (is (= (find-even-index [1, 2, 3, 4, 5, 6]), -1))
    (is (= (find-even-index [20, 10, 30, 10, 10, 15, 35]), 3))))

(defn- dotest1-pov [a b]
  (let [actual1 (point a b)
        actual2 (fst (point a b))
        actual3 (snd (point a b))
        ]
    (is (= (fn? actual1) true))
    (is (= actual2 a))
    (is (= actual3 b))
    ))

(defn- dotest2-pov [a1 b1 a2 b2 expect]
  (let [actual (sqr-dist (point a1 b1) (point a2 b2))]
    (is (= actual expect))
    ))
(defn- dotest3-pov [a1 b1 a2 b2 expect]
  (defn- detAC [a b c d]
    (- (* a d) (* b c)))
  (defn- line-equalAC? [line1 line2]
    (let [[l1 m1 n1] line1
          [l2 m2 n2] line2
          ]
      (and (not= line1 '(0 0 0))
           (= 0 (detAC l1 m1 l2 m2))
           (= 0 (detAC m1 n1 m2 n2))
           (= 0 (detAC l1 n1 l2 n2)))))
  (let [actual (line (point a1 b1) (point a2 b2))]
    (is (= (line-equalAC? actual expect) true))))

(deftest a-test1-pov
  (testing "point"
    (dotest1-pov 3 5)
    (dotest1-pov  81 45)))

(deftest a-test2
  (testing "point sqr-dist"
    (dotest2-pov 22 55 75 66 2930)
    (dotest2-pov 11 22 65 44 3400)))

(deftest a-test3
  (testing "point tests line"
    (dotest3-pov 20 22 29 10 (list 12 9 -438))
    (dotest3-pov 38 32 14 8 (list 24 -24 -144))))

(deftest unique-in-order-tests
  (testing "do-nothing-vector"
    (is (= (unique-in-order [1 2 3]), [1 2 3]))
    (testing "do-nothing-string"
      (is (= (unique-in-order "ABC"), [\A \B \C])))
    (testing "do-nothing-list"
      (is (= (unique-in-order '(1 2 3)), [1 2 3])))
    (is (= (unique-in-order [0 0 0 0 1 1 1 2 2 0 0 1 1 1]) [0 1 2 0 1]))
    (is (= (unique-in-order "AAAABBBCCDAABBB") [\A \B \C \D \A \B]))))

(deftest create-phone-number-tests
  (do-test create-phone-number [1 2 3 4 5 6 7 8 9 0] "(123) 456-7890")
  (do-test create-phone-number [1 1 1 1 1 1 1 1 1 1] "(111) 111-1111")
  (do-test create-phone-number [4 7 8 1 5 7 9 9 7 1] "(478) 157-9971")
  (do-test create-phone-number [7 8 0 2 2 1 7 5 1 3] "(780) 221-7513"))

(deftest bit-counting-tests
  (testing "0"
    (is (= 0 (count-bits 0))))
  (testing "1"
    (is (= 1 (count-bits 1))))
  (testing "10"
    (is (= 2 (count-bits 10))))
  (testing "14"
    (is (= 3 (count-bits 14))))
  (testing "30"
    (is (= 4 (count-bits 30)))))

(deftest the-shell-game-tests
  (testing "An empty swap set doesn't move the ball"
    (is (= (find-the-ball 5 []) 5)))
  (testing "Some games"
    (is (= (find-the-ball 0 [[0 1] [2 1] [0 1]]) 2))))

(deftest count-the-smiley-face-tests
  (is (= (count-smileys [])  0))
  (is (= (count-smileys [":)"  ";("  ";}"  ":-D"])  2))
  (is (= (count-smileys [";]"  ":["  ";*"  ":$"  ";-D"])  1))
  (is (= (count-smileys [":)" ":(" ":D" ":O" ":;"])  2))
  (is (= (count-smileys [":-)" ";~D" ":-D" ":_D"])  3)))

(deftest pangram-tests
  (is (= (pangram? "The quick brown fox jumps over the lazy dog.") true))
  (is (= (pangram? "Pack my box with five dozen liquor jugs.") true))
  (is (= (pangram? "Not every sentence is a a pangram. An example") false)))

(deftest counting-duplicate-tests
  (testing "blank"
    (is (= 0 (duplicate-count ""))))
  (testing "abcde"
    (is (= 0 (duplicate-count "abcde"))))
  (testing "aabbcde"
    (is (= 2 (duplicate-count "aabbcde"))))
  (testing "ignore-case"
    (is (= 2 (duplicate-count "aabBcde"))))
  (testing "Indivisibility"
    (is (= 1 (duplicate-count "Indivisibility"))))
  (testing "non-adjacent"
    (is (= 2 (duplicate-count "Indivisibilities")))))

(deftest consecutive-string-tests
  (is (= "abigailtheta"
         (longest-cons ["zone", "abigail", "theta", "form", "libe", "zas"]  2)))
  (is (= "oocccffuucccjjjkkkjyyyeehh"
         (longest-cons ["ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"] 1)))
  (is (= "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
         (longest-cons ["itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"] 2)))
  (is (= "wlwsasphmxxowiaxujylentrklctozmymu"
         (longest-cons ["wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"] 2)))
  (is (= ""
         (longest-cons ["zone", "abigail", "theta", "form", "libe", "zas"] -2)))
  (is (= "ixoyx3452zzzzzzzzzzzz"
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 3)))
  (is (= ""
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 15)))
  (is (= ""
         (longest-cons ["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"] 0))))