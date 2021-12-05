(ns aoc2021.day2)
(require '[clojure.string :as str])

(defn run-command-1 [[progress depth] [command argument]]
  (condp = command
    "up" [progress (- depth argument)]
    "down" [progress (+ depth argument)]
    "forward" [(+ progress argument) depth]))

(defn parse-command [string]
  (let [[command argument] (str/split string #" ")]
    [command (Integer/parseInt argument)]))

(defn solve1 [commands]
  (let [[progress depth] (reduce run-command-1 [0 0] commands)]
    (* progress depth)))

(defn run-command-2 [[progress aim depth] [command argument]]
  (condp = command
    "up" [progress (- aim argument) depth]
    "down" [progress (+ aim argument) depth]
    "forward" [(+ progress argument) aim (+ depth (* aim argument))]))

(defn solve2 [commands]
  (let [[progress aim depth] (reduce run-command-2 [0 0 0] commands)]
    (* progress depth)))

(defn -main
 [input]
 (with-open [rdr (clojure.java.io/reader input)]
   (let [lines (line-seq rdr)
         commands (map parse-command lines)]
     (println "Part 1: " (solve1 commands))
     (println "Part 2: " (solve2 commands)))))
