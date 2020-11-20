(ns clj-codewars.7kyu-remove-anchor-from-url
  (require [clojure.string :as str]))

;; Remove anchor from URL
;
; Complete the function/method so that it returns the url with anything after the anchor (#) removed.
; Examples
;
; // returns 'www.codewars.com'
; removeUrlAnchor('www.codewars.com#about')
;
; // returns 'www.codewars.com?page=1'
; removeUrlAnchor('www.codewars.com?page=1')

(defn remove-url-anchor [url]
  (let [anchor-location (str/index-of url "#")]
    (if (nil? anchor-location)
      url
      (subs url 0 (str/index-of url "#")))))