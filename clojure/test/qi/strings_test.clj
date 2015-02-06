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
