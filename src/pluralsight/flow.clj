(ns pluralsight.flow)

;; control flow is a term used to describe the ability to direct
;; the order in wich a computer executes certain statements, expressions, and 
;; or functions
;; in clojure, a control flow operator is a symbol that instructs
;; the compiler to perfom a certain, logical operation.
;; These operators are expressions
;; control frow expressions are 3 conditional iterative exception

;; conditional = direct flow of control through logical operands
;; iterative = loop over collections to perfom side effects or generate output
;; exception handling direct flow of control by catching and throwing errors

;; conditional expression a unit of code that evaluates to a boolean value

;; if
(if (odd? 3)
 true
 false)

;; if/do

(if (odd? 3)
 (do (println "3 is odd!") true)
 (do (println "3 is not odd!") false))

;; use when is like if/do without the "else" condition
(when (number? 2)
  (println "input is a number!") true)

;; The case conditional executes code depending upon matches to an argument
(case 1
  1 "the input was 1"
 	2 "the input was 2"
 	3 "the input was 3"
 	"the input was not found")

;; using con with else keyword allows you to 
;;chain many if conditionals together with a final 
;; else clause

(defn conditional [input]
  (cond
   	(= input 1) "input is 1"
  	(= input 2) "input is 2"
  	(= input 3) "input is 3"
  	:else "input is not 1 or 2 or 3"))

(conditional 2)

;; iterations with no side effect your iteration does not produce an output
;; without side effects your iteration is "pure" and produces an output
;; dotimes,the first is via a construct known as dotimes. Dotimes is used to run a
;; simple expression as a side effect a given number of times
;; doseq is for iteration over a given sequence such as a list or vector

(dotimes [n 5]
  (println (str "my number is: " n)))

(doseq [num-one [1 2 3]
        num-two [4 5 6]]
		(println num-one " " num-two))

;; pure iteration 

(for [num-one [1 2 3] num-two [4 5 6]] [num-one num-two])

;; exception handling

(try
  (println "first try")
 	(catch RuntimeException e "hu-oh!")
 	(finally (println "always runs!")))

;; (throw (Exeption. "uh-oh!"))