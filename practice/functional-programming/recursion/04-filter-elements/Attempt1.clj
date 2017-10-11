; Enter your code here. Read input from STDIN. Print output to STDOUT
;ATTEMPT 1
;THIS ONE DIDNT WORK BECAUSE CLOJURE FREQUENCIES FUNCTION DOESN'T KEEP ORDER
;IN WHICH THEY APPEAR

(defn freqFilter [vec1 k]
  (def filtered (->> vec1
                     frequencies
                     (filter #(>= (val %) k) )
                     (map first)
                     (clojure.string/join " ")))
  (if (empty? filtered)
    (println -1)
    (println filtered)))



(def row (atom []))
(def k (atom 2))
(def t (Integer/parseInt (read-line)))
(dotimes [ti t] 
  (do 
    (reset! k  (Integer/parseInt (last (clojure.string/split (read-line) #" "))))
    (reset! row (vec (clojure.string/split (read-line)  #" ")))
    (freqFilter @row @k)))


