(ns challenges.L-99)
;; Resource https://www.ic.unicamp.br/~meidanis/courses/mc336/2006s2/funcional/L-99_Ninety-Nine_Lisp_Problems.html

;; P01 - MY LAST
(defn my-last [l]
  (last l))
(defn my-last-2 [l]
  (first (reverse l)))

;; P02 - MY-BUT-LAST
(defn my-but-last [l]
  (list (last (drop-last l))
        (last l)))

;; P03 - ELEMENT-AT
(defn element-at [l n]
  (nth l n))

;; P04 - Number of elements
(defn number-of-elements [l]
  (count l))

;; P05 - Reverse List
(defn my-reverse [l]
  (reverse list))

;; P06 - PALINDROME
;(defn palindrome [string]
;  (let [l (clojure.string/split string #"")]
;    (= l (reverse l))))
(defn palindrome [s]
  (= s (reverse s)))

;; P07 - Flatten
(defn flatten [x]
  (flatten x))

;; P08 - COMPRESS - Remove duplicates
(defn compress [x]
  (dedupe x))

;; P09 - Pack duplicates
(defn pack [x]
  (partition-by identity x))

;; p10 - encode-modified
(defn encode [x]
  (map #(list (count %) (first %))
       (partition-by identity x)))

;; p11 - encode-modified
(defn encode-modified [x]
  ;(map #(list (if-not (= 0 (nth 0)) %) ...))
  )