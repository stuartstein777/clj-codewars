(ns clj-codewars.7kyu-3
  (:require [clojure.string :as str]
            [clojure.set :as set]))


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
