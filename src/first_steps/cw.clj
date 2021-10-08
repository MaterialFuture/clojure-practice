(ns first-steps.cw)
(use '[clojure.string :only (split join upper-case)])

;; highlow
(def test-string "8 3 -5 42 -1 0 0 -9 4 7 4 -4")

(defn high-low [s]
  (let [nums (sort (map #(Integer/parseInt %) (split s #" ")))]
    (str (first nums) " " (last nums))))

;; vapor
(defn vaporw [s]
  (join "  " (split (upper-case (apply str (split s #" "))) #"")))

;; Sort and add stars
(defn star-sort [arr]
  (if (empty? arr) "" (join "***" (split (first (sort arr)) #""))))

(defn encrypt-this [text]
  (clojure.string/join " "
        (for [ntext (clojure.string/split text #" ")]
          (str (int (first ntext))
               (clojure.string/join "" (reverse (let [n (rest ntext)]
                                                  (let [m1 (take 1 n)
                                                        m2 (drop 1 n)]
                                                    (let [o1 (take 1 (reverse n))
                                                          o2 (drop 1 (reverse n))])))))))))