(ns challenges.14e.05-fizzbuzz)
;; Fizzbuzz, aka. the sub 80 IQ filter

(defn fizzbuzz [max]
  (for [x (range max)]
    (cond
      (zero? (mod x 15)) "fizzbuzz"
      (zero? (mod x 5)) "buzz"
      (zero? (mod x 3)) "fizz"
      :else x)))
;Note: initially forgot the :else, still used to CL

(defn run-test [& args]
  (if (= (fizzbuzz 20)
         '("fizzbuzz" 1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz" 16 17 "fizz" 19))
    "Passed"
    "Failed"))

(defn fizzbuzz-loop-recur [max]
  "Utilizing recursion with a loop"
  (loop [x 1]
    (when (< x max)
      (cond (zero? (mod x 15)) (println "fizzbuzz")
            (zero? (mod x 5)) (println "fizz")
            (zero? (mod x 3)) (println "buzz")
            :else (println x))
      (recur (inc x)))))

(defn fizzbuzz-recur [start max]
  "Utilizing recursion within a function"
  (when (< start max)
    (cond (zero? (mod start 15)) (println "fizzbuzz")
          (zero? (mod start 5)) (println "fizz")
          (zero? (mod start 3)) (println "buzz")
          :else (println start))
    (fizzbuzz-recur (inc start) max)))
;;(fizzbuzz-recur 1 100)

(defn test-func [x]
  (for [y x
        :when (and (> y 1)
                   (not nil))]
    y))

(defn test-func-recur [asd]
  ...
  (test-func-recur (inc asd)))

(prn (dedupe (test-func '[1 2 3 4])))