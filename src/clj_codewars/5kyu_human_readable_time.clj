(ns clj-codewars.5kyu-human-readable-time)

;; Human Readable Time
; Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable
; format (HH:MM:SS)
;
;    HH = hours, padded to 2 digits, range: 00 - 99
;    MM = minutes, padded to 2 digits, range: 00 - 59
;    SS = seconds, padded to 2 digits, range: 00 - 59
;
; The maximum time never exceeds 359999 (99:59:59)
;
; You can find some examples in the test fixtures.

(defn human-readable [x]
  (let [hours (quot x 3600)
        mins (quot (- x (* 3600 hours)) 60)
        secs (- x (* hours 3600) (* mins 60))]
    (str (format "%02d:%02d:%02d" hours mins secs))))