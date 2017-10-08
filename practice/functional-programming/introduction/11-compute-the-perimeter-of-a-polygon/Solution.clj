;DIST()
(defn dist [p1 p2]
  ;p1 [x1, y1]   p2 [x2 y2]
  ;(Math/sqrt (Math/pow (- (second p2) (second p1)) 2))
  (-> 
   (second p2)
   (- (second p1))
   (Math/pow 2)
   (+ (-> (first p2) (- (first p1)) (Math/pow 2)))
   (Math/sqrt)))


;MAIN
(def totDist (atom 0))
  (def polygon (atom []))
  ; 1- Read inputs
  (def noPts (Integer/parseInt (read-line)))
  (dotimes [n noPts] 
    (def rline (clojure.string/split (read-line) #" "))
    (def n1 (Integer/parseInt (first rline)))
    (def n2 (Integer/parseInt (nth rline (- (count rline) 1))))
    ;(println (str  rline " " n1 " " n2))
    (swap! polygon conj [n1 n2])
    )
  ;(println (str "Polygon: " @polygon))
;  (def inp1 [[0 0] [0 1] [1 1] [1 0]])
  (def inpb (conj @polygon (first @polygon)))
  (dotimes [n (-  (count inpb) 1)]
    (->> 
     (dist (nth inpb n) (nth inpb (+ n 1)))
     (swap! totDist +))
    )
  (println  @totDist)
