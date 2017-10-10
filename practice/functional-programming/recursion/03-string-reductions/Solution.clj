; Enter your code here. Read input from STDIN. Print output to STDOUT
;
;TIMES OUT WITH BIG INPUTS
;Given a string remove all repeated chars
(defn reduceStr [str1]
  ;Create a freq hash for ascii chars
  (def freq (atom (vec (take 250 (repeat 0)))))
  
  ;Create an char array from str1
  (def str1Chars (map int (vec (char-array str1))))

  (loop [x 0 
         result []]
    (if (>= x (count str1))    ;if x reaches size of string
      result                      ;return result
      (do                         ;else check whether to add the char to the result
        (if (and  (= (nth @freq (int (nth str1Chars x))) 0))
          (do 
            (swap! freq assoc (int (nth str1Chars x)) 1)
            (recur (inc x) (conj result (nth str1 x)))) ;;Add char if we haven't seen it 
          (recur (inc x) result))))                     ;;Don't add it otherwise
    )
  )

;TIMES OUT WITH BIG IMPUTS
;Given a string remove all repeated chars
(defn reduceStr2 [str1]
  ;Create a freq hash for ascii chars
  (def freq (atom (vec (take 250 (repeat 0)))))
  
  ;Create an char array from str1
  (def str1Chars (map int (vec (char-array str1))))

  ;Create an atom to store result
  (def result (atom []))

  (dotimes [x (count str1)]
    (do
      (if (= (nth @freq (int (nth str1Chars x))) 0)
        (do
          (swap! freq assoc (int (nth str1Chars x)) 1)
          (swap! result conj (nth str1 x))))))

  @result
  )

;Using distinct instead of my methods  
(println (clojure.string/join (distinct (read-line))))

