(ns clj-codewars.7kyu-keep-it-simple-stupid-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-keep-it-simple-stupid :refer :all]))

(deftest KISS-sample-tests
  (testing "word count: 5"
    (is (= (kiss? "Joe had a bad day") "Good work Joe!"))
    (is (= (kiss? "Joe had some bad days") "Good work Joe!"))
    (is (= (kiss? "Joe is having no fun") "Keep It Simple Stupid"))
    (is (= (kiss? "Sometimes Joe cries for hours") "Keep It Simple Stupid")))
  (testing "word count: 6"
    (is (= (kiss? "Joe is having lots of fun") "Good work Joe!"))
    (is (= (kiss? "Joe is working hard a lot") "Keep It Simple Stupid")))
  (testing "word count: 10"
    (is (= (kiss? "Joe listened to the noise and it was an onamonapia") "Good work Joe!"))
    (is (= (kiss? "Joe listened to the noises and there were some onamonapias") "Keep It Simple Stupid"))))


