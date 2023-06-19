/**
* implement the following list functions 
*/

def last[T](xs: List[T]): T = xs match
    case List() => throw Error("last of empty list")
    case List(x) => x
    case x :: xs1 => last(xs1)

def init[T](xs: List[T]): List[T] = xs match
    case List() => throw Error("init of empty list")
    case List(x) => Nil
    case x :: xs1 => x :: init(xs1)

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match
    case List() => Nil
    case y :: ys => 
        if n == 0 then ys
        else y :: removeAt(n - 1, ys)

val xs = List('a', 'b', 'c', 'd')
removeAt(9, xs)

def flatten(xs: Any): List[Any] = xs match
    case Nil => Nil
    case y :: ys => flatten(y) ++ flatten(ys)
    case _ => xs :: Nil

flatten(List(List(1, 1), 2, List(3, List(5, 8))))

extension [T](xs: List[T])
    def splitAt(n: Int) = (xs.take(n), xs.drop(n))

val nums = List(1, 2, 3, 4, 5, 6)
nums.partition(x => x % 2 == 0)
nums.span(x => x % 2 != 0)

// pack: packs consecutive duplicates of list elements into sublists
def pack[T](xs: List[T]): List[List[T]] = xs match
    case Nil => Nil
    case x :: xs1 => 
        val (fir, snd) = xs.span(y => y == x)
        fir :: pack(snd)

val test = List("a", "a", "a", "b", "c", "c", "a")
pack(test)

// encode: encode in n consecutive duplicates of an element x as a pair (x, n)
def encode[T](xs: List[T]): List[(T, Int)] =
    val packed = pack(xs) 
    packed.map(x => (x.head, x.length))

encode(test)
