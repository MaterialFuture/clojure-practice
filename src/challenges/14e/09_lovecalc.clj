(ns challenges.14e.09-lovecalc)

(require '[clojure.string :as str])

;; Input = (sum (int name1) (int name2)) ...

;; Turn name string into a value based on ASCII
(defn calcname [n]
  "Give each name a value based on ASCII values of each character."
  (reduce + (into '() (map int (seq n)))))                      ;;Turn string into list of ints from ASCII values and sum it up

;; Output
(defn calclove [n1 n2]
  "Compare both names and see the 'love' score."
  (let [y (calcname n2)
        z (+ (calcname n1) (calcname n1))]
      (str "Result: " (format "%.2f" (/ (* y 100.0) z)) "%")))      ;;The math sucks here but it's whatever, doesn't matter

(defn calclove->debug [n1 n2]
  "Compare both names and print results to hashmap for debugging."
  (let [person1 {:name n1
               :vals (map int (seq n1))
               :total (calcname n1)}
        person2 {:name n2
                 :vals (map int (seq n2))
                 :total (calcname n2)}]
  (println person1 "\n" person2 "\n" (calclove n1 n2))))

;; Calc - sum of x and y
;; sum/100
;; compare %

;; Extra - Create a hashmap of all the data for debugging
;; Extra 2 - Create a debugging log or print data in REPL
;; {:name "test", :seq (\t \e \s \t), :ints (116 101 115 116), ...}