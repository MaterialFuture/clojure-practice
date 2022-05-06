(ns challenges.exercism.conditionals)

;; Cars Production
(defn production-rate [s]
  (/ (* 221 s)
     (float (/ 100
              (cond (> s 9) 77
                    (= s 9) 80
                    (> s 4) 90
                    (> s 0) 100
                    (= s 0) 0)))))

(defn working-items [s]
  )