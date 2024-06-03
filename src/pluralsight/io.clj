(ns pluralsight.io
  (:require [clojure.java.jdbc :as sql]))

;; side effect occurs when a function interact with data outside of itself
;; on some way endeavor to create pure functions as much as possible!
;; side effects functions returns a nil value println is the simplest example


;; read and writes has two approach reads in or writes to a file line-by-line
;; is the most memory efficient, the second one is with string, this is not efficient
;; and needs to load all string into a memory

(def wbc-logs "
     11/23 08:51:01 INFO :.main ************* Coffee Agent started **********
     11/23 08:51:01 INFO :.main ************* Coffee Agent started **********
     11/23 08:51:01 INFO :.main ************* Coffee Agent started **********
    ")


;; lets you write a string to a file
(spit "my-file.txt" "hello world")
(spit "my-file.txt" "hi" :append true)

;; slurp lets you read the entire contents of a file as string
(slurp "my-file.txt" :encoding "UTF-8")

;; write to a file on line/chuck at a time
(with-open [writer (clojure.java.io/writer "file.txt")]
  (doseq [line (clojure.string/split-lines wbc-logs)]
     (.write writer line)
    (.newLine writer)))


;; Read a file line by line
(with-open [reader (clojure.java.io/reader "file.txt")]
  (doseq [line (line-seq reader)]
     (println line)))

(def connection-info {:subprotocol "postgresql"
                      :subname "//127.0.0.1:5432/wbc"
           						:user "postgres"
           						:password "postgres"})

(println
 (sql/query connection-info ["SELECT * FROM coffee"]))

(sql/insert!
 connection-info
 :coffee
 {:id 2
  :name "wired brain"
 	:origin "french roast"
 	:price 3.00})
