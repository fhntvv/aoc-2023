(ns advent-of-code-2023.core
  (:gen-class)
  (:require [advent-of-code-2023.day1 :as day1]))

(defn -main
  "Entry point of the program."
  [& args]
  (println "Starting the program, reading and printing Day 1 input:")
  (day1/day1-answer))
