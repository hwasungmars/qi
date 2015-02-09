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
