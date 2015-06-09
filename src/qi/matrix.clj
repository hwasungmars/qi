(ns qi.matrix)

(defn peel-layer
  "Given a matrix peel the outer layer and return it with the inner layer."
  [matrix]
  (let [first-tuple (butlast (first matrix))
        second-tuple (map last (butlast matrix))
        third-tuple (reverse (rest (last matrix)))
        forth-tuple (reverse (map first (rest matrix)))
        middle #(rest (butlast %))
        kernel (map middle (middle matrix))]
    [[first-tuple second-tuple third-tuple forth-tuple] kernel]))

(defn add-layer
  "Given a layer and a matrix kernel, add the layer on."
  [[first-tuple second-tuple third-tuple forth-tuple] kernel]
  (let [first-row (concat first-tuple [(first second-tuple)])
        last-row (concat [(first forth-tuple)] (reverse third-tuple))
        middle-first-column (map vector (reverse (rest forth-tuple)))
        middle-last-column (map vector (rest second-tuple))
        middle-rows (map concat middle-first-column kernel middle-last-column)]
    (concat [first-row] middle-rows [last-row])))

(defn rotate-layer
  "Given a layer, rotate it."
  [[first-tuple second-tuple third-tuple forth-tuple]]
  [second-tuple third-tuple forth-tuple first-tuple])

(defn rotate-matrix
  "Given a matrix layer rotate 90 degrees."
  [matrix]
  (if (>= 1 (count matrix))
    matrix
    (let [[layer kernel] (peel-layer matrix)
          rotated-layer (rotate-layer layer)]
      (add-layer rotated-layer (rotate-matrix kernel)))))

