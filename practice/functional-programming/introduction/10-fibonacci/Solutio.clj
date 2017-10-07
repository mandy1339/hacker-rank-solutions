; Enter your code here. Read input from STDIN. Print output to STDOUT
;
(defn fib
  [n res]
  (if (< n 2)
    (do
      (if (= n 0)
        0
        1))
    (do 
      (if (> (nth (deref res) n) 0 )
        (do (def tRes0 (nth (deref res) n))
            ;(println "SKIPPING COMPUTATIONS HAHA")
            tRes0)
        (do (def tRes (+' (fib (- n 1) res) (fib (- n 2) res)))
            (dosync (ref-set res (assoc (deref res) n tRes)))
            ;(println (str "VAL OF res: " (deref res)))
            tRes)))
    ))
    
; 1- Read inputs
(def x (Integer/parseInt (read-line)))
(def res (ref (vec (take 10001 (repeat 0)))))
(dotimes [k x] (println (Integer/parseInt (str (mod (fib (Integer/parseInt (read-line)) res) (+ 100000000 7))))))
