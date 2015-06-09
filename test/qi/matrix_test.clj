(ns qi.matrix-test
  (:require [qi.matrix :refer :all]
            [clojure.test :refer :all]))

(deftest rotate-layer-test
  (testing "Layer rotates correctly."
    (is (= [[2] [3] [4] [1]] (rotate-layer [[1] [2] [3] [4]])))))

(deftest rotate-matrix-test
  (testing "Two base cases."
    (is (= [] (rotate-matrix [])))
    (is (= [[2 4] [1 3]] (rotate-matrix [[1 2] [3 4]])))))

