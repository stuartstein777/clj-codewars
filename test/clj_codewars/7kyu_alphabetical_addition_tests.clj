(ns clj-codewars.7kyu-alphabetical-addition-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.7kyu-alphabetical-addition :refer :all]))

(deftest alphabetical-addition-tests
  (testing "Testing for [\\a \\b \\c]" (is (= (add-letters [\a \b \c]) \f)))
  (testing "Testing for [\\z]" (is (= (add-letters [\z]) \z)))
  (testing "Testing for [\\a \\b]" (is (= (add-letters [\a \b]) \c)))
  (testing "Testing for [\\c]" (is (= (add-letters [\c]) \c)))
  (testing "Testing for [\\z \\a]" (is (= (add-letters [\z \a]) \a)))
  (testing "Testing for [\\y \\c \\b]" (is (= (add-letters [\y \c \b]) \d)))
  (testing "Testing for []" (is (= (add-letters []) \z))))
