(ns clj-codewars.6kyu-errors-histogram-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-errors-histogram :refer :all]))

(defn do-test-histogram [s expect]
  (let [actual (hist s)]
    (is (= actual expect))))

(deftest a-test1-histogram
  (testing "hist"
    (do-test-histogram "uuaaaxbbbbyyhwawiwjjjwwxymzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
                       "u  2     **\rw  5     *****\rx  2     **\rz  31    *******************************")
    (do-test-histogram "tpwaemuqxdmwqbqrjbeosjnejqorxdozsxnrgpgqkeihqwybzyymqeazfkyiucesxwutgszbenzvgxibxrlvmzihcb"
                       "u  3     ***\rw  4     ****\rx  6     ******\rz  6     ******")
    (do-test-histogram "aaifzlnderpeurcuqjqeywdq" "u  2     **\rw  1     *\rz  1     *");
    (do-test-histogram "sjeneccyhrcpfvpujfaoaykqllteovskclebmzjeqepilxygdmzvdfmxbqdzubkzturnuqxsewrwgmdfwgdx"
                       "u  4     ****\rw  3     ***\rx  4     ****\rz  4     ****")
    (do-test-histogram "kwlrizwobqwbtlfwwbnt" "w  5     *****\rz  1     *")))
