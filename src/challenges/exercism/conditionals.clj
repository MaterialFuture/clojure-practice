(ns challenges.exercism.conditionals)

;; Cars Production
(defn production-rate [s]
  (double (* (/ (* 221 s)
               100)
            (cond (> s 9) 77
                  (= s 9) 80
                  (> s 4) 90
                  (> s 0) 100
                  :else 0))))

(defn working-items [s]
  (int (/ (production-rate s)
          60)))