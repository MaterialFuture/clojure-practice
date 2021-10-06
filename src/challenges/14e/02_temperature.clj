(ns challenges.14e.02-temperature)
;; Temperature conversion

(defn conversion-temperature [temp unit]
  (cond
    (or (= unit "F")
        (= unit "f")) (str (* (- temp 32) 0.56) " C")
    (or (= unit "C")
        (= unit "c")) (str (+ (* temp 1.8) 32) " F")))

;; Bonus, include more conversions
;; Rankine and Reaumur and Kelvin
;;Celsius
(defn c->f [temp]
  (/ 1.8 (- temp 32)))
(defn c->rankine [temp]
  (* 1.8 (+ temp 273.15)))
(defn c->reaumer [temp]
  (* temp 0.8))
(defn c->k [temp]
  (+ temp 273.15))

;;Fahrenheit
(defn f->c [temp]
  (* (- temp 32) 0.56))
(defn f->rankine [temp]
  (+ temp 459.67))
(defn f->reaumur [temp]
  (* (- temp 32) (/ 4 9)))
(defn f->k [temp]
  (* (+ temp 459.67) (/ 5 9)))

;;Rankine
(defn rankine->f [temp]
  (- temp 459.67))
(defn rankine->c [temp]
  (* (- temp 491.67) (/ 5 9)))
(defn rankine->reaumur [temp]
  (* (- temp 491.67) (/ 4 9)))
(defn rankine->k [temp]
  (* (/ 5 9) temp))

;;Reaumur
(defn reaumur->c [temp]
  (/ temp 0.8))
(defn reaumur->f [temp]
  (+ (* temp 2.25) 32))
(defn reaumur->rankine [temp]
  (+ (* temp 2.2500) 491.67))
(defn reaumur->k [temp]
  (+ (* (/ 5 4) temp) 273.15))

;;Kelvin
(defn k->c [temp]
  (- temp 273.15))
(defn k->f [temp]
  (+ 273(* (/ 5 9) temp)))
(defn k->rankine [temp]
  (* temp 1.8))
(defn k->reaumur [temp]
  (* (/ 4 5) (- temp 273.15)))

;; Tests, just the basics
(defn run-tests [& args]
  (println "Running tests...")
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

(run-tests)