(ns clj-codewars.8kyu
  (:require [clojure.string :as str]))

;; Convert a Number to a String!
; We need a function that can transform a number into a string.
;
; What ways of achieving this do you know?
; Examples:
;
; number-to-string 123 ;; returns '123'
; number-to-string 999 ;; returns '999'

(defn number-to-string [num]
  (str num))
;; -------------------------------------------END---

;; Opposite number
; Very simple, given a number, find its opposite.
;
;Examples:
;
; 1: -1
; 14: -14
; -34: 34

(defn opposite [number]
  (- 0 number))
;; -------------------------------------------END---

;; Find the Slope
; Given an array of 4 integers
; [a,b,c,d] representing two points (a, b) and (c, d), return a string representation of the slope of the line
; joining these two points.
;
; For an undefined slope (division by 0), return undefined . Note that the "undefined" is case-sensitive.
;
;   a:x1
;   b:y1
;   c:x2
;   d:y2
;
; Assume that [a,b,c,d] and the answer are all integers (no floating numbers!).
; Slope: https://en.wikipedia.org/wiki/Slope

(defn slope [v]
  (let [delta-x (- (nth v 3) (second v))
        delta-y (- (nth v 2) (first v))]
    (if (= 0 delta-y)
      "undefined"
      (str (/ delta-x delta-y)))))
;; -------------------------------------------END---

;; Kata Example Twist
; This is an easy twist to the example kata (provided by Codewars when learning how to create your own kata).
;
; Add the value "codewars" to the array websites/Websites 1,000 times.
;
; (defn websites [])

(def websites
  (repeat 1000 "codewars"))
;; -------------------------------------------END---

;; Determine offspring sex based on genes XX and XY chromosomes
; The male gametes or sperm cells in humans and other mammals are heterogametic and contain one of two types of sex
; chromosomes. They are either X or Y. The female gametes or eggs however, contain only the X sex chromosome and are
; homogametic.
;
; The sperm cell determines the sex of an individual in this case. If a sperm cell containing an X chromosome
; fertilizes an egg, the resulting zygote will be XX or female. If the sperm cell contains a Y chromosome, then the
; resulting zygote will be XY or male.
;
; Determine if the sex of the offspring will be male or female based on the X or Y chromosome present in the male's
; sperm.
;
; If the sperm contains the X chromosome, return "Congratulations! You're going to have a daughter.";
; If the sperm contains the Y chromosome, return "Congratulations! You're going to have a son.";

(defn chromosome-check [sperm]
  (if (= "XY" sperm)
    "Congratulations! You're going to have a son."
    "Congratulations! You're going to have a daughter."))
;; -------------------------------------------END---

