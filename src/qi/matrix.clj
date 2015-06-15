(ns qi.matrix
  (:require  [clojure.math.combinatorics :as combo]))

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

(defn zero-rows
  "Given a matrix and a index, zero that row."
  [matrix index]
  (let [dim (count matrix)
        zero-row (into [] (repeat dim 0))]
    (assoc matrix index zero-row)))

(defn zero-columns
  "Given a matrix and a index, zero that column."
  [matrix index]
  (map #(assoc % index 0) matrix))

(defn zero-element?
  "Given a matrix and a index, zero that row column if it is zero."
  [matrix i j]
  (let [elem (.get (.get matrix i) j)]
    (zero? elem)))

(defn zero-matrix-if
  "Zeros the column and row if a element is zero in that column or row."
  [matrix]
  (let [dim (count matrix)
        points (combo/cartesian-product (range dim) (range dim))
        zero-elements (filter (fn [[i j]] (zero-element? matrix i j)) points)
        [zero-row zero-column] (reduce (fn [[xset yset] [x y]] [(conj xset x) (conj yset y)])
                                [#{} #{}]
                                zero-elements)
        rows-zeroed (reduce (fn [m i] (zero-rows m i)) matrix zero-row)]
    (reduce (fn [m j] (zero-columns m j)) rows-zeroed zero-column)))
