(ns clj-codewars.6kyu-parse-html
  (:require [clojure.string :as str]))

;; Parse HTML
; In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is
; to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).
; The input string represents one of the following:
;
;    6-digit hexadecimal - "#RRGGBB"
;    e.g. "#012345", "#789abc", "#FFA077"
;    Each pair of digits represents a value of the channel in hexadecimal: 00 to FF
;
;    3-digit hexadecimal - "#RGB"
;    e.g. "#012", "#aaa", "#F5A"
;    Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.
;
;    Preset color name
;    e.g. "red", "BLUE", "LimeGreen"
; You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell),
; or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the
; corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").
;
;Examples:
;
; (parse-html-color "#80FFA0")   ; => {:r 128 :g 255 :b 160}
; (parse-html-color "#3B7")      ; => {:r 51  :g 187 :b 119}
; (parse-html-color "LimeGreen") ; => {:r 50  :g 205 :b 50 }

(defn preset-colors [_]
  "#32CD32")

(defn parse-hex [h n]
  (let [b (->> (partition n h)
               (map (partial apply str)))]
    {:r (Integer/parseInt (first b) 16)
     :g (Integer/parseInt (second b) 16)
     :b (Integer/parseInt (last b) 16)}))

(defn parse-html-color [hex]
  (cond (and (str/starts-with? hex "#") (= 7 (count hex))) (parse-hex (rest hex) 2)
        (and (str/starts-with? hex "#") (= 4 (count hex))) (parse-hex (str (apply str (repeat 2 (second hex)))
                                                                           (apply str (repeat 2 (nth hex 2)))
                                                                           (apply str (repeat 2 (nth hex 3)))) 2)
        :else (parse-html-color (preset-colors (str/lower-case hex)))))
