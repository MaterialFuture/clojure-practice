(ns learn-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "Lets Test conditionals...")
  (let [x 3]
    (cond
      (= x 3) (println "X is Three!")
      :else (println "X isn't three"))
    (if (= x 3)
      (println "X is three!")
      (println "X isn't three"))))
