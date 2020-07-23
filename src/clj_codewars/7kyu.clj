(ns clj-codewars.7kyu
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; Char Code Calculation
; Given a string, turn each letter into its ASCII character code and join them together to create a number -
; let's call this number total1:
;
; 'ABC' --> 'A' = 65, 'B' = 66, 'C' = 67 --> 656667
;
; Then replace any incidence of the number 7 with the number 1, and call this number 'total2':
;
; total1 = 656667
;               ^
; total2 = 656661
;               ^
;
; Then return the difference between the sum of the digits in total1 and total2:
;
;   (6 + 5 + 6 + 6 + 6 + 7)
; - (6 + 5 + 6 + 6 + 6 + 1)
; -------------------------
;                        6

(defn calc [s]
  (reduce #(if (= \7 %2)
             (+ % 6)
             %) 0 (map identity (apply str (map int s)))))
;; -------------------------------------------END---

;; Binary scORe
; Given a number n we will define its scORe to be 0 | 1 | 2 | 3 | ... | n, where | is the bitwise OR operator.
; Write a function that takes n and finds it's scORe.
; n 	      scORe n
; 0 	      0
; 1 	      1
; 49 	      63
; 1000000 	1048575

(defn score [n]
  (reduce + (take-while #(<= % n) (iterate #(* 2 %) 1N))))
;; -------------------------------------------END---

;; Jaden Casing Strings
; Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
; Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter,
; he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word,
; check out how contractions are expected to be in the example below.
;
; Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from
; Jaden Smith, but they are not capitalized in the same way he originally typed them.
;
; Example:
;
; Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
; Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"

(defn jaden-case [s]
  (->> (str/split s #" ")
       (map #(str (str/upper-case (subs % 0 1)) (subs % 1)))
       (str/join " ")))
;; -------------------------------------------END---

;; Deodorant Evaporator
; This program tests the life of an evaporator containing a gas.
;
; We know the content of the evaporator (content in ml), the percentage of foam or gas lost every day (evap_per_day)
; and the threshold (threshold) in percentage beyond which the evaporator is no longer useful. All numbers are
; strictly positive.
;
; The program reports the nth day (as an integer) on which the evaporator will be out of use.
;
; Note : Content is in fact not necessary in the body of the function "evaporator", you can use it or not use it,
; as you wish. Some people might prefer to reason with content, some other with percentages only. It's up to you but
; you must keep it as a parameter because the tests have it as an argument.

(defn get-evaporated-content [content evap-per-day]
  (* content (/ evap-per-day 100)))

(defn evaporator [content, evap_per_day, threshold]
  (let [target-content (* content (/ threshold 100))]
    (loop [current-content content
           days 1]
      (let [evaporated-content (get-evaporated-content current-content evap_per_day)]
        (if (< (- current-content evaporated-content) target-content)
          days
          (recur (- current-content evaporated-content) (inc days)))))))
;; -------------------------------------------END---

;; Alternate capitalization
; Given a string, capitalize the letters that occupy even indexes and odd indexes separately,
; and return as shown below. Index 0 will be considered even.
;
; For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.
;
; The input will be a lowercase string with no spaces.

(defn solve-alternate-capitalization [s]
  [(apply str (map-indexed (fn [i c] (if (odd? i) c (str/upper-case c))) s))
   (apply str (map-indexed (fn [i c] (if (even? i) c (str/upper-case c))) s))])
;; -------------------------------------------END---

;; Disemvowel Trolls
; Trolls are attacking your comment section!
;
; A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing
; the threat.
; Your task is to write a function that takes a string and return a new string with all vowels removed.
; For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
; Note: for this kata y isn't considered a vowel.

(defn disemvowel
  [string]
  (apply str (filter #(not (#{\a \A \e \E \i \I \o \O \u \U} %)) string)))
;; -------------------------------------------END---

;; Responsible Drinking
; Welcome to the Codewars Bar!
; Codewars Bar recommends you drink 1 glass of water per standard drink so you're not hungover tomorrow morning.
; Your fellow coders have bought you several drinks tonight in the form of a string. Return a string suggesting how
; many glasses of water you should drink to not be hungover.
; Examples
;
; "1 beer"  =>  "1 glass of water"
; "1 shot, 5 beers and 1 glass of wine"  =>  "7 glasses of water"
; Notes
;
;    To keep the things simple, we'll consider that anything with a number in front of it is a drink:
;      "1 bear" => "1 glass of water" or "1 chainsaw and 2 pools" => "3 glasses of water"
;    The number in front of each drink lies in range [1; 9]

(defn hydrate [drink-string]
  (let [water (->> (re-seq #"\d+" drink-string)
                   (map #(Integer/parseInt %))
                   (reduce + 0))]
    (cond (= 1 water) (str water " glass of water")
          :else (str water " glasses of water"))))
;; -------------------------------------------END---

;; Simple Fun #3: Late Ride
; Task
;
; One night you go for a ride on your motorcycle. At 00:00 you start your engine, and the built-in timer automatically
; begins counting the length of your ride, in minutes. Off you go to explore the neighborhood.
;
; When you finally decide to head back, you realize there's a chance the bridges on your route home are up, leaving you
; stranded! Unfortunately, you don't have your watch on you and don't know what time it is. All you know thanks to the
; bike's timer is that n minutes have passed since 00:00.
;
; Using the bike's timer, calculate the current time. Return an answer as the sum of digits that the digital timer in
; the format hh:mm would show.
; Example
;
; For n = 240, the output should be
;
; lateRide(n) === 4
;
; Since 240 minutes have passed, the current time is 04:00. The digits sum up to 0 + 4 + 0 + 0 = 4, which is the answer.
;
; For n = 808, the output should be
;
; lateRide(n) === 14
;
; 808 minutes mean that it's 13:28 now, so the answer should be 1 + 3 + 2 + 8 = 14.
; Input/Output
;
;    [input] integer n
;
;    The duration of your ride, in minutes. It is guaranteed that you've been riding for less than a day (24 hours).
;
;    Constraints: 0 ≤ n < 60 * 24.
;
;    [output] an integer
;
;    The sum of the digits the digital timer would show.

(defn late-ride [n]
  (let [hours (quot (- n (rem n 60)) 60)
        minutes (rem n 60)]
    (+
      (reduce + (->> hours str (map (comp read-string str))))
      (reduce + (->> minutes str (map (comp read-string str)))))))
;; -------------------------------------------END---

;; Consecutive Ducks
; Positive integers have so many gorgeous features. Some of them could be expressed as a sum of two or more consecutive
; positive numbers.
; Consider an Example :
;
;    10 , could be expressed as a sum of 1 + 2 + 3 + 4.
;
; Task
;
; Given Positive integer, N , Return true if it could be expressed as a sum of two or more consecutive positive
; numbers, OtherWise return false .
; Notes
;
;    Guaranteed constraint : 2 ≤ N ≤ (2^31) -1 .
;
; Input >> Output Examples:
;  consecutiveDucks(9)  ==>  return (true)  //  9 , could be expressed as a sum of ( 2 + 3 + 4 ) or ( 4 + 5 ) .
;
;  consecutiveDucks(64)  ==>  return (false)
;
;  consecutiveDucks(42)  ==>  return (true) //  42 , could be expressed as a sum of ( 9 + 10 + 11 + 12 )  .

(defn consecutive-ducks [n]
  (and (not (zero? n)) (not (zero? (bit-and n (dec n))))))
;; -------------------------------------------END---

;; IPv4 Validator
; In this kata you have to write a method to verify the validity of IPv4 addresses.
;
; Example of valid inputs:
;   "1.1.1.1"
;   "127.0.0.1"
;   "255.255.255.255"
; Example of invalid input:
;   "1444.23.9"
;   "153.500.234.444"
;   "-12.344.43.11"

(defn validate-ip [ip]
  (let [octets (str/split ip #"\.")]
    (and (= 4 (count octets))
         (every? #(and (not= nil (re-matches #"\d+" %))
                       (<= 0 (Integer/parseInt %) 255)) octets))))
;; -------------------------------------------END---

;; Reducing Problems - Bug Fixing #8
;  Oh no! Timmy's reduce is causing problems, Timmy's goal is to calculate the two teams scores and return the winner
; but timmy has gotten confused and sometimes teams don't enter their scores, total the scores out of 3! Help timmy
; fix his program!
; Return true if team 1 wins or false if team 2 wins!

(defn calculate_total [t1 t2]
  (> (reduce + 0 t1)
     (reduce + 0 t2)))
;; -------------------------------------------END---

;; Penultimate
; Find the second-to-last element of a list.
; Example:
;   (penultimate [1,2,3,4])         ; => 3
;   (penultimate "LISP IS AWESOME") ; => \M

(defn penultimate
  "Gets the second to last element of an ISeq"
  [lst]
  (last (butlast lst)))
;; -------------------------------------------END---

;; Average Score
; Create a function that returns the average of an array of numbers ("scores"), rounded to the nearest whole number.
; You are not allowed to use any loops (including for, for/in, while, and do/while loops).

(defn average [data]
  (if (empty? data)
    0
    (quot (reduce + data) (count data))))
;; -------------------------------------------END---

;; Write a function partlist that gives all the ways to divide a list (an array) of at least two elements into two non-empty parts.
; Each two non empty parts will be in a pair (or an array for languages without tuples or a structin C - C: see Examples test Cases - )
; Each part will be in a string
; Elements of a pair must be in the same order as in the original array.
;
; Examples of returns in different languages:
;     a = ["az", "toto", "picaro", "zone", "kiwi"] -->
;     [["az", "toto picaro zone kiwi"], ["az toto", "picaro zone kiwi"], ["az toto picaro", "zone kiwi"],
;      ["az toto picaro zone", "kiwi"]]
; or
;     a = {"az", "toto", "picaro", "zone", "kiwi"} -->
;     > {{"az", "toto picaro zone kiwi"}, {"az toto", "picaro zone kiwi"}, {"az toto picaro", "zone kiwi"},
;        {"az toto picaro zone", "kiwi"}}
; or
;     a = ["az", "toto", "picaro", "zone", "kiwi"] -->
;     > [("az", "toto picaro zone kiwi"), ("az toto", "picaro zone kiwi"), ("az toto picaro", "zone kiwi"),
;        ("az toto picaro zone", "kiwi")]
;or
;     a = [|"az", "toto", "picaro", "zone", "kiwi"|] -->
;     > [("az", "toto picaro zone kiwi"), ("az toto", "picaro zone kiwi"), ("az toto picaro", "zone kiwi"),
;        ("az toto picaro zone", "kiwi")]
;or
;     a = ["az", "toto", "picaro", "zone", "kiwi"] -->
;     "(az, toto picaro zone kiwi)(az toto, picaro zone kiwi)(az toto picaro, zone kiwi)(az toto picaro zone, kiwi)"

(defn partlist [xs]
  (->> (map-indexed (fn [ix _] (list (str/join " " (take (inc ix) xs)) (str/join " " (drop (inc ix) xs)))) xs)
       (butlast)))
;; -------------------------------------------END---

;; Beginner Series #5 Triangular Numbers
; Triangular number is the amount of points that can fill equilateral triangle.
; Example: the number 6 is a triangular number because all sides of a triangle has the same amount of points.
; Hint!
;   T(n) = n * (n + 1) / 2,
;   n - is the size of one side.
;   T(n) - is the triangular number.
;
; Given a number 'T' from interval [1; 2147483646], find if it is triangular number or not.

(defn is-triangular [t]
  (let [root (Math/sqrt (inc (* 8 t)))]
    (= (inc (* 8 t)) (* (int (Math/ceil root)) (int (Math/ceil root))))))
;; -------------------------------------------END---

;; Drying Potatoes
; All we eat is water and dry matter.
; John bought potatoes: their weight is 100 kilograms. Potatoes contain water and dry matter.
; The water content is 99 percent of the total weight. He thinks they are too wet and puts them in an oven - at low temperature - for them to lose some water.
; At the output the water content is only 98%.
; What is the total weight in kilograms (water content plus dry matter) coming out of the oven?
; He finds 50 kilograms and he thinks he made a mistake: "So much weight lost for such a small change in water content!"
; Can you help him?
; Write function potatoes with
;
;    int parameter p0 - initial percent of water-
;    int parameter w0 - initial weight -
;    int parameter p1 - final percent of water -
;
; potatoes should return the final weight coming out of the oven w1 truncated as an int.
; Example:
;   potatoes(99, 100, 98) --> 50


(defn potatoes [p0 w0 p1]
  (int (Math/floor (* w0 (/ (- 100 p0) (- 100 p1))))))
;; -------------------------------------------END---

;; shorter concat [reverse longer]
; Given 2 strings, a and b, return a string of the form: shorter+reverse(longer)+shorter.
;
; In other words, the shortest string has to be put as prefix and as suffix of the reverse of the longest.
;
; Strings a and b may be empty, but not null (In C# strings may also be null. Treat them as if they are empty.).
; If a and b have the same length treat a as the longer producing b+reverse(a)+b

(defn reverseLonger
  [a b]
  (if (< (count a) (count b))
    (str a (str/reverse b) a)
    (str b (str/reverse a) b)))
;; -------------------------------------------END---

;; STRONGN Strong Number (Special Numbers Series #2)
; Strong number is the number that the sum of the factorial of its digits is equal to number itself.
; For example: 145, since
;   1! + 4! + 5! = 1 + 24 + 120 = 145
; So, 145 is a Strong number.
; Notes
;  * Number passed is always Positive.
;  * Return the result as String
;
; Input >> Output Examples
; strong_num(1) ==> return "STRONG!!!!"
; Since , the sum of its digits' factorial of (1) is equal to number itself (1) , Then its a Strong .
;
; strong_num(123) ==> return "Not Strong !!"
; Since the sum of its digits' factorial of 1! + 2! + 3! = 9 is not equal to number itself (123) ,
;  Then it's Not Strong.
;
; strong_num(2)  ==>  return "STRONG!!!!"
; Since the sum of its digits' factorial of 2! = 2 is equal to number itself (2) , Then its a Strong .
;
; strong_num(150) ==> return "Not Strong !!"
; Since the sum of its digits' factorial of 1! + 5! + 0! = 122 is not equal to number itself (150),
; Then it's Not Strong .

(defn factorial
  ([n] (factorial n 1))
  ([n sum]
   (cond (= 0 n) sum
         :else (recur (dec n) (* sum n)))))

(defn strong [n]
  (if (= n
         (->> n str
              (map (comp read-string str))
              (map factorial)
              (reduce +)))
    "STRONG!!!!"
    "Not Strong !!"))
;; -------------------------------------------END---

;; Last
; Find the last element of the given argument(s).
; Examples
;   (last [1, 2, 3, 4]) ; => 4
;   (last "xyz")        ; => \z

(defn last-cw
  "Returns the last element of an ISeq"
  [lst]
  (first (reverse lst)))
;; -------------------------------------------END---

;; Average of numbers
; #Get the averages of these numbers
; Write a method, that gets an array of integer-numbers and return an array of the averages of each integer-number and
; his follower, if there is one.
; Example:
; Input:  [ 1, 3, 5, 1, -10]
; Output:  [ 2, 4, 3, -4.5]
; If the array has 0 or 1 values or is null or None, your method should return an empty array.

(defn averages [ls]
  (if (< (count ls) 2)
    []
    (loop [xs ls
           a (first xs)
           b (second xs)
           avgs []]
      (if (= 1 (count xs))
        avgs
        (recur (rest xs) (first (rest xs)) (second (rest xs)) (conj avgs (/ (+ a b) 2.0)))))))
;; -------------------------------------------END---

;; Excel sheet column numbers
; Write a function
;     titleToNumber(title) or title_to_number(title) or titleToNb title ...
; (depending on the language)
; that given a column title as it appears in an Excel sheet, returns its corresponding column number. All column titles will be uppercase.
; Examples:
;   titleTonumber('A') === 1
;   titleTonumber('Z') === 26
;   titleTonumber('AA') === 27
;
; Note for Clojure:
;   Don't use Java Math/pow (even with bigint) because there is a loss of precision
;   when the length of "title" is growing.
; Write your own function "exp [x n]".

(defn pow [x n]
  (reduce *' (repeat x n)))

(defn title-to-nb [col]
  (reduce + (map-indexed (fn [i a] (* (inc (- (int a) (int \A))) (pow (dec (- (count col) i)) 26))) col)))
;; -------------------------------------------END---

;; Share prices
; Share price
; You spent all your saved money to buy some shares.
; You bought it for invested, and want to know how much it's worth, but all the info you can quickly get are just the change the shares price made in percentages.
; Your task:
; Write the function sharePrice() that calculates, and returns the current price of your share, given the following two arguments:
;    invested(number), the amount of money you initially invested in the given share
;    changes(array of numbers), contains your shares daily movement percentages
; The returned number, should be in string format, and it's precision should be fixed at 2 decimal numbers.

(defn share-price [invested changes]
  (if (empty? changes)
    (str invested ".00")  ;; stupid test
    (format "%.2f" (last (reductions #(+ % (/ (* % %2) 100.0)) invested changes)))))
;; -------------------------------------------END---

;; More than one way to call a function, or skin a cat.
; Write a single function that can be invoked by either
; (sum 2 3) ;; 5 ;; or ((sum 2) 3) ;; 5
; Both of these examples should return the sum of the 2 numbers.

(defn sum
  ([a b] (+ a b))
  ([a] (fn [b] (+ a b))))
;; -------------------------------------------END---

;; Looking for a benefactor
; The accounts of the "Fat to Fit Club (FFC)" association are supervised by John as a volunteered accountant. The
; association is funded through financial donations from generous benefactors. John has a list of the first n
; donations: [14, 30, 5, 7, 9, 11, 15] He wants to know how much the next benefactor should give to the association
; so that the average of the first n + 1 donations should reach an average of 30. After doing the math he found 149.
; He thinks that he made a mistake. Could you help him?
;     if dons = [14, 30, 5, 7, 9, 11, 15] then new_avg(dons, 30) --> 149
;
; The function new_avg(arr, navg) should return the expected donation (rounded up to the next integer) that will
; permit to reach the average navg.
;
; Should the last donation be a non positive number (<= 0) John wants us to throw (or raise) an error or
;
;    return Nothing in Haskell
;    return None in F#, Ocaml, Scala
;    return -1 in C, Fortran, Nim, PowerShell, Go, Prolog
;    echo ERROR in Shell
;    raise-argument-error in Racket
;
; so that he clearly sees that his expectations are not great enough.
;
; Notes:
;
;    all donations and navg are numbers (integers or floats), arr can be empty.
;    See examples below and "Test Samples" to see which return is to be done.
;
;     new_avg([14, 30, 5, 7, 9, 11, 15], 92) should return 645
;     new_avg([14, 30, 5, 7, 9, 11, 15], 2) should raise an error (ValueError or invalid_argument or argument-error
;                                           or DomainError) or return `-1` or ERROR or Nothing or None depending on the
;                                           language.

(defn new-avg [dons avg]
  (let [b (int (Math/ceil (- (* avg (inc (count dons))) (reduce + dons))))]
    (if (< b 0)
      (throw (IllegalArgumentException. ""))
      b)))
;; -------------------------------------------END---

;; Blood Moon

(defn blood-moon [n]
  (let [r n
        sq-acdf (* r r)
        cf (Math/sqrt (+ (* r r)(* r r)))
        c-acdf (* Math/PI (* cf cf))
        semi-ahf (/ (- c-acdf sq-acdf) 4)
        agf (* Math/PI (* r r))]
    (- (/ agf 2) semi-ahf)))
;; -------------------------------------------END---

;; Sum of Powers of 2
; Description
;
; Given a number n, you should find a set of numbers for which the sum equals n. This set must consist exclusively of
; values that are a power of 2 (eg: 2^0 => 1, 2^1 => 2, 2^2 => 4, ...).
;
; The function powers takes a single parameter, the number n, and should return an array of unique numbers.
; Criteria
;
; The function will always receive a valid input: any positive integer between 1 and the max integer value for your
; language (eg: for JavaScript this would be 9007199254740991 otherwise known as Number.MAX_SAFE_INTEGER).
;
; The function should return an array of numbers that are a power of 2 (2^x = y).
;
; Each member of the returned array should be unique. (eg: the valid answer for powers(2) is [2], not [1, 1])
;
; Members should be sorted in ascending order (small -> large). (eg: the valid answer for powers(6) is [2, 4],
; not [4, 2])

(defn powers [n]
  (loop [result []
         i      1
         binary (->> (Integer/toBinaryString n)
                     (str/reverse)
                     (seq))]
    (if (empty? binary)
      result
      (recur (if (= \1 (first binary)) (conj result i) result) (* 2 i) (rest binary)))))
;; -------------------------------------------END---

;; Sorted? yes? no? how?
; Complete the method which accepts an array of integers, and returns one of the following:
;
;    "yes, ascending" - if the numbers in the array are sorted in an ascending order
;    "yes, descending" - if the numbers in the array are sorted in a descending order
;    "no" - otherwise
;
; You can assume the array will always be valid, and there will always be one correct answer.

(defn sorted-and-how [sq]
  (cond (apply > sq) "yes, descending"
        (apply < sq) "yes, ascending"
        :else "no"))
;; -------------------------------------------END---

;; Reverse Letters in Sentence
; Take a sentence (string) and reverse each word in the sentence. Do not reverse the order of the words, just the letters in each word.
; If there is punctuation, it should be interpreted as a regular character; no special rules.
; If there is spacing before/after the input string, leave them there.
; String will not be empty.
; Examples
; "Hi mom" => "iH mom"
; "A fun little challenge! " => " A nuf elttil !egnellahc "

(defn reverser [s]
  (->> (partition-by #(= \space %) s)
       (map #(apply str (reverse %)))
       (apply str)))
;; -------------------------------------------END---

;; Homogenous arrays
; Challenge:
; Given a two-dimensional array, return a new array which carries over only those arrays from the original, which were not empty and whose items are all of the same type (i.e. homogenous). For simplicity, the arrays inside the array will only contain characters and integers.
; Example:
; Given [[1, 5, 4], ['a', 3, 5], ['b'], [], ['1', 2, 3]], your function should return [[1, 5, 4], ['b']].
; Addendum:
; Please keep in mind that for this kata, we assume that empty arrays are not homogenous.
; The resultant arrays should be in the order they were originally in and should not have its values changed.
; No implicit type casting is allowed. A subarray [1, '2'] would be considered illegal and should be filtered out.

(defn filter-homogenous [sq]
  (filter #(and (= (count (partition-by type %)) 1)
                (> (count %) 0)) sq))
;; -------------------------------------------END---

;; Password Check - Binary to String
; A wealthy client has forgotten the password to his business website, but he has a list of possible passwords. His
; previous developer has left a file on the server with the name password.txt. You open the file and realize it's in
; binary format.
;
;Write a script that takes an array of possible passwords and a string of binary representing the possible password.
; Convert the binary to a string and compare to the password array. If the password is found, return the password
; string, else return false;
;
;   decodePass(['password123', 'admin', 'admin1'],
;               '01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011');
;   => 'password123'
;   decodePass(['password321', 'admin', 'admin1'],
;               '01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011');
;   => false
;   decodePass(['password456', 'pass1', 'test12'],
;              '01110000 01100001 01110011 01110011 01110111 01101111 01110010 01100100 00110001 00110010 00110011');
;   => false

(defn decode-bin [b]
  (->> (partition 8 b)
       (map #(char (Integer/parseInt (apply str %) 2)))))

(defn decode-pass [pass-arr bin]
  (let [password (some #{(->> (str/split bin #" ")
                              (map decode-bin)
                              (flatten)
                              (apply str))} pass-arr)]
    (if (= nil password)
      false
      password)))
;; -------------------------------------------END---

;; getNames()
; The following code is not giving the expected results. Can you figure out what the issue is?
; The following is an example of data that would be passed in to the function.
;   (def data [
;       {:name "Joe" :age 20}
;       {:name "Bill" :age 30}
;       {:name "Kate" :age 23}
;     ])
;
;   (get-names data) ; should return ["Joe" "Bill" "Kate"]

(defn get-names [data]
  (map #(:name %) data))
;; -------------------------------------------END---

;; Sort Out The Men From Boys
; Scenario.
; Men are the Even numbers and Boys are the odd
; Task
; Given an array/list [] of n integers , Separate The even numbers from the odds , or Separate the men from the boys
; Notes
; * Return an array/list where Even numbers come first then odds
; * Since , Men are stronger than Boys , Then Even numbers in ascending order While odds in descending .
; * Array/list size is at least *4*** .
; * Array/list numbers could be a mixture of positives , negatives .
; * Have no fear , It is guaranteed that no Zeroes will exists .
; Repetition of numbers in the array/list could occur , So (duplications are not included when separating).

(defn men-from-boys [arr]
  (let [split ((juxt filter remove) even? (distinct arr))]
    (concat (sort < (first split)) (sort > (second split)))))
;; -------------------------------------------END---

;; Find the vowels
; We want to know the index of the vowels in a given word, for example, there are two vowels in the word super (the second and fourth letters).
; So given a string "super", we should return a list of [2, 4].
; Some examples:
;   Mmmm  => []
;   Super => [2,4]
;   Apple => [1,5]
;   YoMama -> [1,2,4,6]
; *NOTE: Vowels in this context refers to English Language Vowels - a e i o u y *
; NOTE: this is indexed from [1..n] (not zero indexed!)

(defn is-vowel? [x]
  (not= nil (#{\a \e \i \o \u \y \A \E \I \O \U \Y} x)))

(defn vowel-indices [word]
  ((fn [word indices idx]
     (if (empty? word)
       indices
       (if (is-vowel? (first word))
         (recur (rest word) (conj indices (inc idx)) (inc idx))
         (recur (rest word) indices (inc idx))))) word [] 0))
;; -------------------------------------------END---

;; Find the Missing Number
; The following was a question that I received during a technical interview for an entry level software developer
; position. I thought I'd post it here so that everyone could give it a go:
;
; You are given an unsorted array containing all the integers from 0 to 100 inclusively. However, one number is missing.
; Write a function to find and return this number. What are the time and space complexities of your solution?

(defn missing-no [xs]
  (let [all (set (range 0 101))]
    (first (set/difference all (set xs)))))
;; -------------------------------------------END---

;; Covfefe
; Your are given a string. You must replace the word(s) coverage by covfefe, however, if you don't find the word
; coverage in the string, you must add covfefe at the end of the string with a leading space.
; For the languages where the string is not immutable (such as ruby), don't modify the given string, otherwise this will
; break the test cases.

(defn covfefe[tweet]
  (if (str/includes? tweet "coverage")
    (str/replace tweet #"\bcoverage" "covfefe")
    (str tweet " covfefe")))
;; -------------------------------------------END---

;; Mumbling
; This time no story, no theory. The examples below show you how to write function accum:
;
; Examples:
;
;   accum("abcd") -> "A-Bb-Ccc-Dddd"
;   accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
;   accum("cwAt") -> "C-Ww-Aaa-Tttt"
;
; The parameter of accum is a string which includes only letters from a..z and A..Z.

(defn accum [s]
  (str/join "-" (map #(str/capitalize (apply str (repeat %2 % ))) s (range 1 (inc (count s))))))
;; -------------------------------------------END---

;; NumberPairs
; In this Kata the aim is to compare each pair of integers from 2 arrays, and return a new array of large numbers.
; Note: Both arrays have the same dimensions.
; Example:
;   (= arr1 [13, 64, 15, 17, 88])
;   (= arr2 [23, 14, 53, 17, 80])
;   (= (getLargerNumbers arr1 arr2) [23 64 53 17 88])

(defn get-larger-numbers [a b]
  (if (empty? a)
    []
    (map #(if (>= %1 %2)
            %1
            %2) a b)))
;; -------------------------------------------END---

;; First-Class Function Factory
; Write a function, factory, that takes a number as its parameter and returns another function.
;
; The returned function should take an array of numbers as its parameter, and return an array of those numbers
; multiplied by the number that was passed into the first function.
;
; In the example below, 5 is the number passed into the first function. So it returns a function that takes an array
; and multiplies all elements in it by five.
;
; Translations and comments (and upvotes) welcome!
; Example
;
;   (let [fives (factory 5)]      ; returns a function - fives
;     (fives [1 2 3]))            ; returns [5 10 15]

(defn factory [n]
  (fn [xs]
    (map #(* n %) xs)))
;; -------------------------------------------END---

;; Character Counter
; You are going to be given a word. Your job will be to make sure that each character in that word has the exact same
; number of occurrences. You will return true if it is valid, or false if it is not.
; For example:
;   "abcabc" is a valid word because 'a' appears twice, 'b' appears twice, and'c' appears twice.
;   "abcabcd" is NOT a valid word because 'a' appears twice, 'b' appears twice, 'c' appears twice, but 'd' only appears
;    once! "123abc!" is a valid word because all of the characters only appear once in the word.
;
; For this kata, capitals are considered the same as lowercase letters. Therefore: 'A' == 'a' .
; #Input A string (no spaces) containing [a-z],[A-Z],[0-9] and common symbols. The length will be 0 < string < 100.
; #Output true if the word is a valid word, or false if the word is not valid.

(defn validate-word [word]
  (apply = (vals (frequencies (str/lower-case word)))))
;; -------------------------------------------END---

;; Regexp Basics - is it a vowel?
; Implement the function which should return true if given object is a vowel (meaning a, e, i, o, u), and false
; otherwise.

(defn vowel[str]
  (not= nil (#{"a" "e" "i" "o" "u" "A" "E" "I" "O" "U"} str)))
;; -------------------------------------------END---

;; Find the K'th Element of a List
; Find the K'th element of a list. The first element in the list is number 1.
;
; Example:
;
;   (element-at [1,2,3] 2) ; => 2
;   (element-at "haskell" 5) ; => \e

(defn element-at
  "Find the K'th element of an ISeq"
  [lst n]
  (nth lst (dec n)))
;; -------------------------------------------END---

;; KISS - Keep It Simple Stupid
; KISS stands for Keep It Simple Stupid. It is a design principle for keeping things simple rather than complex.
; You are the boss of Joe.
; Joe is submitting words to you to publish to a blog. He likes to complicate things.
; Define a function that determines if Joe's work is simple or complex.
; Input will be non emtpy strings with no punctuation.
; It is simple if: the length of each word does not exceed the amount of words in the string (See example test cases)
; Otherwise it is complex.
; If complex:
;     return "Keep It Simple Stupid"
; or if it was kept simple:
;     return "Good work Joe!"
; Note: Random test are random and nonsensical. Here is a silly example of a random test:
; "jump always mostly is touchy dancing choice is pineapples mostly"

(defn kiss? [s]
  (if (>= (count (str/split s #" "))
          (apply max (map count (str/split s #" "))))
    "Good work Joe!"
    "Keep It Simple Stupid"))
;; -------------------------------------------END---

;; Arithmetic List!
; In this kata, you will write an arithmetic list which is basically a list that contains consecutive terms in the sequence.
; You will be given three parameters :
;
;    first the first term in the sequence
;    c the constant that you are going to ADD ( since it is an arithmetic sequence...)
;    l the number of terms that should be returned
;
; Useful link: Sequence

(defn seqlist
  "Generates consecutive terms in a sequence"
  [first c terms]
  (loop [n first
         res []]
    (if (= n (+ first (* c (dec terms))))
      (conj res n)
      (recur (+ n c) (conj res n)))))
;; -------------------------------------------END---

;; Unpacking Arguments
; You must create a function, spread, that takes a function and a list of arguments to be applied to that function.
; You must make this function return the result of calling the given function/lambda with the given arguments.
; eg:
;   (spread someFunction [1 true "Foo" "bar"] )
; is the same as...
;   (someFunction 1 true "Foo" "bar")

(defn spread-cw
  [func args]
  (apply func args))
;; -------------------------------------------END---

;; EAN Validation
; The single-digit checksum is calculated as followed (based upon the 12-digit data):
; The digit at the first, third, fifth, etc. position (i.e. at the odd position) has to be multiplied with "1".
; The digit at the second, fourth, sixth, etc. position (i.e. at the even position) has to be multiplied with "3".
; Sum these results.
; If this sum is dividable by 10, the checksum is 0. Otherwise the checksum has the following formula:
;   checksum = 10 - (sum mod 10)
; For example, calculate the checksum for "400330101839" (= 12-digits data):
;   4·1 + 0·3 + 0·1 + 3·3 + 3·1 + 0·3 + 1·1 + 0·3 + 1·1 + 8·3 + 3·1 + 9·3
;   = 4 + 0 + 0 + 9 + 3 + 0 + 1 + 0 + 1 + 24 + 3 + 27
;   = 72
;   10 - (72 mod 10) = 8 ⇒ Checksum: 8
;
; Thus, the EAN-Code is 4003301018398 (= 12-digits data followed by single-digit checksum).
; Your Task
; Validate a given EAN-Code. Return true if the given EAN-Code is valid, otherwise false.
; Assumption
; You can assume the given code is syntactically valid, i.e. it only consists of numbers and it exactly has a length of
; 13 characters.
; Examples
;
;   (validate-ean "4003301018398") ; => true
;   (validate-ean "4003301018392") ; => false

(defn validate-ean [ean-code]
  (loop [digits (butlast (map #(Character/getNumericValue %) ean-code))
         i      false
         s      0]
    (if (empty? digits)
      (if (zero? (mod s 10))
        (= (str (last ean-code)) (str (mod s 10)))
        (= (str (last ean-code)) (str (- 10 (mod s 10)))))
      (recur (rest digits) (not i) (if i
                                     (+ s (* 3 (first digits)))
                                     (+ s (first digits)))))))
;; -------------------------------------------END---

;; Which section did you scroll to?
; Your website is divided vertically in sections, and each can be of different size (height).
; You need to establish the section index (starting at 0) you are at, given the scrollY and sizes of all sections.
; Sections start with 0, so if first section is 200 high, it takes 0-199 "pixels" and second starts at 200.
; Example:
;     getSectionIdFromScroll( 300, [300,200,400,600,100] )
; will output number 1 as it's the second section.
;     getSectionIdFromScroll( 1600, [300,200,400,600,100] )
; will output number -1 as it's past last section.
; Given the scrollY integer (always non-negative) and an array of non-negative integers (with at least one element),
; calculate the index (starting at 0) or -1 if scrollY falls beyond last section (indication of an error).

(defn get-section-id [scroll sizes]
  (let [sections (reductions + sizes)]
    (if (>= scroll (apply max sections))
      -1
      (count (take-while #(<= % scroll) sections)))))
;; -------------------------------------------END---

;; Simple Fun #2: Circle of Numbers
; Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any
; two neighbouring numbers is equal (note that 0 and n - 1 are neighbouring, too).
;
; Given n and firstNumber/first_number, find the number which is written in the radially opposite position to firstNumber.
; Example
;
; For n = 10 and firstNumber = 2, the output should be
;   (circle-of-numbers n first-number) ; -> 7
;
; Input/Output
;    [input] integer n
;    A positive even integer.
;    Constraints: 4 ≤ n ≤ 1000.
;    [input] integer firstNumber/first_number
;    Constraints: 0 ≤ firstNumber ≤ n - 1
;    [output] an integer

(defn circle-of-numbers
  [n first-number]
  (mod (+ first-number (/ n 2)) n))
;; -------------------------------------------END---

;; Simple Fun #152: Invite More Women?
; King Arthur and his knights are having a New Years party. Last year Lancelot was jealous of Arthur, because Arthur
; had a date and Lancelot did not, and they started a duel.
;
; To prevent this from happening again, Arthur wants to make sure that there are at least as many women as men at this
; year's party. He gave you a list of integers of all the party goers.
;
; Arthur needs you to return true if he needs to invite more women or false if he is all set.
; Input/Output
;    [input] integer array L ($a in PHP)
;    An array (guaranteed non-associative in PHP) representing the genders of the attendees, where -1 represents women and 1 represents men.
;    2 <= L.length <= 50
;    [output] a boolean value
;    true if Arthur need to invite more women, false otherwise.

(defn invite-more-women [L]
  (> (reduce + L) 0))
;; -------------------------------------------END---

;; Powers of 3
; Given a positive integer N, return the largest integer k such that 3^k < N.
; For example,
;   largest_power(3) == 0
;   largest_power(4) == 1
; You may assume that the input to your function is always a positive integer.

(defn largest-power [n]
  (if (= n 1)
    -1
    (loop [r 1]
      (if (>= (Math/pow 3 r) n)
        (dec r)
        (recur (inc r))))))
;; -------------------------------------------END---

;; Distance from the average
; Given a starting list/array of data, it could make some statistical sense to know how much each value differs from
; the average.
;
; If for example during a week of work you have collected 55,95,62,36,48 contacts for your business, it might be
; interesting to know the total (296), the average (59.2), but also how much you moved away from the average each single
; day.
;
; For example on the first day you did something less than the said average (55, meaning -4.2 compared to the average),
; much more in the second day (95, 35.8 more than the average and so on).
;
; The resulting list/array of differences starting from [55, 95, 62, 36, 48] is thus [4.2, -35.8, -2.8, 23.2, 11.2].
;
; Assuming you will only get valid inputs (ie: only arrays/lists with numbers), create a function to do that, rounding
; each difference to the second decimal digit (this is not needed in Haskell); extra points if you do so in some smart,
; clever or concise way :)
;
; With Clojure to round use:
; (defn roundTo2 [n] (/ (Math/round (* n 100.0)) 100.0))

(defn roundTo2 [n] (/ (Math/round (* n 100.0)) 100.0))

(defn distances-from-average [arr]
  (let [avg (/ (reduce + arr) (count arr))]
    (map #(roundTo2 (- avg %)) arr)))
;; -------------------------------------------END---

;; Digitize
; Given a non-negative integer, return an array / a list of the individual digits in order.
; Examples:
;     123 => [1,2,3]
;     1 => [1]
;     8675309 => [8,6,7,5,3,0,9]

(defn digitize
  [n]
  (->> n str (map (comp read-string str))))
;; -------------------------------------------END---

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