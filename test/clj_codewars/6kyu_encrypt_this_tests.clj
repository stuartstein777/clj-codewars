(ns clj-codewars.6kyu-encrypt-this-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-encrypt-this :refer :all]))

(deftest encrypt-this-tests
  (is (= "72olle" (encrypt-this "Hello")))
  (is (= "103doo" (encrypt-this "good")))
  (is (= "104olle 119drlo" (encrypt-this "hello world")))
  (is (= "65 119esi 111dl 111lw 108dvei 105n 97n 111ka" (encrypt-this "A wise old owl lived in an oak")))
  (is (= "84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp" (encrypt-this "The more he saw the less he spoke")))
  (is (= "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare" (encrypt-this "The less he spoke the more he heard")))
  (is (= "87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri"
      (encrypt-this "Why can we not all be like that wise old bird")))
  (is (= "84kanh 121uo 80roti 102ro 97ll 121ruo 104ple" (encrypt-this "Thank you Piotr for all your help"))))