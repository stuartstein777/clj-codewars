(ns clj-codewars.6kyu
  (:require [clojure.string :as str]))

;;Function Composition
; Function composition is a mathematical operation that mainly presents itself in lambda calculus and computability.
; It is explained well here, but this is my explanation, in simple mathematical notation:
; f3 = compose ( f1 f2 )
;   is equivalent to
; f3(a) = f1 ( f2 ( a) )
; Your task is to create a compose function to carry out this task, which will be passed two functions or lambdas.
; Ruby functions will be passed, and should return, either a proc or a lambda. Remember that the resulting composed
; function may be passed multiple arguments!
; ((compose f  g) x)
;  => (f (g x) )

(defn compose [f g]
  (comp f g))
;; -------------------------------------------END---

;; Meeting
; John has invited some friends. His list is:
;
; s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
;
; Could you make a program that
;
;    makes this string uppercase
;    gives it sorted in alphabetical order by last name.
;
; When the last names are the same, sort them by first name. Last name and first name of a guest come in the result
; between parentheses separated by a comma.
;
; So the result of function meeting(s) will be:
;
; "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)
;  (TORNBULL, BJON)"
;
; It can happen that in two distinct families with the same family name two people have the same first name too.

(defn meeting [s]
  (as-> (str/upper-case s) o
        (str/split o #";")
        (map #(str/split % #":") o)
        (sort-by (juxt second first) o)
        (map #(list (second %) (first %)) o)
        (map #(str "(" (first %) ", " (second %) ")") o)
        (str/join "" o)))
;; -------------------------------------------END---

;; Array.diff
; Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the
; result.
; It should remove all values from list a, which are present in list b.
;   (= (array-diff [1 2] [1]) [2])
; If a value is present in b, all of its occurrences must be removed from the other:
;   (= (array-diff [1,2,2,2,3] [2]) [1,3])

(defn array-diff [a b]
  ((fn [a b diff]
     (if (empty? a)
       diff
       (do (let [x (first a)]
             (if (= nil (some #{x} b))
               (recur (rest a) b (conj diff x))
               (recur (rest a) b diff)))))) a b []))
;; -------------------------------------------END---

;; Two Sum
; Write a function that takes an array of numbers (integers for the tests) and a target number. It should find two
; different items in the array that, when added together, give the target value. The indices of these items should then
; be returned in a tuple like so: (index1, index2).
; For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
; The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers;
; target will always be the sum of two different items from that array).
;
; Based on: http://oj.leetcode.com/problems/two-sum/
;
;     twoSum [1, 2, 3] 4 === (0, 2)

(defn twosum [xs target]
  (->> (map-indexed (fn [ix x] (map-indexed (fn [iix o] [[ix (+ ix (inc iix))] (+ o x)]) (drop (inc ix) xs))) xs)
       (apply concat)
       (filter (fn [f] (= (second f) target)))
       (ffirst)))
;; -------------------------------------------END---

;; A disguised sequence (I)
; Given u0 = 1, u1 = 2 and the relation 6unun+1-5unun+2+un+1un+2 = 0 calculate un for any integer n >= 0. #Examples
;     fcn(n) returns un: fcn(17) -> 131072, fcn(21) -> 2097152
; Remark: You can take two points of view to do this kata:
; the first one purely algorithmic from the definition of un
; the second one - not at all mandatory, but as a complement - is to get a bit your head around and find which sequence
; is hidden behind un.

(defn int-pow [b ^long ex]
  (loop [acc 1 ex ex]
    (case ex
      0 acc
      (recur (* acc b) (dec ex)))))

(defn fcn [n]
  (int-pow 2N n))
;; -------------------------------------------END---

;; Find the odd int
; Given an array, find the integer that appears an odd number of times.
; There will always be only one integer that appears an odd number of times.

(defn find-odd [xs]
  (first (first (filter #(odd? (second %)) (frequencies xs)))))
;; -------------------------------------------END---

;; Parse HTML
; In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is
; to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).
; The input string represents one of the following:
;
;    6-digit hexadecimal - "#RRGGBB"
;    e.g. "#012345", "#789abc", "#FFA077"
;    Each pair of digits represents a value of the channel in hexadecimal: 00 to FF
;
;    3-digit hexadecimal - "#RGB"
;    e.g. "#012", "#aaa", "#F5A"
;    Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.
;
;    Preset color name
;    e.g. "red", "BLUE", "LimeGreen"
; You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell),
; or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the
; corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").
;
;Examples:
;
; (parse-html-color "#80FFA0")   ; => {:r 128 :g 255 :b 160}
; (parse-html-color "#3B7")      ; => {:r 51  :g 187 :b 119}
; (parse-html-color "LimeGreen") ; => {:r 50  :g 205 :b 50 }

(defn preset-colors [_]
  "#32CD32")

(defn parse-hex [h n]
  (let [b (->> (partition n h)
               (map (partial apply str)))]
    {:r (Integer/parseInt (first b) 16)
     :g (Integer/parseInt (second b) 16)
     :b (Integer/parseInt (last b) 16)}))

(defn parse-html-color [hex]
  (cond (and (str/starts-with? hex "#") (= 7 (count hex))) (parse-hex (rest hex) 2)
        (and (str/starts-with? hex "#") (= 4 (count hex))) (parse-hex (str (apply str (repeat 2 (second hex)))
                                                                           (apply str (repeat 2 (nth hex 2)))
                                                                           (apply str (repeat 2 (nth hex 3)))) 2)
        :else (parse-html-color (preset-colors (str/lower-case hex)))))
;; -------------------------------------------END---

;; Errors : histogram
; In a factory a printer prints labels for boxes. The printer uses colors which, for the sake of simplicity, are named
; with letters from a to z (except letters u, w, x or z that are for errors).
;
;The colors used by the printer are recorded in a control string. For example a control string would be aaabbbbhaijjjm
; meaning that the printer used three times color a, four times color b, one time color h then one time color a... and
; so on.
;
;Sometimes there are problems: lack of colors, technical malfunction and a control string is produced e.g.
; uuaaaxbbbbyyhwawiwjjjwwxym where errors are reported with letters u, w, x or z.
;
;You have to write a function hist which given a string will output the errors as a string representing a histogram of
; the encountered errors.
;
;Format of the output string:
;
;letter (error letters are sorted in alphabetical order) in a field of 2 characters, a white space, number of error for
; that letter in a field of 6, as many "*" as the number of errors for that letter and "\r".
;
;The string has a length greater or equal to one and contains only letters from a to z.
;Examples
;     s="uuaaaxbbbbyyhwawiwjjjwwxym"
;     hist(s) => "u  2     **\rw  5     *****\rx  2     **"
;
;     or with dots to see white spaces:
;     hist(s) => "u..2.....**\rw..5.....*****\rx..2.....**"
;
;     s="uuaaaxbbbbyyhwawiwjjjwwxymzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
;     hist(s) => "u..2.....**\rw..5.....*****\rx..2.....**\rz..31....*******************************"
;
;     or printed:
;         u  2     **
;         w  5     *****
;         x  2     **
;         z  31    *******************************


(defn build-error [k v]
  (str k "  " v (apply str (repeat (- 6 (count (str v))) " ")) (apply str (repeat v "*"))))

(defn hist [s]
  (str/join "\r" (->> (filter #(#{\u \w \x \z} %) s)
                      (frequencies)
                      (reduce-kv (fn [acc k v] (conj acc (build-error k v))) [])
                      (sort))))
;; -------------------------------------------END---

;; Are they the same?
; Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure) that checks whether the two arrays
; have the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements
; in a squared, regardless of the order.
; Valid arrays
;
;   a = [121, 144, 19, 161, 19, 144, 19, 11]
;   b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
;
; comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144,
; 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of
; squares:
;
;   a = [121, 144, 19, 161, 19, 144, 19, 11]
;   b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
;
; Invalid arrays
;
; If we change the first number to something else, comp may not return true anymore:
;
;   a = [121, 144, 19, 161, 19, 144, 19, 11]
;   b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
;
; comp(a,b) returns false because in b 132 is not the square of any number of a.
;
;   a = [121, 144, 19, 161, 19, 144, 19, 11]
;   b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
;
; comp(a,b) returns false because in b 36100 is not the square of any number of a.
; Remarks
;
;    a or b might be [] (all languages except R, Shell).
;    a or b might be nil or null or None or nothing (except in Haskell, Elixir, C++, Rust, R, Shell, PureScript).
;
; If a or b are nil (or null or None), the problem doesn't make sense so return false.
; Note for C
;
; The two arrays have the same size (> 0) given as parameter in function comp.

(defn compSame [a b]
  (if (or (= nil a) (= nil b))
    false
    (= (sort (map #(* % %) a)) (sort b))))
;; -------------------------------------------END---

;; Playing on a chessboard
; With a friend we used to play the following game on a chessboard (8, rows, 8 columns). On the first row at the bottom
; we put numbers:
;
; 1/2, 2/3, 3/4, 4/5, 5/6, 6/7, 7/8, 8/9
;
; On row 2 (2nd row from the bottom) we have:
;
; 1/3, 2/4, 3/5, 4/6, 5/7, 6/8, 7/9, 8/10
;
; On row 3:
;
; 1/4, 2/5, 3/6, 4/7, 5/8, 6/9, 7/10, 8/11
;
; until last row:
;
; 1/9, 2/10, 3/11, 4/12, 5/13, 6/14, 7/15, 8/16
; When all numbers are on the chessboard each in turn we toss a coin. The one who get "head" wins and the other gives
; him, in dollars, the sum of the numbers on the chessboard. We play for fun, the dollars come from a monopoly game!
; Task
; How much can I (or my friend) win or loses for each game if the chessboard has n rows and n columns? Add all of the
; fractional values on an n by n sized board and give the answer as a simplified fraction.
;
; Ruby, Python, JS, Coffee, Clojure, PHP, Elixir, Crystal, Typescript, Go:
;
; The function called 'game' with parameter n (integer >= 0) returns as result an irreducible fraction written as an
; array of integers: [numerator, denominator]. If the denominator is 1 return [numerator].

(defn game [n]
  (let [res (/ (* n n) 2)]
    (if (ratio? res)
      ((juxt numerator denominator) res)
      [res])))
;; -------------------------------------------END---

;; Binaries
; Let us take a string composed of decimal digits: "10111213". We want to code this string as a string of 0 and 1 and
; after that be able to decode it.
; We decompose the given string in its decimal digits 1 0 1 1 1 2 1 3 and we will code each.
; Coding process to code a number n expressed in base 10:
;   a) Let k be the number of bits of n
;   b) Put k-1 times the digit 0 followed by the digit 1
;   c) Put number n in binary
;   d) Concat the result of b) and c)
; So we code 0 as 10, 1 as 11 ... etc...
; Repeating this process with the initial string
; "10111213" becomes : "11101111110110110111" resulting of concatenation of 11 10 11 11 11 0110 11 0111 .
; Task:
; Given strng a string of digits representing a decimal number the function code(strng) should return the coding of
; strng as explained above.
; Given a string strng resulting from the previous coding, decode it to get the corresponding decimal string.
; Examples:
;     code("77338855") --> "001111001111011101110001100000011000001101001101"
;     code("77338")  --> "0011110011110111011100011000"
;     code("0011121314") --> "1010111111011011011111001100"
;
;     decode("001111001111011101110001100000011000001101001101") -> "77338855"
;     decode("0011110011110111011100011000") -> "77338"
;     decode("1010111111011011011111001100") -> "0011121314"

(defn code [num]
  (let [digits (->> num str (map (comp read-string str)))]
    (reduce (fn [acc i]
              (str acc (let [bin (Integer/toBinaryString i)]
                         (str (apply str (repeat (dec (count bin)) "0")) "1" bin)))) "" digits )))

(defn decode [b]
  (loop [bin b res ""]
    (if (str/blank? bin)
      res
      (let [bits (inc (count (take-while #(not= \1 %) bin)))]
        (recur (subs bin (* 2 bits)) (str res (Integer/parseInt (subs bin bits (* 2 bits)) 2)))))))
;; -------------------------------------------END---

;; Help the bookseller !
; A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or
; more characters. The 1st character of a code is a capital letter which defines the book category.
; In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which
; indicates the quantity of books of this code in stock.
; For example an extract of a stocklist could be:
;   L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
; or
;   L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
; You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
;   M = {"A", "B", "C", "W"}
; or
;   M = ["A", "B", "C", "W"] or ...
; and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity
; according to each category.
; For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):
;  (A : 20) - (B : 114) - (C : 50) - (W : 0)
; where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to
; "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
; If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).

(defn total-for-category [stock cat]
  (->> (filter #(= cat (str (first %))) stock)
       (map #(str/split % #" "))
       (map #(Integer/parseInt (second %)))
       (reduce +)))

(defn stock-list [stock categories]
  (if (or (empty? stock) (empty? categories))
    []
    (map #(conj [] % (total-for-category stock %)) categories)))
;; -------------------------------------------END---

;; Mexican Wave
; In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be passed a
; string and you must return that string in an array where an uppercase letter is a person standing up.
; Rules
;  	1.  The input string will always be lower case but maybe empty.
;   2.  If the character in the string is whitespace then pass over it as if it was an empty seat.
; Example
;     wave("hello") => []string{"Hello", "hEllo", "heLlo", "helLo", "hellO"}

(defn wave [s]
  (let [l (dec (count s))]
    (loop [res []
           idx 0]
      (cond (> idx l) (filter #(not= s %) (distinct res))
            (= idx 0) (recur (conj res (str (str/upper-case (subs s 0 1)) (subs s 1))) (inc idx))
            (< idx l) (recur (conj res (str (subs s 0 idx) (str/upper-case (subs s idx (inc idx))) (subs s (inc idx)))) (inc idx))
            (= idx l) (recur (conj res (str (subs s 0 idx) (str/upper-case (subs s idx (inc idx))))) (inc idx))))))
;; -------------------------------------------END---

;; Stop gninnipS My sdroW!
; Write a function that takes in a string of one or more words, and returns the same string, but with all five or more
; letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces.
; Spaces will be included only when more than one word is present.
;
; Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" spinWords( "This is a test") => returns
; "This is a test" spinWords( "This is another test" )=> returns "This is rehtona test"

(defn spin-words [s]
  (str/join " "
            (map (fn [x] (if (< (count x) 5)
                           x
                           (str/reverse x)))
                 (str/split s #" "))))
;; -------------------------------------------END---

;; Sum of Digits / Digital Root
; Digital root is the recursive sum of all the digits in a number.
;
; Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a
; single-digit number is produced. This is only applicable to the natural numbers.
; Examples
;
;       16  -->  1 + 6 = 7
;      942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
;   132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
;   493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2

(defn digital-root [n]
  (if (< n 10)
    n
    (recur (reduce + (->> n str (map (comp read-string str)))))))
;; -------------------------------------------END---

;; Moves in squared strings (II)
; You are given a string of n lines, each substring being n characters long: For example:
;     s = "abcd\nefgh\nijkl\nmnop"
;
; We will study some transformations of this square of strings.
; Clock rotation 180 degrees: rot
;     rot(s) => "ponm\nlkji\nhgfe\ndcba"
;
; selfie_and_rot(s) (or selfieAndRot or selfie-and-rot) It is initial string + string obtained by clock rotation 180
; degrees with dots interspersed in order (hopefully) to better show the rotation when printed.
;     s = "abcd\nefgh\nijkl\nmnop" -->
;     "abcd....\nefgh....\nijkl....\nmnop....\n....ponm\n....lkji\n....hgfe\n....dcba"
;
; or printed:
;      |rotation        |selfie_and_rot
;      |abcd --> ponm   |abcd --> abcd....
;      |efgh     lkji   |efgh     efgh....
;      |ijkl     hgfe   |ijkl     ijkl....
;      |mnop     dcba   |mnop     mnop....
;                                ....ponm
;                                ....lkji
;                                ....hgfe
;                                ....dcba
;
; #Task:
;
; Write these two functions rotand selfie_and_rot
; and high-order function oper(fct, s) where
;       fct is the function of one variable f to apply to the string s (fct will be one of rot, selfie_and_rot)
;
; Examples
;       s = "abcd\nefgh\nijkl\nmnop"
;       oper(rot, s) => "ponm\nlkji\nhgfe\ndcba"
;       oper(selfie_and_rot, s) => "abcd....\nefgh....\nijkl....\nmnop....\n....ponm\n....lkji\n....hgfe\n....dcba"
;
; Notes
;
; The form of the parameter fct in oper changes according to the language. You can see each form according to the
; language in "Your test cases".
; It could be easier to take these katas from number (I) to number (IV)

(defn rot [s]
  (->> (str/split-lines s)
       (map #(apply str (reverse %)))
       (reverse)
       (str/join "\n")))

(defn selfie-and-rot [s]
  (str  (->> (str/split-lines s)
             (map #(apply str % (apply str (repeat (count %) "."))))
             (str/join "\n"))
        "\n"
        (->> (str/split-lines s)
             (map #(apply str (apply str (repeat (count %) ".")) (reverse %)))
             (reverse)
             (str/join "\n"))))

(defn oper [fct s]
  (fct s))
;; -------------------------------------------END---

;; Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
; The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the
; title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
;
; In effect: 89 = 8^1 + 9^2
;
; The next number in having this property is 135.
;
; See this property again: 135 = 1^1 + 3^2 + 5^3
;
; We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b]
; (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
;
; Let's see some cases:
;     sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
;     sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
; If there are no numbers of this kind in the range [a, b] the function should output an empty list.
;     sum_dig_pow(90, 100) == []

(defn is-eureka? [n]
  (let [digits (->> n str (map (comp read-string str)))]
    (= n (reduce + (map #(int (Math/pow %1 %2)) digits (range 1 (inc (count digits))))))))

(defn sum-dig-pow [a, b]
  (->> (range a (inc b))
       (reduce (fn [acc i] (if (is-eureka? i) (conj acc i) acc)) [])))
;; -------------------------------------------END---

;; Sum of Parts
; Let us consider this example (array written in general format):
;     ls = [0, 1, 3, 6, 10]
;
; Its following parts:
;
;     ls = [0, 1, 3, 6, 10]
;     ls = [1, 3, 6, 10]
;     ls = [3, 6, 10]
;     ls = [6, 10]
;     ls = [10]
;     ls = []
;
; The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]
; The function parts_sums (or its variants in other languages) will take as parameter a list ls and return a list of the
; sums of its parts as defined above.
; Other Examples:
;
;     ls = [1, 2, 3, 4, 5, 6]
;     parts_sums(ls) -> [21, 20, 18, 15, 11, 6, 0]
;
;     ls = [744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358]
;     parts_sums(ls) -> [10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0]

(defn parts-sums [ls]
  (reduce (fn [acc i] (conj acc (+ (first acc) i))) '(0) (into '() ls)))
;; -------------------------------------------END---

;; Playing with digits
; Some numbers have funny properties. For example:
;    89 --> 8¹ + 9² = 89 * 1
;    695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
;    46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
;
; Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
; we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n.
;
; In other words:
;    Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
; If it is the case we will return k, if not return -1.
; Note: n and p will always be given as strictly positive integers.
;     dig-pow 89 1 should return 1 since 8¹ + 9² = 89 = 89 * 1
;     dig-pow 92 1 should return -1 since there is no k such as 9¹ + 2² equals 92 * k
;     dig-pow 695 2 should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
;     dig-pow 46288 3 should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51

(defn get-sum [n p]
  (loop [sum    0
         pow    p
         digits (->> n str (map (comp read-string str)))]
    (if (empty? digits)
      sum
      (recur (+ sum (Math/pow (first digits) pow)) (inc pow) (rest digits)))))

(defn dig-pow [n p]
  (let [v (get-sum n p)]
    (if (zero? (mod v n))
      (int (/ v n))
      -1)))
;; -------------------------------------------END---

;; Equal Sides Of An Array
; You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of
; the integers to the left of N is equal to the sum of the integers to the right of N. If there is no index that would
; make this happen, return -1.
;
;For example:
;
; Let's say you are given the array {1,2,3,4,3,2,1}: Your function will return the index 3, because at the 3rd position
; of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both
; equal 6.
;
; Let's look at another one.
; You are given the array {1,100,50,-51,1,1}: Your function will return the index 1, because at the 1st position of the
; array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.
;
; Last one:
; You are given the array {20,10,-80,10,10,15,35}
; At index 0 the left side is {}
; The right side is {10,-80,10,10,15,35}
; They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
; Index 0 is the place where the left side and right side are equal.
;
; Note: Please remember that in most programming/scripting languages the index of an array starts at 0.
;
; Input:
; An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.
;
; Output:
; The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index
; that fits these rules, then you will return -1.
;
; Note:
; If you are given an array with multiple answers, return the lowest correct index.

(defn find-even-index [arr]
  (loop [n 0]
    (if (= n (count arr))
      -1
      (if (= (reduce + (subvec arr 0 n))
             (reduce + (subvec arr (inc n))))
        n
        (recur (inc n))))))
;; -------------------------------------------END---

;; Change your Points of View
; We want to define the location x, y of a point on a two-dimensional plane where x and y are positive integers.
; Our definition of such a point will return a function (procedure). There are several possible functions to do that.
; Possible form of point:
; Of course we need to be able to extract from our point the two coordinates x and y.
; The function fst must return the first element x and our function snd must return the second element y.
; We will also write a function sqr-dist which returns the square of the distance between two points point1 and point2.
; Last function to write line:
; ;Given two points foo and bar this function return a list (l m n) or [l, m, n] where l, m, n are the coefficients in
; the general equation l*x + m*y + n = 0 (1) of the straight line through the points foo and bar.
; Equation k*l*x + k*m*y + k*n = 0 is equivalent to (1) and the tests consider that they define the "same" line.

(defn point [a b]
  (fn [] [a b]))

(defn fst [point]
  (first (point)))

(defn snd [point]
  (second (point)))

(defn sqr-dist [point1 point2]
  (let [delta-x (Math/abs (- (fst point2) (fst point1)))
        delta-y (Math/abs (- (snd point2) (snd point1)))]
    (+ (* delta-x delta-x) (* delta-y delta-y))))

(defn line [foo bar]
  [(- (snd foo) (snd bar))
   (- (fst bar) (fst foo))
   (- (* (fst foo) (snd bar))
      (* (snd foo) (fst bar)))])
;; -------------------------------------------END---

;; Unique In Order
; Implement the function unique_in_order which takes as argument a sequence and returns a list of items without any
; elements with the same value next to each other and preserving the original order of elements.
;
; For example:
;
;     uniqueInOrder("AAAABBBCCDAABBB") == {'A', 'B', 'C', 'D', 'A', 'B'}
;     uniqueInOrder("ABBCcAD")         == {'A', 'B', 'C', 'c', 'A', 'D'}
;     uniqueInOrder([1,2,2,3,3])       == {1,2,3}

(defn unique-in-order [input]
  (dedupe input))
;; -------------------------------------------END---

;; Create Phone Number
; Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the
; form of a phone number.
; Example:
;
; (create-phone-number [1 2 3 4 5 6 7 8 9 0]) ;; => returns "(123) 456-7890"
;
; The returned format must be correct in order to complete this challenge.
; Don't forget the space after the closing parentheses!

(defn create-phone-number [nums]
  (str  "(" (apply str (take 3 nums)) ") "
        (apply str (subvec nums 3 6)) "-"
        (apply str (subvec nums 6 10))))
;; -------------------------------------------END---

;; Bit Counting
; Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary
; representation of that number. You can guarantee that input is non-negative.
;
; Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case


(defn count-bits [n]
  (count (filter #(= \1 %) (Integer/toString n 2))))
;; -------------------------------------------END---

;; The Shell Game
; "The Shell Game" involves cups upturned on a playing surface, with a ball placed underneath one of them. The index of
; the cups are swapped around multiple times. After that the players will try to find which cup contains the ball.
;
; Your task is as follows. Given the cup that the ball starts under, and list of swaps, return the location of the ball
; at the end. Cups are given like array/list indices.
;
; For example, given the starting position 0 and the swaps [(0, 1), (1, 2), (1, 0)]:
; The first swap moves the ball from 0 to 1
; The second swap moves the ball from 1 to 2
; The final swap doesn't affect the position of the ball.
; So
;     (= (find-the-ball 0 [[0 1] [2 1] [0 1]]) 2)
;
; There aren't necessarily only three cups in this game, but there will be at least two. You can assume all swaps are
; valid, and involve two distinct indices.

(defn find-the-ball [start swaps]
  (if (empty? swaps)
    start
    (let [x (ffirst swaps)
          y (second (first swaps))]
      (cond (= start x) (recur y (rest swaps))
            (= start y) (recur x (rest swaps))
            :else (recur start (rest swaps))))))
;; -------------------------------------------END---

;; Count the smiley faces!
; Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling
; faces.
;
; Rules for a smiling face:
;
;    Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
;    A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
;    Every smiling face must have a smiling mouth that should be marked with either ) or D
;
; No additional characters are allowed except for those mentioned.
;
; Valid smiley face examples: :) :D ;-D :~)
; Invalid smiley faces: ;( :> :} :]
; Example
;
;     countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
;     countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
;     countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
;
; Note
;
; In case of an empty array return 0. You will not be tested with invalid input (input will always be an array). Order
; of the face (eyes, nose, mouth) elements will always be the same.


(defn valid-smiley? [s]
  (let [valid-eyes #{\; \:}
        valid-noses #{\- \~}
        valid-mouths #{\D \)}]
    (and (not= nil (valid-eyes (first s)))
         (if (= (count s) 2)
           (not= nil (valid-mouths (second s)))
           (do
             (and (not= nil (valid-noses (second s)))
                  (not= nil (valid-mouths (nth s 2)))))))))

(defn count-smileys [arr]
  (count (filter valid-smiley? arr)))
;; -------------------------------------------END---

;; Detect Pangram
; A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
; "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is
; irrelevant).
;
; Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and
; punctuation.

(defn pangram?
  [s]
  (= (count (->> (str/lower-case s)
                 (re-seq #"[A-Za-z]")
                 (set))) 26))
;; -------------------------------------------END---

;; Counting Duplicates
; Count the number of Duplicates
;
; Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that
; occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase
; and lowercase) and numeric digits.
; Example
;
; "abcde" -> 0 # no characters repeats more than once
; "aabbcde" -> 2 # 'a' and 'b'
; "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
; "indivisibility" -> 1 # 'i' occurs six times
; "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
; "aA11" -> 2 # 'a' and '1'
; "ABBA" -> 2 # 'A' and 'B' each occur twice

(defn duplicate-count [text]
  (count (filter #(>= (second %) 2) (frequencies (str/lower-case text)))))
;; -------------------------------------------END---


;; Consecutive Strings
; You are given an array(list) strarr of strings and an integer k. Your task is to return the first longest string
; consisting of k consecutive strings taken in the array.
; Example:
;
; longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
; n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
;
; Note
; consecutive strings : follow one after another without an interruption

(defn longest-cons [xs k]
  (if (or (<= k 0)
          (zero? (count xs))
          (> k (count xs)))
    ""
    (->> (map-indexed (fn [ix _] (str/join "" (subvec xs ix (+ ix k)))) (range 0 (inc (- (count xs) k))))
         (sort-by count #(> %1 %2))
         (first))))
;; -------------------------------------------END---

;; Pyramid Array
; Write a function that when given a number >= 0, returns an Array of ascending length subarrays.
;
; pyramid(0) => [ ]
; pyramid(1) => [ [1] ]
 ;pyramid(2) => [ [1], [1, 1] ]
; pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]
;
; Note: the sub arrays should be filled with 1s

(defn pyramid [n]
  (map #(vec (repeat % 1)) (range 1 (inc n))))
;; -------------------------------------------END---



