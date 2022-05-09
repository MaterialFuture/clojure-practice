(ns challenges.exercism.strings
  (:require [clojure.string :as str]))

;; Check Logs

;(defn find-status [string i]
;  (.contains string (nth i status)))

;(def status ["INFO" "WARNING" "ERROR"])
;
;(defn cond-status [string func]
;  (for [s status]
;    (if (.contains string s) ...)))

(defn message [string]
  (-> (last (str/split string #":"))
      (str/trim-newline)
      (str/trim)))

(defn log-level [string]
  (str/lower-case (nth (str/split string #"[\[\]]") 1)))

(defn reformat [string]
  (let [words (str/split string #"[\[\]\:]")]
    (format "%s (%s)"
            (str/trim (str/trim-newline (last words)))
            (str/lower-case (nth words 1)))))