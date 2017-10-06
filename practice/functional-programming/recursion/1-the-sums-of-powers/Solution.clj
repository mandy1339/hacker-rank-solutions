; Enter your code here. Read input from STDIN. Print output to STDOUT
;
(defn sop
  "double recursion find total ways squares add up to a number"
  [n m lst exhausted]
  
  (if (and (> n 0) (> m -1)) 
    (do 
      (if (= true exhausted)
        (sop n (- m 1) lst false)
        (+ (sop (- n (nth lst m)) m lst true) (sop n (- m 1) lst false))    
        ))
    
    (do (if (= n 0)
          1
          0)))
)

;; MAIN
;; -    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
  ;0- Def vars
  (def vec1 (ref []))

  ;1- Get input
  (def x (Integer/parseInt (read-line)))
  (def n (Integer/parseInt (read-line)))

  ;2- Make a vector according to the x and n
  (dotimes [z x] (do 
                   (if (<= (reduce *' (repeat n (+ z 1))) x) 
                     (dosync (ref-set vec1 (conj (deref vec1) (reduce *' (repeat n (+' z 1)))))))
                   ))

  ;3- Call my sop function
  (print  (sop x (- (count (deref vec1)) 1) (deref vec1) false))
;; -    -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -  
