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

(defn slope-crashes [right down data]
  (->> (range 1 (/ (count data) down))
       (filter
        (fn [i]
          (let [row (* down i)
                col (* right i)
                line (nth data row)]
            (when (= \# (nth line col))
              true))))
       count))

(defn part1 []
  (slope-crashes 3 1 input))

(defn part2 []
  (* (slope-crashes 1 1 input)
     (slope-crashes 3 1 input)
     (slope-crashes 5 1 input)
     (slope-crashes 7 1 input)
     (slope-crashes 1 2 input)))
