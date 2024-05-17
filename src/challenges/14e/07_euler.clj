;; Project Euler
;; Source: https://projecteuler.net/

(ns challenges.14e.07-euler)

(defn euler01 [n]
  "Find the sum of all the multiples of 3 or 5 below 1000."
    (reduce + (remove nil? (for [x (range n)]
                                (cond (zero? (mod x 5)) x
                                      (zero? (mod x 3)) x)))))

(def fib
  (lazy-cat [0 1] (map + fib (rest fib))))                  ;;creates a sequence of the fibonacci seq

(defn euler02 [n]
  (reduce + (filter even? (take n fib))))                   ;;grabs all the even ints from the seq

