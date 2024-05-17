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

;;list of string regex - first try
;; (defn fil [s w]
;;   (count (filter #(some #{%} s) w)))
;; (defn solve [s]
;;   (let [alpha "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
;;         up   (into #{} (seq alpha))
;;         low  (into #{} (seq (clojure.string/lower-case alpha)))
;;         nums (range 10)]
;;     (list (fil up s)
;;           (fil low s)
;;           (fil))))
;; Second Try - Final
(defn fil [s w]
  (count (re-seq s w)))

(defn solve [s]
  (list (fil #"[A-Z]" s)
        (fil #"[a-z]" s)
        (fil #"[\d]" s)
        (fil #"[^A-Za-z0-9]" s)))

;;Sum of all
;; (defn sum [& numbers]
;;   (reduce + numbers))
;;or
(def sum +)

;;Two to One
(defn srt [x]
  (apply str (dedupe (sort x))))

(defn longest [s1 s2]
  (if (> (count (srt s1))
         (count (srt s2))) (srt s1) (srt s2)))

;;Character Counter
(defn validate-word [w]
  (doseq [ww (seq (frequencies w))]
    (if (> (val ww) 1) true false)))

;; Populateion
;; (defn nb-year [p0 percent aug p]
;; (let [p0 (+ (* p0 (/ percent 100))
;;    p0 50)]
;;   (while (< p0 p))))

;;1-2-3
;; (defn number [lines]
;;   (for [x lines
;;         y (range 1 (inc (count lines)))]
;;       (format "%d: %s" y x)))
;; (defn number [lines]
;;   (map #(format "%d: %s" % %) lines))
;;(defn number [lines]
;; (doseq [[i x] (map-indexed vector lines)]
;;   (format "%d: %s" i x)))
;; Second Try
;; (defn numbers-1-2-3 [lines]
;;   (for [x (range (count lines))]
;;     (format "%d: %s" (inc x) (nth lines x))))
;;refactor
(defn numbers-1-2-3 [lines]
  (map (partial format "%d: %s") (iterate inc 1) lines))

;; Find Odd
;; (defn find-odd- [xs]
;;   (first (remove nil? (for [[x y] (frequencies xs)] (if (odd? y) x)))))
;; refactor
(defn find-odd [v]
  (ffirst (filter #(odd? (second %)) (frequencies v))))

;; Dupe-Count
;; First
;; (defn dupe-count [text]
;;   (if (empty? text) 0
;;     (count (filter #(> (second %) 1) (frequencies (clojure.string/lower-case text))))))
;; refactor
(defn dupe-count [text]
  (count (filter #(> (second %) 1) (frequencies (clojure.string/lower-case text)))))

;; Bit Count
;; First go
;; (defn count-bits [n]
;;   (apply + (map #(Integer/parseInt %) (clojure.string/split (Integer/toBinaryString n) #""))))
;; Refactor
(defn count-bits [n]
  (Integer/bitCount n))

;; Sum Root
;; (defn d-root [n]
;;   (let [x (reduce + (map #(read-string %) (map str (str n))))]
;;     (if (> (count (str x)) 1) (d-root x) x)))
;; refactor
(defn d-root [n]
  (inc (rem (dec n) 9)))
;; Alternatively (if (pos? n) (inc (mod (dec n) 9)) 0)

;; Persistence - WIP
(defn persistence [n]
  (if (> (count (str n)) 1)
    ;; TODO get count of how many times this ran with a counter
    (let [x (reduce * (map #(read-string %) (map str (str n))))]
      (if (> (count (str x)) 1)
        (persistence x) x)) 0))


(defn f_shortest [words]
  (count (first (sort-by count                              ;;sort by letter count, grab lowest, return letter count
                         (clojure.string/split words #" "))))) ;; split words to seq

(defn j-case [w]
  (map #(str (str/capitalize %)) (clojure.string/split w #" ")))

;; capitalize each first letter of word
;; Attempt #1
(defn j-case [w]
  (str/join (map str/capitalize (str/split w #"\b"))))      ;;Doesn't account for special characters
;; Attempt #2
(defn j-case [w]
  (clojure.string/join "" (map clojure.string/capitalize
                               (re-seq #"\b\w*('['\w]*)*\b" "test test's")))) ;;need to handle sequence




