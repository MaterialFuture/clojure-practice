(ns challenges.cw)
(use '[clojure.string :only (split join upper-case)])

;; highlow
(def test-string "8 3 -5 42 -1 0 0 -9 4 7 4 -4")

(defn high-low [s]
  (let [nums (sort (map #(Integer/parseInt %) (split s #" ")))]
    (str (first nums) " " (last nums))))

;; vapor
(defn vaporw [s]
  (join "  " (split (upper-case (apply str (split s #" "))) #"")))

;; Sort and add stars
(defn star-sort [arr]
  (if (empty? arr) "" (join "***" (split (first (sort arr)) #""))))

;; Encryption - WIP
(defn encrypt-this [text]
  (join " " (for [ntext (split text #" ")]
              (str (int (first ntext))
                   (join "" (reverse (let [n (rest ntext)]
                                       (let [m1 (take 1 n)
                                             m2 (drop 1 n)]
                                         (let [o1 (take 1 (reverse n))
                                               o2 (drop 1 (reverse n))])))))))))
(defn squarsm [l]
  (reduce + (for [x l
                  :let [y (* x x)]]
              y)))

(defn average [coll]
  (/ (reduce + coll) (count coll)))

(defn rental [d]
  (let [total (* d 40)]
    (cond
      (>= d 7) (- total 50)
      (>= d 3) (- total 20)
      :else total)))

;; aplha add
;;first
;(defn alpha-add [l]
;(defn add-letters [letters]
;  (char (+ 96 (reduce + (map #(- (int %) 96) letters)))))
;;final
(defn alpha-add [l]
  "Take arr of chars, convert to ints, reduce, convert ints to char"
  (if (empty? l)
    \z
    (loop [x (reduce + (map #(- (int %) 96) l))]
      (if (> x 26)
        (recur (- x 26))
        (char (+ 96 x))))))
;;refactor
;; Took note of someone elses code
(defn alpha-add-ref [l]
  (let [x (mod (reduce + (map #(- (int %) 96) l)) 26)]
    (if (= x 0) \z
                (char (+ 96 x)))))
;;this removes the loop and utilizes lambda
;;removes cond for if

;(alpha-add [\a \b]) ;=> \c

;;salary
;;first
(defn bonus-time [salary bonus]
  (str "$" (if (true? bonus)                                ;no need to test true? if (if) does that already
             (* salary 10)
             salary)))
;;second
(defn bonus-time [salary bonus]
  (str \$ (* salary (if bonus
                      10
                      1))))
;wrap the whole if in the equation we need

;;dvowel
;;first
(def vowel (set "aeiou"))
(defn vowel? [ch]
  (if (vowel ch) true false))

(defn not-vowel? [ch]
  (if (vowel ch) false true))

(defn dvowel [string]
  (join "" (for [s (split string #"")
                 :when (not-vowel? s)]
             s)))
;;second
(defn dvowel [string]
  (clojure.string/replace string #"([aAeEiIoOuU])" ""))
;;alternative
;(.replaceAll string "[aAeEiIoOuU]" "")

;;no zero
(defn nozero [n]
  (clojure.string/replace n #"([^0])0*$" "$1"))

;;get sum of 3 or 5
(defn sum35 [n]
  (reduce + (for [x (range 1 n)
                  :when (or (zero? (mod x 3))
                            (zero? (mod x 5)))]
              x)))

;;tring swap
(defn str-switch [s]
  (join " " (for [x (split s #" ")]
              (if (>= (count x) 5)
                (join "" (reverse x))
                x))))
;;best version I saw
(defn spinw [s]
  (clojure.string/replace s #"\w{5,}" clojure.string/reverse))

(defn wubwub [s]
  (clojure.string/trim
    (clojure.string/replace (clojure.string/replace s #"WUB" " ") #"/\s\s+/g" " ")))

(defn phoney-num [nums]
  (str "(" (apply str (take 3 nums)) ") "
       (apply str (take 3 (drop 3 nums))) "-"
       (apply str (take-last 4 nums))))

(defn phoney-nums-best
  "The best way to format text using apply on an array"
  [nums]
  (apply format "(%d%d%d) %d%d%d-%d%d%d%d" nums))