(ns qi.intervals-test
  (:require [qi.intervals :refer :all]
            [clojure.test :refer :all]))

(deftest disjoint?-test
  (testing "Should return true/false when two intervals are disjoint"
    (is (disjoint? [1 2] [3 4]))
    (is (not (disjoint? [1 3] [2 4])))))

(deftest intersect-test
  (testing "Should return nil if two intervals are disjoint"
    (is (nil? (intersect [1 2] [3 4]))))
  (testing "Should return intersection of two intervals"
    (is (= [2 3] (intersect [1 3] [2 4])))))

(deftest progress-test
  (testing "Should progress to the next candiates"
    (let [xs '([1 3] [2 4])
          ys '([0 2] [3 5])
          xs' xs
          ys' '([3 5])
          [xr yr] (progress xs ys)]
      (is (= xs' xr))
      (is (= ys' yr)))))

(deftest intersection-test
  (testing "Should return empty seq when no intersection is found"
    (is (empty? (intersection '([1 2]) '([3 4])))))
  (testing "Single intervals should return the intersction"
    (is (= '([2 3])
           (intersection '([1 3]) '([2 4])))))
  (testing "Test multiple interval intersection"
    (is (= '([1 2] [3 4])
           (intersection '([1 2] [3 5]) '([0 2] [3 4]))))))
