// Evaluation Rules
// Call by value: evaluates the function arguments before calling the function
// Call by name: evaluates the function first, and then evaluates the arguments if need be

def example = 2 // <= evaluated when called, what does it mean?
val example = 2 // evaluated immediately
lazy val example = 2 // evaluted once when needed

def square(x: Double) // call by value
def square(x: => Double) // call by name
def myFct(bindings: Int*) = ... // bindings is a sequence of int, containing a varying # of arguments