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

