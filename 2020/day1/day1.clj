(ns day1
  (:require [clojure.java.io :as io]))

(def input
  (->> "input1"
       (io/reader)
       (line-seq)
       (map #(Integer/parseInt %))
       vec))

(def part1
  (let [[x y] (first (filter
                      (fn [[a b]]
                        (and (not= a b)
                             (= 2020 (+ a b))))
                      (for [a input, b input]
                        [a b])))]
    (* x y)))

(def part2
  (let [[x y z] (first (filter
                      (fn [[a b c]]
                        (and (= 3 (count (distinct [a b c])))
                             (= 2020 (+ a b c))))
                      (for [a input, b input, c input]
                        [a b c])))]
    (* x y z)))
