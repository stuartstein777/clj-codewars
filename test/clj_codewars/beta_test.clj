(ns clj-codewars.beta-test
  (:require [clojure.test :refer :all]
            [clj-codewars.core :refer :all]
            [clj-codewars.beta :refer :all]))

(deftest current-level-test
  (is (=(current-level 600) :2))
  (is (=(current-level 0) :1)))

(deftest next-level-test
  (is (=(next-level 400) :3))
  (is (=(next-level 0) :2)))

(deftest xp-until-next-level-test
  (is (=(xp-until-next-level 0) 300))
  (is (=(xp-until-next-level 400) 500)))

(deftest basic-test

  (is (not (mutation ["hello" "hey"]))
      "should return false")

  (is (mutation ["hello" "Hello"])
      "should return true")

  (is (mutation ["zyxwvutsrqponmlkjihgfedcba" "qrstu"])
      "should return true")

  (is (mutation ["Mary" "Army"])
      "should return true")

  (is (mutation ["Mary" "Aarmy"])
      "should return true")

  (is (mutation ["Alien" "line"])
      "should return true")

  (is (mutation ["floor" "for"])
      "should return true")

  (is (not (mutation ["hello" "neo"]))
      "should return false")

  (is (not (mutation ["voodoo" "no"]))
      "should return false"))

(deftest basic-tests
  (with-redefs
    [clojure.string/capitalize
     (fn [& _]
       (throw (Exception. "Sorry! The capitalize built-in is disabled for this kata!")))]

    (is (string? (title-case "I'm a little tea pot"))
        "should return a string")

    (is (= (title-case "I'm a little tea pot")
           "I'm A Little Tea Pot")
        "should return \"I'm A Little Tea Pot\"")

    (is (= (title-case "sHoRt AnD sToUt")
           "Short And Stout")
        "should return \"Short And Stout\"")

    (is (= (title-case "HERE IS MY HANDLE HERE IS MY SPOUT")
           "Here Is My Handle Here Is My Spout")
        "should return  \"Here Is My Handle Here Is My Spout\"")))

(defn is-boolean? [x]
  (instance? Boolean x))

(deftest palindrome-test
  (is (is-boolean? (palindrome? "eye"))
      "should return a boolean")

  (is (palindrome? "eye")
      "should return true")

  (is (palindrome? "_eye")
      "should return true")

  (is (palindrome? "race car")
      "should return true")

  (is (not (palindrome? "not a palindrome"))
      "should return false")

  (is (palindrome? "A man, a plan, a canal. Panama")
      "should return true")

  (is (palindrome? "never odd or even")
      "should return true")

  (is (not (palindrome? "nope"))
      "should return false")

  (is (not (palindrome? "almostomla"))
      "should return false")

  (is (palindrome? "My age is 0, 0 si ega ym.")
      "should return true")

  (is (not (palindrome? "1 eye for of 1 eye."))
      "should return false")

  (is (palindrome? "0_0 (: /-\\ :) 0-0")  ;; the backslash is escaped
      "should return true")

  (is (not (palindrome? "five|\\_/|four")) ;; the backslash is escaped
      "should return false"))

(deftest basic-tests
  (is (= (destroyer [1 2 3 1 2 3] 2 3) [1 1]) "should return [1 1]")
  (is (= (destroyer [1 2 3 5 1 2 3] 2 3) [1 5 1]) "should return [1 5 1]")
  (is (= (destroyer [3 5 1 2 2] 2 3 5) [1]) "should return [1]")
  (is (= (destroyer [2 3 2 3] 2 3) []) "should return []")
  (is (= (destroyer ["tree" "hamburger" 53] "tree" 53) ["hamburger"]) "should return [\"hamburger\"]"))

