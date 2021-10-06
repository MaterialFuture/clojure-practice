(ns challenges.14e.06-rps)
;; Rock, Paper, Scissors

(defn create-hand [& args]
  "The basis of what makes"
  (let [hands ["Rock" "Paper" "Scissors"]]
    (nth (shuffle hands) 1)))

(defn rock-paper-scissors [hand]
  "It so far only works for rock"
  (let [possible-hands ["Rock" "Paper" "Scissors"]]
    (let [cpu-hand (nth (shuffle possible-hands) 1)]
      (cond
        (and (= hand "Rock")
             (= cpu-hand "Rock")) "Tie"
        (and (= hand "Rock")
             (= cpu-hand "Paper")) "You Lose..."
        (and (= hand "Rock")
             (= cpu-hand "Scissors")) "You Win!"))))

;Notes: by putting create-hand in a lambda it eliminates the need to the function
;Nested lets are useful when working with immutable data