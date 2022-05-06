(ns challenges.exercism.birds)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (into (pop birds) (list (inc (last birds)))))

(defn day-without-birds? [birds]
  (if (some zero? birds) true false))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter #(> % 4) birds)))

(defn odd-week? [birds]
  (if (= birds [1 0 1 0 1 0 1]) true false))