(deftest basic-tests
  (with-redefs
    [clojure.string/capitalize
     (fn [& _]
       (throw (Exception. "Sorry! The ends-with? built-in is disabled for this kata!")))]

    (is (confirm-ending "Bastian" "n")
        "should return true")

    (is (not (confirm-ending "Connor" "n"))
        "should return false")

    (is (not (confirm-ending "Walking on water and developing software from a specification are easy if both are frozen"
                             "specification"))
        "should return false")

    (is (confirm-ending "He has to give me a new name" "name")
        "should return true")

    (is (confirm-ending "Open sesame" "same")
        "should return true")

    (is (not (confirm-ending "Open sesame", "pen"))
        "should return false")

    (is (not (confirm-ending "If you want to save our world, you must hurry. We dont know how much longer we can withstand the nothing"
                             "mountain"))
        "should return false")))

(deftest truncate-string-test

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket" 11)
         "A-tisket...")
      "should return \"A-tisket...\"")

  (is (= (truncate-string "Peter Piper picked a peck of pickled peppers" 14)
         "Peter Piper...")
      "should return \"Peter Piper...\"")

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket"
                          (count "A-tisket a-tasket A green and yellow basket"))
         "A-tisket a-tasket A green and yellow basket")
      "should return \"A-tisket a-tasket A green and yellow basket\"")

  (is (= (truncate-string "A-tisket a-tasket A green and yellow basket"
                          (+ 2 (count "A-tisket a-tasket A green and yellow basket")))
         "A-tisket a-tasket A green and yellow basket")
      "should return \"A-tisket a-tasket A green and yellow basket\"")

  (is (= (truncate-string "A-" 1)
         "A...")
      "should return \"A...\"")

  (is (= (truncate-string "Absolutely Longer" 2)
         "Ab...")
      "should return \"Ab...\""))

(deftest basic-tests

  (is (seq? (largest-of-four [[4 5 1 3] [13 27 18 26] [32 35 37 39] [1000 1001 857 1]]))
      "should return a sequence")

  (is (= (largest-of-four [[13 27 18 26] [4 5 1 3] [32 35 37 39] [1000 1001 857 1]])
         [27 5 39 1001])
      "should return [27 5 39 1001]")

  (is (= (largest-of-four [[4 9 1 3] [13 35 18 26] [32 35 97 39] [1000000 1001 857 1]])
         [9 35 97 1000000])
      "should return  [9 35 97 1000000]"))

(deftest basic-tests

  (is (= (bouncer [7 "ate" "" false 9])
         [7 "ate" "" 9])
      "should return [7 \"ate\" 9]")

  (is (= (bouncer ["a" "b" "c"])
         ["a" "b" "c"])
      "should return [\"a\" \"b\" \"c\"]")

  (is (= (bouncer [false nil])
         [])
      "should return []")

  (is (= (bouncer [1 nil 2])
         [1 2])
      "should return [1 2]"))

(deftest basic-tests

  (is (number? (find-longest-word "The quick brown fox jumped over the lazy dog"))
      "should return a number")

  (is (= (find-longest-word "The quick brown fox jumped over the lazy dog")
         6)
      "should return 6")

  (is (= (find-longest-word "May the force be with you")
         5)
      "should return 5")

  (is (= (find-longest-word "Google do a barrel roll")
         6)
      "should return 6")

  (is (= (find-longest-word "What is the average airspeed velocity of an unladen swallow")
         8)
      "should return 8")

  (is (= (find-longest-word "What if we try a super-long word such as otorhinolaryngology")
         19)
      "should return 19"))

(deftest always-tests
  (is (= ((always 1)) 1)))

(deftest where-do-i-belong-tests
  (is (= (get-index-to-insert [10 20 30 40 50] 35) 3) "should return 3")
  (is (= (get-index-to-insert [10 20 30 40 50] 30) 2) "should return 2")
  (is (= (get-index-to-insert [40 60] 50) 1) "should return 1")
  (is (= (get-index-to-insert [3 10 5] 3) 0) "should return 0")
  (is (= (get-index-to-insert [5 3 20 3] 5) 2) "should return 2")
  (is (= (get-index-to-insert [2 20 10] 19) 2) "should return 2")
  (is (= (get-index-to-insert [2 5 10] 15) 3) "should return 3"))