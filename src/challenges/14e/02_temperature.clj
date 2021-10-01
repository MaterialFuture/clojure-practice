(ns challenges.14e.02-temperature)

(defn conversion-temperature [temp unit]
  (cond
    (or (= unit "F")
        (= unit "f")) (str (* (- temp 32) 0.56) " C")
    (or (= unit "C")
        (= unit "c")) (str (+ (* temp 1.8) 32) " F")))

;; Bonus, create more specific functions
(defn f->c [temp]
  (* (- temp 32) 0.56))

(defn c->f [temp]
  (+ (* temp 1.8) 32))

;; Tests
(defn run-tests [& args]
  (do
    (if (= (conversion-temperature 100 "c")
           "212.0 F")
      (println "Passed")
      (println "Failed"))
    (if (= (conversion-temperature 0 "c")
           "32.0 F")
      (println "Passed")
      (println "Failed"))
    (if (= (conversion-temperature 120 "F")
           "49.28 C")
      (println "Passed")
      (println "Failed"))
    (if (= (conversion-temperature 83 "f")
           "212.0 F")
      (println "Passed")
      (println "Failed"))

    ;; Bonus Stuff
    (if (= (c->f 83)
           212.0)
      (println "Passed")
      (println "Failed"))
    (if (= (f->c 100)
           38.080000000000005)
      (println "Passed")
      (println "Failed"))))
