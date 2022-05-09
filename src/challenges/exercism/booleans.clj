(ns challenges.exercism.booleans)

(def knight-awake? true)
(def archer-awake? true)
(def prisoner-awake? false)

(defn can-fast-attack? [bool]
  (if (bool) true false))

(defn can-spy? [knight archer prisoner]
  (if (and (false? knight)
          (true? archer)
          (false? prisoner))
    true false))

(defn can-signal-prisoner? [archer prisoner]
  ...)

(defn can-free-prisoner? [knight-awake? archer-awake? prisoner-awake? dog-present?]
  ...)
