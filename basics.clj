;; Literals

33 ; integer
-1.5 ; float
"hello" ; string
\c ; character
true ; boolean
nil ; nil (null)

; Collections
'(1 2 3) ; list
[1 2 3] ; vector
#{1 2 3} ; set
{:a 1 :b 2} ; map


;; In Clojure, everything is an expression that evaluates to a value
;; Expressions are evaluated from the inside out
(+ 1 2) ; 3
(+ 1 (* 2 3)) ; 7

;; You can use quote to prevent evaluation
'(1 2 3) ; (1 2 3)
'x ; x

;; def creates a variable
(def x 1) ; x = 1
(+ x 2) ; 3

;; printing
(println "Hello, world!") ; Hello, world!

;; functions
;;    name   params         body
;;    -----  ------  -------------------
(defn greet  [name]  (str "Hello, " name) )
(greet "world") ; "Hello, world"

;; multi-arity functions can have different number of parameters and implementation and also call its other arity
(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println msg)))

(messenger) ; Hello world!
(messenger "Goodbye world!") ; Goodbye world!

;; variadic functions can take any number of arguments
(defn hello [greeting & who] ; & who means that who is a list of all the arguments passed after greeting. Those will be added to a list
  (println greeting who))

(hello "Hello" "world" "and" "universe!") ; Hello (world and universe!)

;; anonymous function
(fn [x] (+ x 1)) ; #function[user/eval1/fn--2]

((fn [x] (+ x 1)) 2) ; 3

;; let creates a local scope
(let [x 1
      y 2]
  (+ x y)) ; 3


;; VECTORS
[1 2 3] ; [1 2 3]
(vector 1 2 3) ; [1 2 3]

;; get element at index
(get [1 2 3] 0) ; 1
;; if out of bounds, returns nil
(get [1 2 3] 3) ; nil

;; count elements
(count [1 2 3]) ; 3

;; adding elements
(conj [1 2 3] 4) ; [1 2 3 4]
(conj [1 2 3] 0 4) ; [1 2 3 0 4]


;; LISTS
'(1 2 3) ; (1 2 3)

;; lists are not listed
(first '(1 2 3)) ; 1
(rest '(1 2 3)) ; (2 3)

;; adding elements with conj goes to the front
(conj '(1 2 3) 4) ; (4 1 2 3)

;; lists can be used as stacks
(def stack '(1 2 3))
(peek stack) ; 1
(pop stack) ; 3


;; SETS
#{"Alice", "Bob", "Kelly" } ; #{"Alice" "Bob" "Kelly"}

;; adding to a set
(conj #{"Alice" "Bob"} "Kelly") ; #{"Alice" "Bob" "Kelly"}

;; remove from a set
(disj #{"Alice" "Bob" "Kelly"} "Bob") ; #{"Alice" "Kelly"}

;; check if an element is in a set
(contains? #{"Alice" "Bob" "Kelly"} "Bob") ; true

;; sorted sets
(conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha") ; #{Alpha Bravo Charlie Sigma}

;; into can convert a collection into another, returning type of first arg
(into #{"Alice" "Bob" "Kelly"} ["Tim" "Sue" "Greg"]) ; #{"Alice" "Bob" "Kelly" "Tim" "Sue" "Greg"}

;; MAPS
(def scores {"Fred"  1400
             "Bob"   1240
             "Angela" 1024})
(def scores {"Fred" 1400, "Bob" 1240, "Angela" 1024})

;; adding to a map
(assoc scores "Alice" 1500) ; {"Fred" 1400, "Bob" 1240, "Angela" 1024, "Alice" 1500}
;; if key already exists, it will be updated

;; removing from a map
(dissoc scores "Bob") ; {"Fred" 1400, "Angela" 1024}

;; get value by key
(get scores "Fred") ; 1400

;; default value if key not found
(get scores "Tim" 0) ; 0

;; contains key
(contains? scores "Fred") ; true
(find scores "Fred") ; ["Fred" 1400]

;; keys
(keys scores) ; ("Fred" "Bob" "Angela")

;; values
(vals scores) ; (1400 1240 1024)

;; zip
(zipmap ["a" "b" "c"] [1 2 3]) ; {"a" 1, "b" 2, "c" 3}
(zipmap ["a" "b" "c"] (repeat 0)) ; {"a" 0, "b" 0, "c" 0}

;; combining maps
(merge scores {"Alice" 1500, "Bob" 1300}) ; {"Fred" 1400, "Bob" 1300, "Angela" 1024, "Alice" 1500}
;; if key already exists, it will be updated

;; defining a map with keywords
(def person {:name "Alice" :age 30 :city "London"})
;; keywords are like strings but with a colon in front

;; get value by keyword
(:name person) ; "Alice"


;; IF
(str "2 is " (if (even? 2) "even" "odd")) ; "2 is even"

;; else
(str "3 is " (if (even? 3) "even" "odd")) ; "3 is odd"

;; all values are logically true or false. The only "false" values are false and nil

;; if and do
(if (even? 2)
  (do (println "2 is even")
      true)
  (do (println "2 is odd")
      false))

;; cond
(let [x 11]
  (cond
    (< x 2)  "x is less than 2"
    (< x 10) "x is less than 10"
    :else  "x is greater than or equal to 10"))

;; case
(defn foo [x]
         (case x
           5 "x is 5"
           10 "x is 10"))
(foo 10) ; "x is 10"

;; dotimes
(dotimes [i 3]
  (println i)) ; 0 1 2

;; doseq
(doseq [n (range 3)]
         (println n)) ; 0 1 2