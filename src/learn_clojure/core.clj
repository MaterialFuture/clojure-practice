(ns learn-clojure.core
  (:gen-class))

(def the-world "world!")

(defn hello-x
  "Prints Hello x to the REPL."
  [& args]
  (if (nil? args)
    (println "Hello World!")
    (println "Hello, " args)))

(defn hello-world
  "Simply prints hello world"
  [& args]
  (str "Hello, " the-world))

;; Conditionals
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

;; Hashes
(def test-name-hash
  {:name
   {:name-first "Doug"
    :name-last "Walker"}
   :username "NostalgiaCritic"})

(defn test-hashes
  "Show how to access hashes"
  [& args]
  (println "Name: "
           (get-in test-name-hash [:name :name-first])
           (get-in test-name-hash [:name :name-last]))
  (println "Username: " (test-name-hash :username)))

;; Vectors
(def new-vector
  ["Death Stranding"
   "Horizon Zero Dawn"
   "God of War"])

(defn test-vector
  "Show how to access vectors"
  [& args]
  (println new-vector)
  (println (conj new-vector "Uncharted 4")))

;; Lists
(def new-lists
  '(1 2 3 4))

(defn test-lists
  "Show how to access lists"
  [& args]
  (println (conj new-lists "Some List")))

(defn -main
  "Run all the functions!"
  [& args]
  (hello-world)
  (hello-x "User")
  (test-conditionals 3)
  (test-vector)
  (test-hashes)
  (test-lists))
