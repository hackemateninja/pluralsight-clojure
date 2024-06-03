(ns pluralsight.core-test
  (:require [clojure.test :refer :all]
            [pluralsight.core :refer :all]
            [pluralsight.test :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest division-test
			(testing "dividing by one"
				(is (= (/ 1 1) 1)))) 

(deftest multiplication-test
			(testing "multiplying one by one"
				(is (= (* 1 1) 1)))) 

(deftest math-works-test
			(testing "all of test before"
				(division-test)
 				(multiplication-test))) 

(deftest last-four-test
			(testing "failed to extrat last four of serial number"
				(is (= (last-four 12345678) "5678")))) 