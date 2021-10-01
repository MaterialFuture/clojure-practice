(ns challenges.14e.00-namegen)
;; 00 NameGen
;; Create a fake user credentials such as name
;; Bonus for creating an object with random credentials that contains a map of the data including addr and numbers

(def l-name-first '("Jim" "Bill" "Steve" "Joe" "Mark"))
(def l-name-last '("Brown" "Shoemaker" "Billiard" "Poole" "Zimmerman"))

(defn make-user-name [& args]
  (str (rand-nth l-name-first) " "
       (rand-nth l-name-last)))

;; Bonus
(def street-name-list '("Mullberry" "One" "Maple" "NASA" "Bingo"))
(def street-term-list '("Street" "Road" "Lane"))

;; This will
(def user-data
  {:name (str (rand-nth l-name-first) " "
              (rand-nth l-name-last))
   :address (str (apply str (repeatedly (rand-int 6) #(rand-int 10))) " " ;need to check for < 1
                 (str (rand-nth street-name-list) " "
                      (rand-nth street-term-list)))
   :age (rand-int 99)})
