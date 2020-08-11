(ns learn-clojure.core
  (:gen-class))


(defn hello-world
  "Prints Hello x to the REPL."
  [& args]
  (if (nil? args)
    (println "Hello World!")
    (println-str "Hello, " args)))

(defn test-conditionals
  "Prints conditional statements for arguments provided."
  [x]
  (println "Lets Test conditionals...")
    (cond
      (= x 3) (println "X is Three!")
      :else (println "X isn't three"))
    (if (= x 3)
      (println "X is three!")
      (println "X isn't three")))

(defn -main
  "Run all the functions!"
  [& args]
  (hello-world)
  (hello-world "User")
  (test-conditionals 3))
