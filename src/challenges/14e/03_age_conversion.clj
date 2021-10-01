(ns challenges.14e.03-age-conversion)

;; 03 Age Conversion
;; Converting your age (years) to seconds

(defn years->seconds [years]
  (* years 31536000))

;; Bonus - Other time conversion methods
(defn years->months [years]
  (* years 12))
(defn years->days [years]
  (* years 365))
(defn months->seconds [months]
  (* months 2628000))
(defn days->seconds [days]
  (* days 86400))

;; Going upward
(defn seconds->minutes [seconds]
  (/ seconds 60))
