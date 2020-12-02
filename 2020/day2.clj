(ns day2
  (:require [clojure.string :as string]
            [clojure.java.io :as io]))

(defn parse-line
  [line]
  (let [[a b letter password]
        (string/split line #"[\-\: ]+")]
    {:a (Integer/parseInt a)
     :b (Integer/parseInt b)
     :letter (first letter)
     :password password}))

(def input
  (->> "day2.txt"
       (io/reader)
       (line-seq)
       (map parse-line)
       vec))

(defn part1 []
  (->> input
       (filter
        (fn [{:keys [a b letter password]}]
          (let [actual (get (frequencies password) letter 0)]
            (<= a actual b))))
       count))

(defn part2 []
  (->> input
       (filter
        (fn [{:keys [a b letter password]}]
          (let [a-letter (nth password (dec a) \0)
                b-letter (nth password (dec b) \0)]
            (and
             (not= a-letter b-letter)
             (or
              (= a-letter letter)
              (= b-letter letter))))))
       count))
