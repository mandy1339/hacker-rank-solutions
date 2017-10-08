(use '[clojure.string :only (split triml)])

; E-POWER-APPROXIMATION
(defn eappr [n]
  (-> 1
      (+ n)
      (+ (-> (Math/pow n 2)
             (/ 2)))
      (+ (-> (Math/pow n 3)
             (/ (* 3 2))))
      (+ (-> (Math/pow n 4)
             (/ (* 4 3 2))))
      (+ (-> (Math/pow n 5)
             (/ (* 5 4 3 2))))
      (+ (-> (Math/pow n 6)
             (/ (* 6 5 4 3 2))))
      (+ (-> (Math/pow n 7)
             (/ (* 7 6 5 4 3 2))))
      (+ (-> (Math/pow n 8)
             (/ (* 8 7 6 5 4 3 2))))
      (+ (-> (Math/pow n 9)
             (/ (* 9 8 7 6 5 4 3 2))))))

; FAKE MAIN
; -   -   -   -   -   -   -   -   -   -   -   -   -
(
        let [
          n_t (read-line) 
          n (Integer/parseInt n_t) 
        ]

      (
        loop [a0 n]
        (when (> a0 0)

          (
            let [
              x_t (read-line) 
              x (Float/parseFloat x_t) 
            ]
             (println (format "%.4f" (eappr x)))
          )

        (recur (- a0 1) ) )
      )

)

