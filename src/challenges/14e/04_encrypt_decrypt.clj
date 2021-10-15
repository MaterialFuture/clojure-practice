(ns challenges.14e.04-encrypt-decrypt)

;; Implementing very very basic encryption, not in any way secure
(defn char->int [ch]
  "Return the ASCII value for the input ch"
  (int (.charAt ch 0)))

(defn str->enc->lazy-sec [string]
  (for [x (for [x (into [] (map #(int %) string))
                :let [y (* x 2)]]
            y)]
    (char x)))

(defn encrypt [string]
  (apply str (for [x (for [x (into [] (map #(int %) string))
                           :let [y (+ x 10)]]
                       y)]
               ;Instead of char there is perhaps another way to convert ascii vals to char
               (char x))))

(defn decrypt [string]
  (apply str (for [x (for [x (into [] (map #(int %) string))
                           :let [y (- x 10)]]
                       y)]
               (char x))))
