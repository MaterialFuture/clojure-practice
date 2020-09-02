(ns practice.codewars.recursion101)

;; Method 1
(defn solve
  [a b]
    (cond
      (and (= a 0) (= b 0)) '( a b)
      (and (>= a (* 2 b))) (recur (- a (* 2 b)) b)
      (and (>= b (* 2 a))) (recur a (- b (* 2 a)))
      :else '(a b)))

;; Method 2
(defn solve [a b]
  (if (and (= a 0) (= b 0))
    '(a b)
    (if (>= a (* 2 b))
      (recur (- a (* 2 b)) b)
      (if (>= b (* 2 a))
        (recur a (- b (* 2 a)))
        '(a b)))))
;; This one is dirtier and still doesn't work
