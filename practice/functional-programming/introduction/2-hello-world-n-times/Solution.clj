(defn hello_word_n_times[n]
    ; Write your code here
    (dotimes [m n] (println "Hello World"))
)


(def n (Integer/parseInt (read-line)))
(hello_word_n_times n)
