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
