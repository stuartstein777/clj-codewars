(ns clj-codewars.6kyu-extract-file-name-tests
  (:require [clojure.test :refer :all]
            [clj-codewars.6kyu-extract-file-name :refer :all]))

(deftest example-tests
  (is (= (extract-file-name "1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION") "FILE_NAME.EXTENSION"))
  (is (= (extract-file-name "1_FILE_NAME.EXTENSION.OTHEREXTENSIONadasdassdassds34") "FILE_NAME.EXTENSION")))