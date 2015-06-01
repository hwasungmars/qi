(ns qi.strings-test
  (:require [clojure.test :refer :all]
            [qi.strings :refer :all]))

(deftest unique-test
  (testing "Base cases."
    (is (= true (unique? "")))
    (is (= true (unique? "a"))))
  (testing "Unique and non unique string."
    (is (= true (unique? "Hwasung")))
    (is (= false (unique? "aa")))))

(deftest reverse-c-test
  (testing "Base cases."
    (is (= "\\*" (reverse-c "\\*")))
    (is (= "a\\*" (reverse-c "a\\*"))))
  (testing "Interesting cases."
    (is (= "C-style\\*" (reverse-c "elyts-C\\*")))))
