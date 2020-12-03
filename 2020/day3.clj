(ns day3
  (:require [clojure.string :as string]
            [clojure.java.io :as io]))

(defn parse-line
  [line]
  (mapcat identity (repeat line)))

(defn parse-input [filename]
  (->> filename
       (io/reader)
       (line-seq)
       (map parse-line)
       vec))

(def sample (parse-input "day3-sample.txt"))
(def input (parse-input "day3.txt"))

(def tree \#)

(defn slope-crashes [right down data]
  (count
   (for [i (range 1 (/ (count data) down))
         :let [row (* down i)
               col (* right i)
               line (nth data row)]
         :when (= tree (nth line col))]
     :crash)))

(defn part1 []
  (slope-crashes 3 1 input))

(defn part2 []
  (* (slope-crashes 1 1 input)
     (slope-crashes 3 1 input)
     (slope-crashes 5 1 input)
     (slope-crashes 7 1 input)
     (slope-crashes 1 2 input)))
