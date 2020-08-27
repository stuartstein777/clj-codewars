(ns clj-codewars.5kyu-N00bify-English-to-n00b-Translator
  (:require [clojure.string :as str]))

;;
;
; The internet is a very confounding place for some adults. Tom has just joined an online forum and is trying to
; fit in with all the teens and tweens. It seems like they're speaking in another language! Help Tom fit in by
; translating his well-formatted English into n00b language.
;
; The following rules should be observed:
;
;  * "to" and "too" should be replaced by the number 2, even if they are only part of a word (E.g. today = 2day)
;  * Likewise, "for" and "fore" should be replaced by the number 4
;  * Any remaining double o's should be replaced with zeros (E.g. noob = n00b)
;  * "be", "are", "you", "please", "people", "really", "have", and "know" should be changed to "b", "r", "u",
;    "plz", "ppl", "rly", "haz", and "no" respectively (even if they are only part of the word)
;  * When replacing words, always maintain case of the first letter unless another rule forces the word to all
;    caps.
;  * The letter "s" should always be replaced by a "z", maintaining case
;  * "LOL" must be added to the beginning of any input string starting with a "w" or "W"
;  * "OMG" must be added to the beginning (after LOL, if applicable,) of a string 32 characters1 or longer
;  * All evenly numbered words2 must be in ALL CAPS (Example: Cake is very delicious.
;    becomes Cake IZ very DELICIOUZ)
;  * If the input string starts with "h" or "H", the entire output string should be in ALL CAPS
;  * Periods ( . ), commas ( , ), and apostrophes ( ' ) are to be removed
;  * 3-A question mark ( ? ) should have more question marks added to it, equal to the number of words2 in the
;    sentence (Example: Are you a foo? has 4 words, so it would be converted to r U a F00????)
;  * 3-Similarly, exclamation points ( ! ) should be replaced by a series of alternating exclamation points and
;    the number 1, equal to the number of words2 in the sentence (Example: You are a foo! becomes u R a F00!1!1)
;
;   1-Characters should be counted After: any word conversions, adding additional words, and removing punctuation. Excluding: All punctuation and any 1's added after exclamation marks ( ! ). Character count includes spaces.
;   2-For the sake of this kata, "words" are simply a space-delimited substring, regardless of its characters.
;   Since the output may have a different number of words than the input, words should be counted based on the
;   output string.
;
; Example: whoa, you are my 123 <3 becomes LOL WHOA u R my 123 <3 = 7 words
;
; The incoming string will be punctuated properly, so punctuation does not need to be validated.

(def replacements [[#"fore|Fore|FORE|For|for" "4"] [#"to|too|Too|To" "2"] [#"be" "b"] [#"Be" "B"] [#"know" "no"]
                   [#"Have" "Haz"] [#"have" "haz"] [#"people" "ppl"] [#"People" "Ppl"] [#"really" "rly"]
                   [#"Really" "Rly"] [#"Please" "Plz"] [#"please" "plz"]
                   [#"you" "u"] [#"You" "U"] [#"are" "r"] [#"oo|OO|Oo|oO" "00"] [#"s" "z"] [#"S" "Z"]])

(defn lolify [text]
  (if (or (str/starts-with? text "w") (str/starts-with? text "W"))
    (str "LOL " text)
    text))

(defn count-characters [text]
  (count
    (apply str (re-seq #"[\w\s]+" text))))

(defn omgify [text]
  (if (>= (count-characters text) 32)
      (if (str/starts-with? text "LOL")
        (str (subs text 0 4) "OMG " (subs text 4))
        (str "OMG " text))
      text))

(defn word-count [text]
  (count (str/split text #" ")))

(defn remove-punctuation [text]
  (str/replace text #",|\.|\'" ""))

(defn exclam [text]
  (str/replace text #"\!" (apply str (take (word-count text) (cycle "!1")))))

(defn overdo-question-marks [text]
  (str/replace text #"\?" (apply str (repeat (word-count text) "?"))))

(defn capitalize-even-words [text]
  (->> (str/split text #" ")
       (map-indexed (fn [i w] (if (odd? i) (str/upper-case w) w)))
       (str/join " ")))

(defn uppercase-if-starts-h [text]
  (if (or (str/starts-with? text "h") (str/starts-with? text "H"))
    (str/upper-case text)
    text))

(defn n00bify [text]
  (->> (reduce (fn [acc i] (str/replace acc (first i) (second i))) text replacements)
       (lolify)
       (remove-punctuation)
       (omgify)
       (exclam)
       (overdo-question-marks)
       (capitalize-even-words)
       (uppercase-if-starts-h)))