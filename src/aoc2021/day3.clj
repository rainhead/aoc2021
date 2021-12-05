(ns aoc2021.day3)

(defn solve1
  [report]
  (let [
        counter (fn [total chr] (+ total (if (= chr \1) 1 -1)))
        reducer (fn [memo line] (map counter memo line))
        totals (reduce reducer (repeat 0) report)
        gamma (reduce (fn [memo total] (+ (* memo 2) (if (> total 0) 1 0))) 0 totals)
        epsilon (reduce (fn [memo total] (+ (* memo 2) (if (< total 0) 1 0))) 0 totals)
        ]
    (println "Gamma: " gamma)
    (println "Epsilon:" epsilon)
    (* gamma epsilon)))

(defn -main
  [input]
  (with-open [rdr (clojure.java.io/reader input)]
    (let [report (line-seq rdr)]
      (println "Part 1: " (solve1 report)))))
