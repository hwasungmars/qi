(ns qi.intervals)

(set! *warn-on-reflection* true)

(defn disjoint?
  "Are two intervals disjoint?"
  [x y]
  (or (< (last x) (first y))
      (< (last y) (first x))))

(defn intersect
  "Find the intersection of intervals.  If no intersection is found return nil."
  [x y]
  (if (disjoint? x y)
    nil
    [(max (first x) (first y))
     (min (last x) (last y))]))

(defn progress
  "Find the next intervals."
  [[x & xs :as xall] [y & ys :as yall]]
  (if (< (last x) (last y))
    [xs yall]
    [xall ys]))

(defn intersection
  "Given two seqs of intervals find the intersection"
  [xinit yinit]
  (loop [acc []
         [x & xs :as xall] xinit
         [y & ys :as yall] yinit]
    (if (or (empty? xall) (empty? yall))
      acc
      (let [candidate (intersect x y)
            [xall' yall'] (progress xall yall)]
        (if candidate
          (recur (conj acc candidate) xall' yall')
          (recur acc xall' yall'))))))
