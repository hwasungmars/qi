(ns qi.linked-list)

(defn remove-duplicates
  "Given an unsorted linked list, remove duplicates."
  [seen removed remaining]
  (cond (empty? remaining) removed
        (contains? seen (first remaining)) (remove-duplicates seen removed (rest remaining))
        :else (let [elem (first remaining)]
                (remove-duplicates (conj seen elem) (conj removed elem) (rest remaining)))))

(defn remove-duplicates-inplace
  "The n^2 algorithm by removing in-place."
  [removed remaining]
  (if (empty? remaining)
    removed
    (let [current (first remaining)
          filtered (filter #(not (= current %)) remaining)]
      (remove-duplicates-inplace (conj removed current) filtered))))

(defn- advance
  "Move the linked list head n forward."
  [n linked-list]
  (if (> n 0)
    (advance (- n 1) (rest linked-list))
    linked-list))

(defn- march-until-end
  "March both linked list until the second one reaches the end."
  [longer shorter]
  (if (empty? shorter)
    longer
    (march-until-end (rest longer) (rest shorter))))

(defn k-to-last
  "Find the k-th last element in a linked list."
  [k linked-list]
  (let [forward (advance k linked-list)]
    (first (march-until-end linked-list forward))))
