(ns challenges.14e.03-age-conversion)

;; 03 Age Conversion
;; Converting your age (years) to seconds

(defn years->seconds [years]
  (* years 31536000))

;; Bonus - Other time conversion methods (assuming non-leap year)
;; years
(defn years->months [years]
  (* years 12))
(defn years->weeks [years]
  (* years 52))
(defn years->days [years]
  (* years 365))
(defn years->hours [years]
  (* years 8760))
(defn years->minutes [years]
  (* years 525600))
;; months omited due to the amount of variation
;;weeks
(defn weeks->days [weeks]
  (* weeks 7))
(defn weeks->minutes [weeks]
  (* weeks 168))
(defn weeks->seconds [weeks]
  (* weeks 86400))

;; Other bonus -> Converting birthdate to get the most accurate assessment of time

;; Going upward
(defn seconds->minutes [seconds]
  (/ seconds 60))
(defn minutes->hours [seconds]
  (/ seconds 60))

(defn run-tests [& args]
  (println "Running tests...")
  (do
    (if (= (years->seconds 21)
           662256000)
      (println "Passed")
      (println "Failed"))
    (if (= (years->seconds 55)
           1734480000)
      (println "Passed")
      (println "Failed"))
    (if (= (seconds->minutes (years->seconds 55))
           28908000)
      (println "Passed")
      (println "Failed"))))

(run-tests)