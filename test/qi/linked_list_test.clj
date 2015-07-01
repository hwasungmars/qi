(ns qi.linked-list-test
  (:require [qi.linked-list :refer :all]
            [clojure.test :refer :all]))

(deftest remove-duplicates-test
  (testing "Base case with nil"
    (is (= [1 2 3] (remove-duplicates #{} [1 2 3] (rest [])))))
  (testing "Unique linked list."
    (is (= [1 2 3] (remove-duplicates #{} [] [1 2 3])))
    (is (= [1 2] (remove-duplicates #{} [] [1 2 2])))))

(deftest remove-duplicates-inplace-test
  (testing "Base case with nil"
    (is (= [1 2 3] (remove-duplicates-inplace [1 2 3] (rest [])))))
  (testing "Unique linked list."
    (is (= [1 2 3] (remove-duplicates-inplace [] [1 2 3])))
    (is (= [1 2] (remove-duplicates-inplace [] [1 2 2])))))

(deftest k-to-late-test
  (testing "Find the k-th element to the last."
    (is (= 3 (k-to-last 2 [1 2 3 4])))
    )
  )