;; Exclusive "or" (xor) Logical Operator
; Overview
;
; In some scripting languages like PHP, there exists a logical operator (e.g. &&, ||, and, or, etc.) called the
; "Exclusive Or" (hence the name of this Kata). The exclusive or evaluates two booleans. It then returns true if
; exactly one of the two expressions are true, false otherwise. For example:
;
;false xor false == false // since both are false
;true xor false == true // exactly one of the two expressions are true
;false xor true == true // exactly one of the two expressions are true
;true xor true == false // Both are true.  "xor" only returns true if EXACTLY one of the two expressions evaluate to
; true.
;
;Task
;
;Since we cannot define keywords in Javascript (well, at least I don't know how to do it), your task is to define
; a function xor(a, b) where a and b are the two expressions to be evaluated. Your xor function should have the
; behaviour described above, returning true if exactly one of the two expressions evaluate to true, false otherwise.

(defn xor [a,b]
  (cond (and (= true a) (= true b)) false
        (and (= true a) (= false b)) true
        (and (= false a) (= true b)) true
        :else false))
;; -------------------------------------------END---

;; Transportation on vacation
; After a hard quarter in the office you decide to get some rest on a vacation. So you will book a flight for you and
; your girlfriend and try to leave all the mess behind you.
;
; You will need a rental car in order for you to get around in your vacation. The manager of the car rental makes you
; some good offers.
;
; Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total.
; Alternatively, if you rent the car for 3 or more days, you get $20 off your total.
;
; Write a code that gives out the total amount for different days(d).
(defn rental-car-cost [d]
  (cond (>= d 7) (- (* d 40) 50)
        (>= d 3) (- (* d 40) 20)
        :else (* d 40)))
;; -------------------------------------------END---

;; Are You Playing Banjo?
; Create a function which answers the question "Are you playing banjo?".
; If your name starts with the letter "R" or lower case "r", you are playing banjo!
;
; The function takes a name as its only argument, and returns one of the following strings:
;
; name + " plays banjo"
; name + " does not play banjo"
;
; Names given are always valid strings.

(defn plays-banjo?
  [name]
  (if (= \r (first (str/lower-case name)))
    (str name " plays banjo")
    (str name " does not play banjo")))
;; -------------------------------------------END---

;; How many lightsabers do you own?
; Inspired by the development team at Vooza, write the function howManyLightsabersDoYouOwn/how_many_light_sabers_do_you_own that
;
;    accepts the name of a programmer, and
;    returns the number of lightsabers owned by that person.
;
; The only person who owns lightsabers is Zach, by the way. He owns 18, which is an awesome number of lightsabers. Anyone else owns 0.
;
; (howManyLightsabersDoYouOwn "Anny Wan-Else")     == 0
; (howManyLightsabersDoYouOwn "Hugh R. Dareader")  == 0
; (howManyLightsabersDoYouOwn "Zach")              == 18

(defn howManyLightsabersDoYouOwn [name]
  (if (= name "Zach")
    18
    0))
;; -------------------------------------------END---

;; Convert a String to a Number!
; Description
;
; We need a function that can transform a string into a number. What ways of achieving this do you know?
;
; Note: Don't worry, all inputs will be strings, and every string is a perfectly valid representation of an integral
; number.
; Examples
;
; (stringToNumber "1234") => 1234
; (stringToNumber "605")  => 605
; (stringToNumber "1405") => 1405
; (stringToNumber "-7")   => -7

(defn string-to-number [str]
  (Integer/parseInt str))
;; -------------------------------------------END---

;; Function 1 - hello world
; Make a simple function called greet that returns the most-famous "hello world!".
; Sure, this is about as easy as it gets. But how clever can you be to create the most creative hello world you can
; think of? What is a "hello world" solution you would want to show your friends?

(defn greet-hw []
  "hello world!")
;; -------------------------------------------END---

;; Grasshopper - Summation
; Write a program that finds the summation of every number from 1 to num. The number will always be a positive integer greater than 0.
; For example:
;
; summation(2) -> 3
; 1 + 2
;
; summation(8) -> 36
; 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8

(defn summation [n]
  (reduce + (range 1 (inc n))))
;; -------------------------------------------END---

;; Simple Fun #1: Seats in Theater
; Your friend advised you to see a new performance in the most popular theater in the city. He knows a lot about art
; and his advice is usually good, but not this time: the performance turned out to be awfully dull. It's so bad you
; want to sneak out, which is quite simple, especially since the exit is located right behind your row to the left.
; All you need to do is climb over your seat and make your way to the exit.
;
; The main problem is your shyness: you're afraid that you'll end up blocking the view (even if only for a couple of
; seconds) of all the people who sit behind you and in your column or the columns to your left. To gain some courage,
; you decide to calculate the number of such people and see if you can possibly make it to the exit without disturbing
; too many people.
;
 ;Given the total number of rows and columns in the theater (nRows and nCols, respectively), and the row and column
; you're sitting in, return the number of people who sit strictly behind you and in your column or to the left,
; assuming all seats are occupied.
; Example
;
; For nCols = 16, nRows = 11, col = 5 and row = 3, the output should be
;
; (seats-in-theater n-cols n-rows col row) ; 96

(defn seats-in-theater [n-cols n-rows col row]
  (* (- (inc n-cols) col) (- n-rows row)))
;; -------------------------------------------END---

;; Grasshopper - Terminal game move function
; Terminal game move function
; In this game, the hero moves from left to right. The player rolls the dice and moves the number of spaces indicated by the dice two times.
; Create a function for the terminal game that takes the current position of the hero and the roll (1-6) and return the new position.
; Example:
; move(3, 6) should equal 15

(defn move [position roll]
  (+ position roll roll))
;; -------------------------------------------END---

;; Count the Monkeys!
; You take your son to the forest to see the monkeys. You know that there are a certain number there (n), but your
; son is too young to just appreciate the full number, he has to start counting them from 1.
;
; As a good parent, you will sit and count with him. Given the number (n), populate an array with all numbers up to
; and including that number, but excluding zero.
;
; For example:
;
; monkeyCount(10) // --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
; monkeyCount(1) // --> [1]

(defn monkey-count [n]
  (loop [c 1 counted []]
    (if (>= n c)
      (recur (inc c) (conj counted c))
      counted)))
;; -------------------------------------------END---

;; Is n divisible by x and y?
; Create a function that checks if a number n is divisible by two numbers x AND y. All inputs are positive,
; non-zero digits.
;
; Examples:
; n = 3, x = 1, y = 3 => true because 3 is divisible by 1 and 3
; n = 12, x = 2, y = 6 => true because 12 is divisible by 2 and 6
; n = 100, x = 5, y = 3 => false because 100 is not divisible by 3
; n = 12, x = 7, y = 5 => false because 12 is neither divisible by 7 nor 5

(defn is-divisible [n x y]
  (and (= 0 (mod n x)) (= 0 (mod n y))))
;; -------------------------------------------END---

;; Growth of a Population
; In a small town the population is p0 = 1000 at the beginning of a year. The population regularly increases by
; 2 percent per year and moreover 50 new inhabitants per year come to live in the town. How many years does the town
; need to see its population greater or equal to p = 1200 inhabitants?
;
; At the end of the first year there will be:
;     1000 + 1000 * 0.02 + 50 => 1070 inhabitants
;
; At the end of the 2nd year there will be:
;     1070 + 1070 * 0.02 + 50 => 1141 inhabitants (number of inhabitants is an integer)
;
; At the end of the 3rd year there will be:
;     1141 + 1141 * 0.02 + 50 => 1213
; It will need 3 entire years.
;
; More generally given parameters:
;     p0, percent, aug (inhabitants coming or leaving each year), p (population to surpass)
;
; the function nb_year should return n number of entire years needed to get a population greater or equal to p.
; aug is an integer, percent a positive or null number, p0 and p are positive integers (> 0)
;
; Examples:
; nb_year(1500, 5, 100, 5000) -> 15
; nb_year(1500000, 2.5, 10000, 2000000) -> 10
;
; Note: Don't forget to convert the percent parameter as a percentage in the body of your function: if the parameter
; percent is 2 you have to convert it to 0.02.

(defn nb-year [p0 percent aug p]
  ((fn [p0 percent aug p years]
     (if (> p p0)
       (recur (Math/floor (+ p0 aug (* p0 (/ percent 100)))) percent aug p (inc years))
       years)) p0 percent aug p 0))
;; -------------------------------------------END---

;; Third Angle of a Triangle
; You are given two angles (in degrees) of a triangle.
; Write a function to return the 3rd.
; Note: only positive integers will be tested.

(defn third-angle [a b]
  (- 180 a b))
;; -------------------------------------------END---

;; Even or Odd
; Create a function (or write a script in Shell) that takes an integer as an argument and returns "Even" for even
; numbers or "Odd" for odd numbers.

(defn even-or-odd [number]
  (if (even? number) "Even" "Odd"))
;; -------------------------------------------END---

;; Get Nth Even Number
; Return the Nth Even Number
;   nthEven(1) //=> 0, the first even number is 0
;   nthEven(3) //=> 4, the 3rd even number is 4 (0, 2, 4)
;   nthEven(100) //=> 198
;   nthEven(1298734) //=> 2597466
; The input will not be 0.

(defn nth-even [n]
  (* 2 (dec n)))
;; -------------------------------------------END---

;; Sum Arrays
; Sum Array
;
; Write a method sum (sum_array in python, sumarray in julia, SumArray in C#) that takes an array of numbers and
; returns the sum of the numbers. These may be integers or decimals for Ruby and any instance of Num for Haskell.
; The numbers can also be negative. If the array does not contain any numbers then you should return 0.
; Examples
;
;   (println (sum [1 2 3]))
;   > 6
;   (println (sum []))
;   > 0
;
; Assumptions
;
; * You can assume that you are only given numbers.
; * You cannot assume the size of the array.
; * You can assume that you do get an array and if the array is empty, return 0.

(defn sum
  [a]
  (reduce + a))
;; -------------------------------------------END---

;; How good are you really?
; There was a test in your class and you passed it. Congratulations!
; But you're an ambitious person. You want to know if you're better than the average student in your class.
;
; You receive an array with your peers' test scores. Now calculate the average and compare your score!
;
; Return True if you're better, else False!
; Note:
; Your points are not included in the array of your class's points. For calculating the average point you may add your
; point to the given array!

(defn better_than_average [class_points your_points]
  (let [class-avg (quot (reduce + class_points) (count class_points))]
    (if (> your_points class-avg)
      true
      false)))
;; -------------------------------------------END---

;; String repeat
; Write a function called repeatString which repeats the given String src exactly count times.
;
; repeatStr(6, "I") // "IIIIII"
; repeatStr(5, "Hello") // "HelloHelloHelloHelloHello"

(defn repeat-str [n strng]
  (apply str (repeat n strng)))
;; -------------------------------------------END---

;; How do I compare numbers?
; What could be easier than comparing integer numbers? However, the given piece of code doesn't recognize some of the
; special numbers for a reason to be found. Your task is to find the bug and eliminate it.

(defn what-is [x]
  (cond
    (identical? x 42) "everything"
    (= x (* 42 42)) "everything squared"
    :else "nothing"))
;; -------------------------------------------END---

;; You Can't Code Under Pressure #1
; Code as fast as you can! You need to double the integer and return it.
(defn double-integer [i]
  (* 2 i))

;; -------------------------------------------END---

;; Function 2 - squaring an argument
; Now you have to write a function that takes an argument and returns the square of it.

(defn square [n]
  (* n n))
;; -------------------------------------------END---

;; My head is at the wrong end!
; You're at the zoo... all the meerkats look weird. Something has gone terribly wrong - someone has gone and switched
; their heads and tails around!
;
; Save the animals by switching them back. You will be given an array which will have three values (tail, body, head).
; It is your job to re-arrange the array so that the animal is the right way round (head, body, tail).
;
; Same goes for all the other arrays/lists that you will get in the tests: you have to change the element positions
; with the same exact logics - simples!

(defn fix-the-meerkat [arr]
  (list (last arr) (second arr) (first arr)))
;; -------------------------------------------END---

;; Sort and Star
; You will be given an vector of string(s). You must sort it alphabetically (case-sensitive, and based on the ASCII
; values of the chars) and then return the first value.
; The returned value must be a string, and have "***" between each of its letters.
; You should not remove or add elements from/to the array.

(defn star-sort [arr]
  (apply str (interpose "***" (first (sort arr)))))
;; -------------------------------------------END---

;; Grasshopper - Personalized Message
; Personalized greeting
; Create a function that gives a personalized greeting. This function takes two parameters: name and owner.
; Use conditionals to return the proper message:
;   case 	name equals owner return 'Hello boss'
;   case  otherwise         return 'Hello guest'

(defn greet [name_ owner]
  (cond (= name_ owner) "Hello boss"
        :else "Hello guest"))
;; -------------------------------------------END---

;; Do i get a bonus?
; It's bonus time in the big city! The fatcats are rubbing their paws in anticipation... but who is going to make the
; most money?
; Build a function that takes in two arguments (salary, bonus). Salary will be an integer, and bonus a boolean.
; If bonus is true, the salary should be multiplied by 10. If bonus is false, the fatcat did not make enough money and
; must receive only his stated salary.

(defn bonus-time [salary bonus]
  (if bonus
    (str "$" (* 10 salary))
    (str "$" salary)))
;; -------------------------------------------END---

;; Multiply
; The code does not execute properly. Try to figure out why.

(defn multiply [a b]
  (* a b))
;; -------------------------------------------END---

;; Grasshopper - Messi goals function
; Messi goals function
;
;Messi is a soccer player with goals in three leagues:
;    LaLiga
;    Copa del Rey
;    Champions
; Complete the function to return his total number of goals in all three leagues.
; Note: the input will always be valid.
; For example:
;   5, 10, 2  -->  17

(defn goals [la-liga-goals copa-del-rey-goals champions-league-goals]
  (+ la-liga-goals copa-del-rey-goals champions-league-goals))
;; -------------------------------------------END---

;; Grasshopper - Check for factor
; This function should test if the factor is a factor of base.
; Return true if it is a factor or false if it is not.
; About factors
; Factors are numbers you can multiply together to get another number.
;   2 and 3 are factors of 6 because: 2 * 3 = 6
; You can find a factor by dividing numbers. If the remainder is 0 then the number is a factor.
; You can use the mod operator (%) in most languages to check for a remainder
; For example 2 is not a factor of 7 because: 7 % 2 = 1
; Note: base is a non-negative number, factor is a positive number.

(defn check-for-factor [base factor]
  (= 0 (rem base factor)))
;; -------------------------------------------END---

