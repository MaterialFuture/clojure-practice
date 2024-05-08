;; Project Euler
;; Source: https://projecteuler.net/

(ns challenges.14e.07-euler)

(defn euler01 [n]
  "Find the sum of all the multiples of 3 or 5 below 1000."
    (reduce + (remove nil? (for [x (range n)]
                                (cond (zero? (mod x 5)) x
                                      (zero? (mod x 3)) x)))))