  ;ATTEMPT 2
  ;THIS ONE DIDNT WORK BECAUSE CLOJURE'S ARRAY-MAP GET TURNED INTO HASH MAPS
  ;AFTER YOU DO A COUPLE OF ASSOC CALLS. SO IT STOPS KEEPING TRACK OF THE
  ;ORDER OF THE KEYS

  (def row (atom []))
  (def k (atom 2))
  (def t (Integer/parseInt (read-line)))
  (def res (atom (array-map)))
  (def output (atom 0))
  (dotimes [ti t] 
    (do 
      (reset! k  (Integer/parseInt (last (clojure.string/split (read-line) #" "))))
      (reset! row (vec (clojure.string/split (read-line)  #" ")))
      (reset! res (array-map))
      ;Create freq map
      (dotimes [i (count @row)]
        (if (@res (nth @row i))
          (swap! res assoc (nth @row i) (inc (@res (nth @row i))))
          (swap! res assoc (nth @row i) 1)))

;      (println @res)
      

      ;; Phase 2, Filter based on the frequencies (vals)
      (->> (filter #(>= (val %) @k) @res)
           (map first)
           (#(clojure.string/join " " %))
           (reset! output)
           )
      (if (empty? @output)
        (println -1)
        (println @output))
      

      ;; Phase 3, Print the numbers (keys)
      
;(freqFilter @row @k)
      )
    )
