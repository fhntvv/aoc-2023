(ns advent-of-code-2023.day1
  (:require [clojure.java.io :as io]))
;

;--- Day 1: Trebuchet?! ---
;Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.
;You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.
;Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
;You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").
;As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.
;The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

;For example:
;
;1abc2
;pqr3stu8vwx
;a1b2c3d4e5f
;treb7uchet

;In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
;Consider your entire calibration document. What is the sum of all of the calibration values?
;To begin, get your puzzle input.
;
;Answer:
;
;You can also [Share] this puzzle.

(defn read-file
  "Reads all lines from the given file and returns them as a sequence."
  [file-path]
  (with-open [reader (io/reader file-path)]
    (doall (line-seq reader))))

(defn collect-digits [s]
  "Collects all digit characters from a string and converts them to integers."
  (map #(Character/digit (char %) 10) (filter #(Character/isDigit (char %)) s)))

(defn combine-first-and-last-digits
  "Combines the first and last digits of a sequence into a two-digit number."
  [digits]
  (let [first-digit (first digits)
        last-digit (if (seq (rest digits))
                     (last digits)
                     first-digit)]
    (+ (* 10 first-digit) last-digit)))

(defn process-input-lines
  "Processes all input lines to calculate calibration values directly."
  [input-lines]
  (->> input-lines
       (map collect-digits)
       (map combine-first-and-last-digits)))


(defn sum-calibration-values
  "Sums calibration values from the file."
  [file-path]
  (->> (read-file file-path)
       process-input-lines
       (reduce +)))

(defn day1-answer
  "Calculates, prints, and returns the Day 1 answer."
  []
  (let [file-path "resources/day1_input.txt"
        total (sum-calibration-values file-path)]
    (println "Total sum of calibration values:" total)
    total))
