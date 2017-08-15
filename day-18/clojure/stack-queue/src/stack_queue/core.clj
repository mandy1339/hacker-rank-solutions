(ns stack-queue.core
  (:require [stack-queue.file2 :as f])
  (:gen-class))


(defn -main
  "Check for a palindrome in the given user input
  by storing the chars into a stack, a queue
  and then dequeing/popping and comparing"
  []
  (println "Hello, World!")
  
  ;;declare dynamic queue and stack variables
  ;;the methods reside in the stack-queue.file2 namespace
  (def my-queue (atom []))
  (def my-stack (atom []))

  ;;take input from user
  (def input (read-line))
  ;;turn it into an array
  (def character-array (clojure.string/split input #""))

  ;;store the array into the queue and stack char by char
  (doseq [x character-array] (f/enqueue x my-queue) (f/push-char x my-stack))
  
  ;;prepare bindings to run a loop on half the size of the queue
  (let [a (take (/ (count @my-queue) 2) @my-queue) palindrome (atom true)]
    ;;run loop and check if for different chars, palindrome var can change
    (doseq [x a] (if (not= (f/dequeue my-queue) (f/pop-char my-stack)) (reset! palindrome false)))
    ;;print result accordingly
    (if @palindrome
      (println "It's a palindrome")
      (println "It's not a palindrome")))
  
)




