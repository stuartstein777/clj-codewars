(ns clj-codewars.5kyu-N00bify-English-to-n00b-Translator-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.5kyu-N00bify-English-to-n00b-Translator :refer :all]))

(deftest n00bify-tests
  (is (= (n00bify "Hi, how are you today?")
         "HI HOW R U 2DAY?????"))
  (is (= (n00bify "I think it would be nice if we could all get along.")
         "OMG I think IT would B nice IF we COULD all GET along"))
  (is (= (n00bify "Let's eat, Grandma!")
         "Letz EAT Grandma!1!"))
  (is (= (n00bify "Oodles is a really fun word to say (in my opinion).")
         "OMG 00DLEZ iz A rly FUN word 2 zay (IN my OPINION)"))
  (is (= (n00bify "Before I knew it, 4 people were looking for you!")
         "OMG B4 I KNEW it 4 ppl WERE l00king 4 u!1!1!1!1!1!"))
  (is (= (n00bify "Never try cheating a Kata, friend.")
         "OMG NEVER try CHEATING a KATA friend"))
  (is (= (n00bify "After conversions, this should be!")
         "After CONVERZIONZ thiz ZHOULD b!1!1!"))
  (is (= (n00bify "You know it could be any one of these tests...")
         "OMG U no IT could B any ONE of THEZE teztz"))
  )
