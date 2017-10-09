
(defn reduceStr [strV]
  
  (def result (atom []))
  (def trigger (atom false))
  (dotimes [n (- (count strV) 1)] (do
                                    (if-not @trigger
                                      (do 
                                        (if (= (nth strV n) (nth strV (+ n 1)))
                                            (do (swap! result conj "")
                                                (reset! trigger true))
                                            (swap! result conj (nth strV n))))
                                      (do (swap! result conj "")
                                          (reset! trigger false)))))
  (if-not @trigger
    (swap! result conj (last strV)))
  @result
  )

(def dynStr (atom (clojure.string/split (read-line) #"")))
(def more (atom true))
;(def strIn (clojure.string/split (read-line) #""))
;(def strOut (reduceStr strIn))

(while @more
  (do
    ;(println "running while loop")
    (if(= @dynStr (reduceStr @dynStr))
      (do ;(println (str "dynstr: " @dynStr " reducedDyn: " (reduceStr @dynStr)))
          (reset! more false)))
    (do
      
      (swap! dynStr reduceStr)
      (swap! dynStr #(do (clojure.string/split (clojure.string/join %) #"")))
      ;(println @dynStr)
      )))


;(println (str "@dynstr: " @dynStr "isempty? " (empty? @dynStr)))
(if (empty? (clojure.string/join @dynStr))
  (println "Empty String")
  (do ;(println "not empty?") 
      (println (clojure.string/join @dynStr)))
  )



