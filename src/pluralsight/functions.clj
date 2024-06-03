(ns pluralsight.functions)

;; in clujure you can produce pure and inpure functions
;; pure functions =  same inputs, same outputs

(defn make-name [first-name]
  (str first-name " Bennet"))

;; functions are firts citizen, you can recieve functions and return functions

;; named functions are bound to a name in clojurre so that you can call later
;; anonymous one-off functions usually passed as arguments, somethis these refee as lamda functions

(defn say-hello [name]
  (str "hello " name))

(say-hello "herman")

;; anonymous
(map (fn [num] (+ num 1)) [1 2 3])

;; short form usage
(map #(+ % 1) [1 2 3])

(#(+ %1 %2) 1 2)

;; multi arity functions are functions that can take a differing number of parameters. For each "arity" there is a unique function implementation
;; varadic functions are functions that can take a differing number of parameters. There is only one function implementation

(defn my-printer
  ([] (my-printer "No parameters!"))
  ([one] (println one))
 	([one two] (println one two)))

(my-printer)
(my-printer "one")
(my-printer "one" "two")
;; (my-printer "one" "two" "three")

;; variadic function example is println
(defn foo [first & rest]
  (println first)
 	(doseq [arg rest] (println arg)))

(foo "first" "second" 3 4 "fifth")

#(println %1 %&)

;; recursion is a means of solving a problem by breaking the problem
;; up into smaller versions of itself

(defn calc-factorial [num]
  (if (zero? num)
	 1
	 (* num (calc-factorial (dec num))))
	)

(calc-factorial 4)
