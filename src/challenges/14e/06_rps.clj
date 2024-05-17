(ns challenges.14e.06-rps)
;; Rock, Paper, Scissors

(defn create-hand [& args]
  "The basis of what makes"
  (let [hands ["Rock" "Paper" "Scissors"]]
    (nth (shuffle hands) 1)))

(defn print-hand [a b c]
  (println a "\n" b "\n" c))                                ;;format the print statement

(defn rock-paper-scissors [hand]
  "It so far only works for rock"
  (let [player (clojure.string/capitalize hand)]
   (let [possible-hands ["Rock" "Paper" "Scissors"]]
    (let [cpu-hand (nth (shuffle possible-hands) 1)]
      (cond
        (and (= player "Rock")
             (= cpu-hand "Rock")) (print-hand player cpu-hand "Tie")
        (and (= player "Rock")
             (= cpu-hand "Paper")) (print-hand player cpu-hand "You Lose")
        (and (= player "Rock")
             (= cpu-hand "Scissors")) (print-hand player cpu-hand "You Win!")
        ;;Paper
        (and (= player "Paper")
             (= cpu-hand "Rock")) (print-hand player cpu-hand "You Win!")
        (and (= player "Paper")
             (= cpu-hand "Paper")) (print-hand player cpu-hand "Tie")
        (and (= player "Paper")
             (= cpu-hand "Scissors")) (print-hand player cpu-hand "You lose...")
        ;;Scissors
        (and (= player "Scissors")
             (= cpu-hand "Rock")) (print-hand player cpu-hand "You lose")
        (and (= player "Scissors")
             (= cpu-hand "Paper")) (print-hand player cpu-hand "You Win!")
        (and (= player "Scissors")
             (= cpu-hand "Scissors")) (print-hand player cpu-hand "Tie")
        :else "I don't recognize that... Please try again!")))))

;Notes: by putting create-hand in a lambda it eliminates the need to the function
;Nested lets are useful when working with immutable data

;; Bonus: Add lizard and spock
;; Just adding more conditionals and more to the hands vector

(defn run-test [& args]
  (println (rock-paper-scissors "Rock"))
  (if (= (rock-paper-scissors "Rock")
         (or "Tie"
             "You Lose..."
             "You Win!"))
    "Passed"
    "Failed"))
