(ns challenges.exercism.numbers)

;;Interest Rates
(defn interest-rate [bal]
  (cond (< bal 0) -3.213
        (< bal 1000) 0.5
        (>= bal 5000) 2.475
        :else 1.621))

(defn annual-balance-update [bal]
  (+ bal (/ bal (interest-rate bal))))

(defn amount-to-donate [balance tax-free-percentage]
  )