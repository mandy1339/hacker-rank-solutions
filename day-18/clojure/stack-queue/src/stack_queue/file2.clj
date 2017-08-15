(ns stack-queue.file2
  (:require [stack-queue.file3 :as f3]))

(defn fn1
  ""
  []
  (println "file2")
  (def queue (atom []))
  (f3/printhi))

(defn enqueue
  "enqueue an item into the queue
  arg1: item to enqueue
  arg2: queue"
  [item queue]
  (swap! queue conj item))

(defn dequeue
  "dequeue an item from the queue
  arg1: queue
  returns the char that got removed"
  [queue]
  (def charac (first @queue))
  (swap! queue #(drop 1 %))
  charac
  )


(defn push-char
  [item stack]
  (swap! stack conj item))


(defn pop-char
  [stack]
  (def charac (last @stack))
  (swap! stack drop-last)
  charac)
