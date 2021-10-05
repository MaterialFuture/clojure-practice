(ns challenges.14e.05-fizzbuzz)
;; Fizzbuzz, aka. the sub 80 IQ filter

(defn fizzbuzz [max]
  (for [x (range max)]
    (cond
      (zero? (mod x 15)) "fizzbuzz"
      (zero? (mod x 5)) "buzz"
      (zero? (mod x 3)) "fizz"
      :else x)))
;Note: initially forgot the else, still used to CL

(defn run-test [& args]
  (if (= (fizzbuzz 20)
         '("fizzbuzz" 1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz" 16 17 "fizz" 19))
    "Passed"
    "Failed"))