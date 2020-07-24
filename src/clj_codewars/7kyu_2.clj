(ns clj-codewars.7kyu-2
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; Computer problem series #1: Fill the Hard Disk Drive
; Your task is to determine how many files of the copy queue you will be able to save into your Hard Disk Drive. The files must be saved in the order they appear in the queue.
; Input:
;    Array of file sizes (0 <= s <= 100)
;    Capacity of the HD (0 <= c <= 500)
;
; Output:
;    Number of files that can be fully saved in the HD.
;
; Examples:
;   save([4,4,4,3,3], 12) -> 3
;   # 4+4+4 <= 12, but 4+4+4+3 > 12
;
;   save([4,4,4,3,3], 11) -> 2
;   # 4+4 <= 11, but 4+4+4 > 11
;
; Do not expect any negative or invalid inputs.

(defn save [sizes hd]
  (count (filter #(<= % hd) (reductions + sizes))))
;; -------------------------------------------END---


;; Head, Tail, Init and Last
; Haskell has some useful functions for dealing with lists:
;     GHCi, version 7.6.3: http://www.haskell.org/ghc/  :? for help
;     λ head [1,2,3,4,5]
;     1
;     λ tail [1,2,3,4,5]
;     [2,3,4,5]
;     λ init [1,2,3,4,5]
;     [1,2,3,4]
;     λ last [1,2,3,4,5]
;     5
;
; Your job is to implement these functions in your given language. Make sure it doesn't edit the array; that would
; cause problems! Here's a cheat sheet:
;
;     | HEAD | <----------- TAIL ------------> |
;     [  1,  2,  3,  4,  5,  6,  7,  8,  9,  10]
;     | <----------- INIT ------------> | LAST |
;
;     head [x] = x
;     tail [x] = []
;     init [x] = []
;     last [x] = x
;
; Here's how I expect the functions to be called in your language:
;
; (head [1,2,3,4,5]) => 1
; (tail [1,2,3,4,5]) => [2,3,4,5]

(defn head [xs]
  (first xs))

(defn tail [xs]
  (rest xs))

(defn last_ [xs]
  (last xs))

(defn init [xs]
  (butlast xs))
;; -------------------------------------------END---

;; Binary sXORe
; Given a number n we will define it's sXORe to be 0 XOR 1 XOR 2 ... XOR n where XOR is the bitwise XOR operator.
;
; Write a function that takes n and returns it's sXORe.

(defn sxore [n]
  (if (= 0 n)
    0
    (let [r (rem (dec n) 4)]
      (cond (= r 0) 1
            (= r 1) (inc n)
            (= r 2) 0
            (= r 3) n))))
;; -------------------------------------------END---

;; esreveR
; Write a function reverse which reverses a list (or in clojure's case, any list-like data structure)
;
; (the dedicated builtin(s) functionalities are deactivated)

(defn esrever
  "Reverse a list"
  [lst]
  ((fn [lst r]
     (if (empty? lst)
       r
       (recur (rest lst) (cons (first lst) r)))) lst []))
;; -------------------------------------------END---

;; Easy Line
; We want to calculate the sum of the squares of the binomial coefficients on a given horizontal line in a pascals
; triangle with a function called easyline (or easyLine or easy-line).
;
; Can you write a program which calculate easyline(n) where n is the horizontal line number?
;
; The function will take n (with: n>= 0) as parameter and will return the sum of the squares of the binomial
; coefficients on line n.
;
;##Examples:
;
;     easyline(0) => 1
;     easyline(1) => 2
;     easyline(4) => 70
;     easyline(50) => 100891344545564193334812497256

(defn easy-line [n]
  (loop [last 1 num n den 1 row [1]]
    (if (= 0 num)
      (reduce #(+ % (* %2 %2)) row)
      (let [current (* last (/ num den))]
        (recur current (dec num) (inc den) (conj row current))))))
;; -------------------------------------------END---

;; Count the Digit
; Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer. Square all numbers k (0 <= k <= n) between 0
; and n. Count the numbers of digits d used in the writing of all the k**2. Call nb_dig (or nbDig or ...) the function
; taking n and d as parameters and returning this count.
;
; #Examples:
;
;     n = 10, d = 1, the k*k are 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
;We are using the digit 1 in 1, 16, 81, 100. The total count is then 4.
;
;     nb_dig(25, 1):
;the numbers of interest are
;     1, 4, 9, 10, 11, 12, 13, 14, 19, 21 which squared are 1, 16, 81, 100, 121, 144, 169, 196, 361, 441
;so there are 11 digits `1` for the squares of numbers between 0 and 25.
;
; Note that 121 has twice the digit 1.

(defn nb-dig [n d]
  (let [all-digits (->> (range 0 (inc n))
                        (map (partial #(* % %)))
                        (apply str))]
    (- (count all-digits)
       (count (str/replace all-digits (re-pattern (str d)) "")))))
;; -------------------------------------------END---

;; Alphabetical Addition
; Your task is to add up letters to one letter.
;
; The function will be given a vector of letters, each one being a letter (chars) to add. Return a char.
; Notes:
;
;    Letters will always be lowercase.
;    Letters can overflow (see second to last example of the description)
;    If no letters are given, the function should return 'z'
;
; Examples:
;
;     (add-letters [\a \b \c]) ;; \f
;     (add-letters [\z]) ;; \z
;     (add-letters [\a \b]) ;; \c
;     (add-letters [\c]) ;; \c
;     (add-letters [\z \a]) ;; \a
;     (add-letters [\y \c \b]) ;; \d ;; notice the letters overflowing
;     (add-letters []) ;; \z

(def alphabet {\a 1 \b 2 \c 3 \d 4 \e 5 \f 6 \g 7 \h 8 \i 9 \j 10 \k 11 \l 12 \m 13
               \n 14 \o 15 \p 16 \q 17 \r 18 \s 19 \t 20 \u 21 \v 22 \w 23 \x 24 \y 25 \z 26})

(defn add-letters [letters]
  (cond (empty? letters) \z
        :else (as-> (map #(alphabet %) letters) v
                    (reduce + 0 v)
                    (mod v 26)
                    (cond (= 0 v) \z
                          :else (char (+ 96 v))))))
;; -------------------------------------------END---

;; Moves in squared strings (I)
; This kata is the first of a sequence of four about "Squared Strings".
; You are given a string of n lines, each substring being n characters long: For example:
;       s = "abcd\nefgh\nijkl\nmnop"
; We will study some transformations of this square of strings.
; Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
;       vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
; Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
;       hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
; or printed
;       vertical mirror   |horizontal mirror
;       abcd --> dcba     |abcd --> mnop
;       efgh     hgfe     |efgh     ijkl
;       ijkl     lkji     |ijkl     efgh
;       mnop     ponm     |mnop     abcd
;
; Task:
; Write these two functions and high-order function oper(fct, s) where
;        fct is the function of one variable f to apply to the string s (fct will be one of vertMirror, horMirror)
;
; #Examples:
;
;       s = "abcd\nefgh\nijkl\nmnop"
;       oper(vert_mirror, s) => "dcba\nhgfe\nlkji\nponm"
;       oper(hor_mirror, s) => "mnop\nijkl\nefgh\nabcd"
;
;Note:
;
; The form of the parameter fct in oper changes according to the language. You can see each form according to the
; language in "Sample Tests".

(defn vert-mirror [s]
  (->> (str/split-lines s)
       (map (partial reverse))
       (map (partial apply str))
       (str/join "\n")))

(defn hor-mirror [s]
  (->> (str/split-lines s)
       (reverse)
       (str/join "\n")))

(defn oper [fct s]
  (fct s))
;; -------------------------------------------END---

;; Printer Errors
; In a factory a printer prints labels for boxes. For one kind of boxes the printer has to use colors which, for the
; sake of simplicity, are named with letters from a to m.
;
;The colors used by the printer are recorded in a control string. For example a "good" control string would be
; aaabbbbhaijjjm meaning that the printer used three times color a, four times color b, one time color h then one time color a...
;
;Sometimes there are problems: lack of colors, technical malfunction and a "bad" control string is produced e.g.
; aaaxbbbbyyhwawiwjjjwwm with letters not from a to m.
;
;You have to write a function printer_error which given a string will output the error rate of the printer as a string
; representing a rational whose numerator is the number of errors and the denominator the length of the control string.
; Don't reduce this fraction to a simpler expression.
;
;The string has a length greater or equal to one and contains only letters from ato z
;
; #Examples:
;
;     s="aaabbbbhaijjjm"
;     error_printer(s) => "0/14"
;
;     s="aaaxbbbbyyhwawiwjjjwwm"
;     error_printer(s) => "8/22"

(defn printer-error [s]
  (str (count (filter #{\n \o \p \q \r \s \t \u \v \w \x \y \z} s))
       "/"
       (count s)))
;; -------------------------------------------END---

;; Simple Fun #74: Growing Plant
; Each day a plant is growing by upSpeed meters. Each night that plant's height decreases by downSpeed meters due to the
; lack of sun heat. Initially, plant is 0 meters tall. We plant the seed at the beginning of a day. We want to know when
; the height of the plant will reach a certain level.
; Example
;
; For upSpeed = 100, downSpeed = 10 and desiredHeight = 910, the output should be 10.
;
;       After day 1 --> 100
;       After night 1 --> 90
;       After day 2 --> 190
;       After night 2 --> 180
;       After day 3 --> 280
;       After night 3 --> 270
;       After day 4 --> 370
;       After night 4 --> 360
;       After day 5 --> 460
;       After night 5 --> 450
;       After day 6 --> 550
;       After night 6 --> 540
;       After day 7 --> 640
;       After night 7 --> 630
;       After day 8 --> 730
;       After night 8 --> 720
;       After day 9 --> 820
;       After night 9 --> 810
;       After day 10 --> 910
;
; For upSpeed = 10, downSpeed = 9 and desiredHeight = 4, the output should be 1.
; Because the plant reach to the desired height at day 1(10 meters).

(defn growing-plant [up-speed down-speed desired-height]
  ((fn [day-count current-height]
     (if (>= (+ current-height up-speed) desired-height)
       day-count
       (recur (inc day-count) (- (+ current-height up-speed) down-speed)))) 1 0))
;; -------------------------------------------END---

;; Sum of odd numbers
; Given the triangle of consecutive odd numbers:
;
;             1
;          3     5
;       7     9    11
;   13    15    17    19
;21    23    25    27    29
;...
;
; Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
;
;     (row-sum-odd-numbers 1) # 1
;     (row-sum-odd-numbers 2) # 3 + 5 = 8

(defn row-sum-odd-numbers [x]
  (let [last (+ (* x x) (- x 1))
        start (- last (* 2 (dec x)))]
    (* (/ (+ start last) 2) x)))
;; -------------------------------------------END---

;; Sum of the first nth term of Series
; Your task is to write a function which returns the sum of following series upto nth term(parameter).
; Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
; Rules:
;    You need to round the answer to 2 decimal places and return it as String.
;    If the given value is 0 then it should return 0.00
;    You will only be given Natural Numbers as arguments.
;
; Examples:
;
; SeriesSum(1) => 1 = "1.00"
; SeriesSum(2) => 1 + 1/4 = "1.25"
; SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"

(defn series-sum [n]
  (loop [total 0
         c 1
         d 1]
    (if (> c n)
      (format "%.2f"(double total))
      (recur (+ total (/ 1.0 d)) (inc c) (+ 3 d)))))
;; -------------------------------------------END---

;; Maximum multiple
; Given a Divisor and a Bound , Find the largest integer N , Such That ,
; Conditions :
;    N is divisible by divisor
;    N is less than or equal to bound
;    N is greater than 0.
; Notes
;   The parameters (divisor, bound) passed to the function are only positive values
;   It's guaranteed that a divisor is Found
;
; Input >> Output Examples
;
;     maxMultiple (2,7) ==> return (6)
;
; (6) is divisible by (2) , (6) is less than or equal to bound (7) , and (6) is > 0 .
;
;     maxMultiple (10,50)  ==> return (50)
;
; (50) is divisible by (10) , (50) is less than or equal to bound (50) , and (50) is > 0 .*
;
;     maxMultiple (37,200) ==> return (185)
; (185) is divisible by (37) , (185) is less than or equal to bound (200) , and (185) is > 0 .

(defn max-multiple [d b]
  (apply max (filter #(= 0 (rem % d)) (range 1 (inc b)))))
;; -------------------------------------------END---

;; Regexp Basics - is it a letter?
; Complete the code which should return true if the given object is a single ASCII letter (lower or upper case), false
; otherwise.

(defn letter? [s]
  (not= nil (re-matches #"[A-Za-z]" s)))
;; -------------------------------------------END---

;; Persistent Bugger.
; Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
; which is the number of times you must multiply the digits in num until you reach a single digit.
;
;For example:
;
; (persistence 39) ; returns 3, because 3*9=27, 2*7=14, 1*4=4
;                  ; and 4 has only one digit
;
; (persistence 999) ; returns 4, because 9*9*9=729, 7*2*9=126,
;                   ; 1*2*6=12, and finally 1*2=2
;
; (persistence 4) ; returns 0, because 4 is already a one-digit number

(defn persistence
  ([n]
   (if (< n 10)
     0
     (persistence n 1)))
  ([n cnt]
   (let [v (reduce * (->> n str (map (comp read-string str))))]
     (if (< v 10)
       cnt
       (recur v (inc cnt))))))
;; -------------------------------------------END---

;; Testing 1-2-3
; Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
; Write a function which takes a list of strings and returns each line prepended by the correct number.
; The numbering starts at 1. The format is n: string. Notice the colon and space in between.
;
;Examples:
;
;    number(List<string>()) // => List<string>()
;    number(List<string>{"a", "b", "c"}) // => ["1: a", "2: b", "3: c"]

(defn number [lines]
  (loop [numbered []
         to-number lines
         current-line 1]
    (if (empty? to-number)
      numbered
      (recur (conj numbered (str current-line ": " (first to-number))) (rest to-number) (inc current-line)))))
;; -------------------------------------------END---

;; Complementary DNA
; Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.
; If you want to know more http://en.wikipedia.org/wiki/DNA
; In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).
;     (is (= (dna-strand "ATTGC") "TAACG"))
;     (is (= (dna-strand "GTAT") "CATA"))

(defn dna-strand [dna]
  (as-> (str/replace dna "A" "t") v
        (str/replace v "T" "a")
        (str/replace v "C" "g")
        (str/replace v "G" "c")
        (str/upper-case v)))
;; -------------------------------------------END---

;; Get the Middle Character
; ou are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd,
; return the middle character. If the word's length is even, return the middle 2 characters.
;
; Examples:
;     Kata.getMiddle("test") should return "es"
;     Kata.getMiddle("testing") should return "t"
;     Kata.getMiddle("middle") should return "dd"
;     Kata.getMiddle("A") should return "A"
;
; Input
; A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases due
; to an error in the test cases). You do not need to test for this. This is only here to tell you that you do not need
; to worry about your solution timing out.
;
; Output
; The middle character(s) of the word represented as a string.

(defn get-middle [word]
  (let [middle-index (Math/floor (/ (count word) 2))]
    (if (even? (count word))
      (str (nth word (dec middle-index)) (nth word middle-index))
      (str (nth word middle-index)))))
;; -------------------------------------------END---

;; Descending Order
;
; Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in
; descending order. Essentially, rearrange the digits to create the highest possible number.
;
; Examples:
;
; Input: 21445 Output: 54421
;
; Input: 145263 Output: 654321
;
; Input: 123456789 Output: 987654321

(defn desc-order [n]
  (Integer/parseInt (apply str (reverse (sort (map identity (str n)))))))
;; -------------------------------------------END---

;; Consecutive Letters
; In this Kata, we will check if a string contains consecutive letters as they appear in the English alphabet and if each letter occurs only once.
;
; Rules are: (1) the letters are adjacent in the English alphabet, and (2) each letter occurs only once.
;
; For example:
; solve("abc") = True, because it contains a,b,c
; solve("abd") = False, because a, b, d are not consecutive/adjacent in the alphabet, and c is missing.
; solve("dabc") = True, because it contains a, b, c, d
; solve("abbc") = False, because b does not occur once.
; solve("v") = True
;
; All inputs will be lowercase letters.

(defn consecutive-letters[s]
  (let [sorted (->> (sort s)
                    (map int))]
    (= (range (first sorted) (inc (last sorted))) sorted)))
;; -------------------------------------------END---

;; Longest Vowel Chain
; The vowel substrings in the word codewarriors are o,e,a,io. The longest of these has a length of 2. Given a
; lowercase string that has alphabetic characters only (both vowels and consonants) and no spaces, return the length of
; the longest vowel substring. Vowels are any of aeiou.

(defn is-vowel [c]
  (not (nil? (#{\a \e \i \o \u} c))))

(defn solve [s]
  (->> (partition-by is-vowel s)
       (filter #(true? (is-vowel (first %))))
       (map count)
       (apply max)))
;; -------------------------------------------END---

;; String prefix and suffix
; In this Kata, you will be given a string and your task will be to return the length of the longest prefix that is
; also a suffix. A prefix is the start of a string while the suffix is the end of a string. For instance, the prefixes
; of the string "abcd" are ["a","ab","abc"]. The suffixes are ["bcd", "cd", "d"]. You should not overlap the prefix and
; suffix.
;
; for example:
; solve("abcd") = 0, because no prefix == suffix.
; solve("abcda") = 1, because the longest prefix which == suffix is "a".
; solve("abcdabc") = 3. Longest prefix which == suffix is "abc".
; solve("aaaa") = 2. Longest prefix which == suffix is "aa". You should not overlap the prefix and suffix
; solve("aa") = 1. You should not overlap the prefix and suffix.
; solve("a") = 0. You should not overlap the prefix and suffix.
; All strings will be lowercase and string lengths are 1 <= length <= 500

(defn solve [s]
  (let [post-range (range 0 (inc (quot (count s) 2)))
        suffix-range (range (quot (count s) 2) (count s))
        prefixes (set (map #(subs s 0 %) post-range))
        suffixes (set (map #(subs s %) suffix-range))
        intersections (set/intersection prefixes suffixes)]
    (cond (empty? intersections) 0
          :else (apply max (map count intersections)))))
;; -------------------------------------------END---

;; Indexed capitalization
;  Given a string and an array of integers representing indices, capitalize all letters at the given indices.
;
; For example:
;    capitalize("abcdef",[1,2,5]) = "aBCdeF"
;    capitalize("abcdef",[1,2,5,100]) = "aBCdeF". There is no index 100.
; The input will be a lowercase string with no spaces and an array of digits.

(defn capitalize [s idx]
  (let [idxs (set idx)]
    (apply str (map-indexed (fn [ix i]
                              (if (idxs ix)
                                (str/upper-case (str i))
                                i)) s))))
;; -------------------------------------------END---