 (fn[num lst]
    (def result (atom ()))
    (dotimes [x (count lst)] (dotimes [y num] (swap! result conj (nth lst x))))
    (swap! result reverse)
    )



;;  Number Of Parameters: 2
;;  Parameters: [number of times to replicate elements, list]
;;  Returns: List or Vector
