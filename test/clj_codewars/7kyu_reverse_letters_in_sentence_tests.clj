(ns clj-codewars.7kyu-reverse-letters-in-sentence-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-reverse-letters-in-sentence :refer :all]))

(deftest sample-tests
  (are [inp exp] (= (reverser inp) exp)
                 "How now brown cow" "woH won nworb woc"
                 "racecar." ".racecar"
                 "Hi mom!" "iH !mom"
                 " go away " " og yawa "
                 "I like noodles" "I ekil seldoon"
                 "The red pen wrote on the wall" "ehT der nep etorw no eht llaw"
                 "Green trucks drive fast" "neerG skcurt evird tsaf"
                 "Pink trucks drive slow" "kniP skcurt evird wols"
                 "Be happy" "eB yppah"))

