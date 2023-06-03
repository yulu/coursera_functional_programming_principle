def sum(f: Int => Int)(a: Int, b: Int): Int =
    if a > b then 0 else f(a) + sum(f)(a + 1, b)

def identity(x: Int): Int = x
def square(x: Int): Int = x * x
def cube(x: Int): Int = x * x * x
def factorial(x: Int): Int = 
    def loop(x: Int, acc: Int): Int = 
        if x == 0 then acc else loop(x - 1, x * acc)
    loop(x, 1)

print(sum(identity)(1,5))
print(sum(square)(3,4))
print(sum(cube)(3,4))

def product(f: Int => Int)(a: Int, b: Int): Int =
    if a > b then 1 else f(a) * product(f)(a + 1, b)

def fact(n: Int) = product(x => x)(1, n)

print(product(identity)(1,4))
print(product(square)(3,4))
print(product(identity)(1,5))
print(fact(5))

def mapReduce(f: (Int => Int) => (Int, Int) => Int)(g: Int => Int)(a: Int, b: Int): Int =
    f(g)(a, b)

print(mapReduce(sum)(identity)(1,5))
print(mapReduce(product)(identity)(1,5))
print(mapReduce(sum)(cube)(3,4))