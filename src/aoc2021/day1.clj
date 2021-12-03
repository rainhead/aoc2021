(ns aoc2021.day1
  (:gen-class))

(defn solve1 [soundings]
  (let [pairs (partition 2 1 soundings)]
    (count (filter (fn [[a b]] (< a b)) pairs))))

(defn solve2 [soundings]
  (let [runs (map (fn [[a b c]] (+ a (+ b c))) (partition 3 1 soundings))]
    (count (filter (fn [[a b]] (< a b)) (partition 2 1 runs)))))

(defn -main
  [input]
  (with-open [rdr (clojure.java.io/reader input)]
    (let [soundings (map (fn [line] (Integer/parseInt line)) (line-seq rdr))]
      (println "Part 1: " (solve1 soundings))
      (println "Part 2: " (solve2 soundings)))))
