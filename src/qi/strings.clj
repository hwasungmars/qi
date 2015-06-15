(ns qi.strings)

(defn unique?
  "Check whether all the chars in a string is unique."
  [string]
  (def short-sighted-iterator
    (fn [last-seen incoming]
      (cond (empty? incoming) true
            (= last-seen (first incoming)) false
            :else (short-sighted-iterator (first incoming) (rest incoming)))))
  (let [sorted (sort string)]
    (short-sighted-iterator nil sorted)))

(defn reverse-c
  "Reverse C-style strings.

  For example, 'C-style\\*' -> 'elyts-C\\*'.
  "
  [string]
  (def reverser
    (fn [x]
      (if (= "\\*" x) ""
        (let [[xfirst & xrest] x]
          (str (reverser (apply str xrest)) xfirst)))))
  (str (reverser string) "\\*"))

(defn simple-compress
  "Implement a method to perform basic string compression using the counts of repeated chars.

  Example: aabcccccaaa -> a2b1c5a3
  "
  [uncompressed]
  (let [partitions (partition-by identity uncompressed)
        ;; ([\a 2] [\b 1] [\c 5] [\a 3])
        key-counts (map (fn [x] [(first x) (count x)]) partitions)
        ;; ("a2" "b1" "c5" "a3")
        string-seg (map #(apply str %) key-counts)]
    (apply str string-seg)))

(defn rotation?
  "Given two strings check whether they are a rotation of the other using substring call."
  [x y]
  (if (not (= (count x) (count y)))
    false
    (let [double-x (str x x)
          double-y (str y y)]
      (and (.contains double-x y) (.contains double-y x)))))
