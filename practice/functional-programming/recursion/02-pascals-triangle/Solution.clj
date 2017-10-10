; Enter your code here. Read input from STDIN. Print output to STDOUT
;


(defn factorial [n]
  (reduce * (range 1 (+ n 1))))


(defn makePascalVal [n r]
  ;n!/(r!*(n-r)!)
  (-> (factorial n)
      (/ (do
           (-> (factorial r)
               (* (do 
                    (factorial (- n r))))))))
  )



(defn makeRow [n]
  (loop 
      [x 0 result []]
    (if (< x (+ n 1) ) 
      (do ;(println x)
          
          (recur (inc x ) 
                 (conj result (makePascalVal n x))))
      result)
    ))
    

;Recursively decrease n to 0, and then work your way up calling makerow
(defn goDown [n]
  (if (= n 0)
    (println (clojure.string/join " " (makeRow 0)))
    (do (goDown (- n 1))
        (println (clojure.string/join " " (makeRow n)))        
        )
     )
  )


(defn startGoDown [n]
  (goDown (- n 1)))






(-> (read-line)
    Integer/parseInt
    startGoDown)
