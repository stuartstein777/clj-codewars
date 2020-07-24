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