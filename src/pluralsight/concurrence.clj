(ns pluralsight.concurrence)
(import 'java.lang.Thread)

;; concurrent is the art to executing multiple task independently
;; concurrency a programming environment wher multiple parts
;; of a program run independent of one another
;; parallelism a program environment where multiple parts of a program
;; run at the same time
;; thread is a smallest independently executable portion of a program
;; clojure uses STM to manage concurrence transactional memory system
;; STM is like a traffic cop for threads sharing state!
;; use transsaction to manage data mutation
;; follow the ACID principles atomicity, consistencey, isolation and durability
;; shares data amongst threads via a lock-free philosophy
;; when data is locked nothing can change that data until is unlocked
;; atomicity - the transaction will either entire succeed of fail
;; consistency - ensuring that shared data is always in a reliable state
;; isolation - transactions cannot interface with one another
;; durability - transactions don't disappear unexpectedly
;; retry - a transacion can wait and retry if there is a conflict

;; multi-threaded programming
;; common thread operations
;; creating/starting
;; joining - wait one thread finish to join in
;; interrupting - interrump thread work in certain conditions
;; sleep - is simple time pause of their execution

(defn my-thread-function []
  (println "Thread is running")
	(Thread/sleep 3000))

(def my-thread (doto (Thread. my-thread-function)
                 (.setName "MyThread")))

(.start my-thread)
(.interrupt my-thread)
(.join my-thread)

;; concurrency syntax
;; use "dosync", "ref", "alter", and "ref-set" for transactions
;; use agents for asynchronously changing state
;; use atoms for synchronously changing state
;; use dynamic vars for thread-local changing state

;; ref create a variable that is bound to a single storage location
;; and guarantees that mutation of its value only occur within a transaction
(def my-account (ref 10) )

;; to start a transaction, you can use dosync
;; you can use alter or ref-set to change the value of given ref
(dosync (alter my-account + 1000))

;; agents are another very powerfull clojure concurrency primitive
;; its no require to use transaction but is great to use within STM
;; agents provide a non blocking way to mutate a bit of shared state
(def counter (agent 0))

(defn incremet [counter amount] (+ counter amount))

(send counter incremet 5)


;; atom is the name suggests are the simplest primitive building block
;; when it comes to concurrency in clojure, atoms provide you
;; with a really simple way of sharing synchronus state
(def counter-atom (atom 0) )
(swap! counter-atom inc)
(println @counter-atom )

;; dynamic var - this is a thread-local
;; it is important because we can use for thread local storage
;; binding can creates a simple binding that is thread local
;; meaning that it can only be seen by one thread
;; this dynamic metadata tag here which we set to true via the syntax shown
;; tells binding to ensure this is a thread local
;; it will bind its own thread name to this dynamic var
;; allowing us to write a single bit of code that translates
;; across multiple thread contexts
;; (def ^:dynamic *thread-name* "Thread 0" )
;; (defn simulate-transaction [thread-name]
;;   (binding [*thread-name* thread-name]))

;; define a shared account balance using a ref
(def account (ref 1000) )

;; define an atom for shared state
(def transaction-count (atom 0))

;; defining a dynamic var for thread-specific context
(def ^:dynamic *thread-name* "Thread 0" )

;; Function to deposit money into the account using dosync and ref
(defn deposit [amount]
	(dosync
  ( let [current-balance @account new-balance (+ current-balance amount)]
  	(ref-set account new-balance))
		(swap! transaction-count inc); increment transaction count
		(println (str *thread-name* "deposit $" amount))))

;; function to simulate a transaction

(defn simulate-transaction [thread-name]
	(binding [*thread-name* thread-name]; set dynamic var for this thread
	(loop [transactions 0]
  	(when (< transactions 5); perform 5 transaction per thread
		(deposit (rand-int 200))
   		(recur (inc transactions))))))

;; spawn multiple threads to simulate transactions
(defn run-transactions []
  (println "Initial Balance: $" @account)
  (let [thread-names ["thread1" "thread2" "thread3"]]
    (doseq [thread-name thread-names]
      (let [thread (Thread. (fn [] (simulate-transaction thread-name)))]
        (.start thread))))
		(Thread/sleep 3000) ;; wait all threads to complete
  (println "Final balance $" @account)
 	(println "total transactions: " @transaction-count))

(run-transactions)


