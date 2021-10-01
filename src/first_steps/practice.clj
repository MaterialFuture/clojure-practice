(ns first-steps.practice
  (:gen-class))

(defn error-message [severity]
  (str "Error Message: Severity - "
       (cond
         (= severity :mild) "Mild, look at logs"
         (= severity :high) "High, contact the DA"
         (= severity :important) "Important, you must fix this now!"
         :else "No severity recognized.")))

(def address-data
  "example hash map of address data"
  {:address
   {:street  "5555 BB Drive"
    :zip     "56234"
    :state   "Oregon"
    :country "United States"}})

(def user-data
  {:id 10000234
   :name {:first "John"
          :last "Doe"}
   :username "jdoe1234"
   :email "jdoe.1234@thing"})

(defn return-user-data [& args]
  "Pretty print user data"
  (if (and (some? user-data)
           (some? address-data)) ;Check that it exists
    (println (str "Name: " (str (get-in user-data [:name :first])
                                " "
                                (get-in user-data [:name :last]))))))

(defn x-error-message
  ([severity]
   (str "Error Message: Severity - "
        (cond
          (= severity :mild) "Mild, look at logs"
          (= severity :high) "High, contact the DA"
          (= severity :important) "Important, you must fix this now!"
          :else "No severity recognized.")))
  ([]
   (println "No severity here, carry on...")))

(defn tell-me [& args]
  (if (some? args)
    (str args)))

(tell-me "something")

(defn gimme-first [[list]]
  "Prints first item in list using the [[]] parameter"
  list)

(gimme-first ["first-item" "second-item" "third-item"])

(defn user-name-input-test [{fst :first lst :last}]
  (println (str "First name: " fst))
  (println (str "Last name: " lst)))
;; This is similar to a let in Lisp
;; ie (let ((fst fst) (lst lst)
;;            ...)

;; Better, cleaner method
(defn user-name-input [{:keys [first last]}]
  (println (str "First name: " first))
  (println (str "Last name: " last)))
;; As long as the key name matches the mapped variable

;; Anon functions λ
(def anon-function (fn [x] (* 5 32 x)))
  ;((fn [x] (* 5 32 x)) 20)
;; Basically just a nested function

;; Recursion
(defn recur-inc
  ([]
   (recur-inc 0))
  ([iter]
   (println iter)
   (if (> iter 5)
     (println "Done!")
     (recur-inc (inc iter)))))

(def score-data [5 7 9 8 6])
(def name-data ["John" "Peter" "Jim" "John" "Smith"])
(defn create-user-data [score name]
  {:name  name
   :score score})

(def full-team-data (map create-user-data score-data name-data))
;; Get Names
(map :name full-team-data)
;; Get team data of scores only greater than 6
(filter #(> (:score %) 6) full-team-data)

(defn -main [& args]
  (return-user-data)
  (error-message :high)
  (x-error-message :mild)
  (anon-function 13) ;=> 2080
  ;; Another shorthand for Anon Function
  (#(* % 3) 8)

  (println "Hello, world!"))