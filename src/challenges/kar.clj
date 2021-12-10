(ns challenges.kar)

;; You are running a classroom and suspect that some of your students are passing around the answers to multiple choice questions disguised as random strings.
;; Your task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.

;; Example:
;; words = ['cat', 'baby', 'dog', 'bird', 'car', 'ax']
;; string1 = 'tcabnihjs'
;; find_embedded_word(words, string1) -> cat (the letters do not have to be in order)

;; string2 = 'tbcanihjs'
;; find_embedded_word(words, string2) -> cat (the letters do not have to be together)

;; string3 = 'baykkjl'
;; find_embedded_word(words, string3) -> None / null (the letters cannot be reused)

;; string4 = 'bbabylkkj'
;; find_embedded_word(words, string4) -> baby

;; string5 = 'ccc'
;; find_embedded_word(words, string5) -> None / null

;; string6 = 'breadmaking'
;; find_embedded_word(words, string6) -> bird

;; Complexity analysis variables:

;; W = number of words in `words`
;; S = maximal length of each word or string

(def words ["cat" "baby" "dog" "bird" "car" "ax"])
(def string1 "tcabnihjs")
(def string2 "tbcanihjs")
(def string3 "baykkjl")
(def string4 "bbabylkkj")
(def string5 "ccc")
(def string6 "breadmaking")

(defn find_embedded_word [arr string]
  (for [W arr]                                              ;Word from vector => "cat"
    (for [ch W]                                             ;ch char from string => \c
      (apply str (flatten (remove nil? (for [sch string]    ;each in string => \t
                                         (if (= sch ch)
                                           sch))))))))

(defn find_embedded_word_test [arr string]
  (for [W arr]                                              ;Word from vector => "cat"
    (flatten (for [ch W]                                    ;ch char from string => \c
               (if (= W (apply str (flatten (remove nil? (for [sch string] ;each in string => \t
                                                           (if (= sch ch)
                                                             sch))))))
                 W)))))

(println (find_embedded_word words string1))
(println (find_embedded_word_test words string1))

;; (flatten '((\c) (\a) (\t))) ;=> (\c \a \t)
;; ;((\c) (\a) (\t))

;; => (\c \a \t)
;; (apply str (flatten '((\c) (\a) (\t)))) ;> "cat"
;; (\c \a \t) ;> "cat"
;; ((c) (a) (t)) => "cat"
;(println (= (flatten '((\c) (\a) (\t)))
;            "cat"))
;
;(println (apply str(flatten '((\c) (\a) (\t)))))
;
;(deseq '(\c \a \t))