(ns challenges.codegame.ascii
  (:require [clojure.string :as str])
  (:gen-class))

;; First Attempt
(defn output [msg] (println msg) (flush))

(def alpha "ABCDEFGHIJKLMNOPQRSTUVWXYZ?")
(defn remove-others [w]
  (apply str (str/replace w #"[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\`\~]" "?")))

(defn -main [& args]
  (let [W (Integer/parseInt (read-line))
        H (Integer/parseInt (read-line))
        T (str/upper-case(remove-others (read-line)))
        ascii (read-line)]

    (let [astr (map (fn [i] (partition W i)) (clojure.string/split-lines ascii))]
      (output (apply str (first (first astr)))))))


;; Second
(defn -main [& args]
  (let [read-int (Integer/parseInt (read-line))
        width (read-int)
        height (read-int)
        text (read-line)
        rows (repeatedly height read-line)
        indices (map (fn [letter] (let [i (.indexOf "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                    (Character/toUpperCase (int letter)))]
                                    (if (< i 0) 26 i)))
                     text)]
    (doseq [row rows]
      (doseq [index indices]
        (print (subs row
                     (* width index)
                     (* width (+ index 1)))))
      (println))))