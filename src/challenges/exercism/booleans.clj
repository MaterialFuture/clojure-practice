(ns challenges.exercism.booleans)

(defn can-fast-attack? [knight-awake?]
  (not knight-awake?))

(defn can-spy? [knight-awake? archer-awake? prisoner-awake?]
  (or knight-awake?
      archer-awake?
      prisoner-awake?))

(defn can-signal-prisoner? [archer-awake? prisoner-awake?]
  (and (not archer-awake?)
       prisoner-awake?))

(defn can-free-prisoner? [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (or (and (not knight-awake?)
           (not archer-awake?)
           prisoner-awake?)
      (and (not archer-awake?) ;If Annalyn has her pet dog with her she can rescue the prisoner if the archer is asleep
           dog-present?)))
