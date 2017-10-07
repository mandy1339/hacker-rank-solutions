;Number Of Parameters: 1
;Parameters: [list]
;Returns: List or Vector

(fn[lst]
  (def paired (map-indexed vector lst))
  (def filtered (filter #(odd? (first %)) paired))
  (map second filtered)
)
