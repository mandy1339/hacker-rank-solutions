
(defn print-n-rotations
  "arg1:
   arg2:
   returns void
   performs: prints every rotation"
  [str1 n]
 
  (def tempStr2 (ref (clojure.string/split str1 #"")))
  
  (def aChar (ref \z))
  
  ;;THE FOLLOWING LINE I HAD TO ADD TO MAKE IT PASS ON HACKER RANK. NORMALLY YOU WOULD REMOVE IT
  ;;#############################################################################################
  (dosync (ref-set tempStr2 (vec (drop 1 (deref tempStr2)))))
  ;;#############################################################################################
  
  (dotimes [x n] (do
                   
                   (dosync (ref-set aChar (first (deref tempStr2))))
                   
                   (dosync (ref-set tempStr2 (vec (drop 1 (deref tempStr2)))))
                   
                   (dosync (ref-set tempStr2 (conj (deref tempStr2) (deref aChar))))
                   
                   (print (apply str (deref tempStr2)))
                   (print " ")
                  ))
  (println "")
)

  

  ;0- Def vars
(def tempStr1 (ref ""))

  ;1- Get input
(def n (Integer/parseInt (read-line)))
(dotimes [x n] (do
                 (dosync (ref-set tempStr1 (read-line)))
                 (print-n-rotations (deref tempStr1) (count (deref tempStr1)))))



