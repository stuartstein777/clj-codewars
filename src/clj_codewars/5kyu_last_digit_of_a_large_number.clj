(ns clj-codewars.5kyu-last-digit-of-a-large-number)

; cycles stores the repeating patterns of successive powers for 0 to 9
; cycle-idx stores which of the repeating patterns to use. Get this by getting the last digit of the base
; final-digits-cycle is the actual pattern.
; e.g. for base = 1513513, exponent = 5515156156156
; the last digit of base would be 3 so final-digits-cycle would be [3 9 7 1]
; then get the remainder of elements left over from the pattern, we get this by taking the remainder of
; the exponent divided by the length of the pattern cycle.
; so for  5515156156156 and pattern [3 9 7 1] which has length of 4, we would get 0 remainder as
; 5515156156156 / 4 = x remainder 0
; since there is no remainder then the last digit has to be the last digit in the pattern.
; if it's not zero, then get the remainder'th element in the cycle pattern (decremented to account for
; starting from 0)
(let [cycles [[0] [1] [2 4 8 6] [3 9 7 1] [4 6] [5] [6] [7 9 3 1] [8 4 2 6] [9 1]]
      b 1513513
      ex 5515156156156
      cycle-idx (int (mod b 10))
      final-digits-cycle (nth cycles cycle-idx)
      cycle-cnt-remainder (rem ex (count final-digits-cycle))]
  (if (zero? cycle-cnt-remainder)
    (last final-digits-cycle)
    (nth final-digits-cycle (dec cycle-cnt-remainder))))