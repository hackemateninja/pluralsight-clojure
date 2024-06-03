(ns pluralsight.collections
  (:require [clojure.set :as set]))

;; there are four types of collections on clojure
;; sequencial = list vectors
;; hashed = sets maps
;; collections are immutable, 
;; list/vectors equality is comparien each elements
;; sets equality is contains the exact same set of elements as one another
;; maps equality contain the same set of key/value pairs as one another

;; lists are sequential linked lists
;; when to use lists?
;; when your data is ordered sequentially in some way
;; when you don't need indexed/fast access
;; when you are accessing the front and back of the sequence frequently

(def my-list '(1 2 3 4) )

;; conj function is available on all sequences
;; conj function in a list add the element to the head of the list

(conj my-list 5)

;; peek lets us access this list as a stack it returs the first element
;; in the list
(peek my-list)

;; pop lets us take the firt item off the list producing a new list
(pop my-list)

(list  1 2 3);; crreates a list from the given armuments

;; Returns true if the given argument is a list
(list?(my-list))

;; vectors are indexed they are like arrays, you can access elements
;; quickly via a numerical index
;; when to use vectors
;; when your data is ordered sequentially in some way
;; when you need indexed/fast access
;; whe you are accessing elements in an arbitrary order

(def my-vec [1 2 3 4] )

(get my-vec 0)

;; creates a new vector from the given arguments
(vector 1 2 3 4)

;; returns true if the given argument is a vector
(vector? my-vec)

;; returns the value at the given index or nil if there is no value present
(get [1 2 3 4] 2)

;; puts the given value inside the given vector at the given index
(assoc [1 2 3] 2 4)

;; creates a subset of a vector given start and end indexes if no end
;; index is supplied, the last index of the vector will be used
(subvec [1 2 3 4 5] 1 3)

;; sets are collection of unordered unique elements
;; when to use sets
;; your data is unordered
;; you are concerned with uniqueness
;; you want set operations

;; adds an element to a set
(conj #{1 2 3 4} 5)

;; returns true if the given set contains the given element
(contains? #{1 2 3 4} 2)

;; removes the given element from the given set
(disj #{1 2 3 4 5 6} 4)

;; Combines two sets producin the union of the twoe
(set/union #{1 2 3 4} #{4 5 6 7 8})

;; Creates a set that consists of all of the elements of set1 that are not
;; present within set2
(set/difference #{1 2 3 4} #{1 2 3 5})

;; creates a set that consists of elements that are present within
;; both sets
(set/intersection #{1 2 3 4 5} #{1 2 3 4})

;; returs a boolean if all element in set1 are present within set2
(set/subset? #{1 2 3} #{1 2 3})

;; maps are collection of unordered key/value pairs
;; when to use maps
;; your data is unordered
;; modeling domain problems/creating custom data types
;; you want fast search, insertion and deletion of elements

(def my-map {:name "herman" :age 30 } )

;; adds key/value pair to the given map - producing a new map
(assoc my-map :name "orlando")

;; returns true if the given map contains the given key
(contains? my-map :name)

;; returns the key/value pair within a vector if there is a matching key
(find my-map :age)

;; returns a list of keys within the given map
(keys my-map)

;; return a list of values within the given map
(vals my-map)

;; Returns a new map minus the key/value pair found via the key argument
(dissoc my-map :age)

;; returs a new map with the result of mergin map2 with map1
(merge my-map {:name "orlando" :age 30})