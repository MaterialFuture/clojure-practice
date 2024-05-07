(ns challenges.14e.09-lovecalc)

(require '[clojure.string :as str])

;; Input = (sum (int name1) (int name2)) ...

;; Turn name string into a value based on ASCII
(defn calcname [n] "Give each name a value based on ASCII values of each character."
  (reduce + (into '() (map int (seq n)))))                      ;;Turn string into list of ints from ASCII values

;; Output
(defn calclove [n1 n2] "Compare both names and see the 'love' score."
  (compare (calcname n1)                                    ;; WIP - compare values using some arbitrary metric
           (calcname n2)))

;; Extra - Create a hashmap of all the data for debugging
;; Extra 2 - Create a debugging log or print data in REPL
;; {:name "test", :seq (\t \e \s \t), :ints (116 101 115 116), ...}