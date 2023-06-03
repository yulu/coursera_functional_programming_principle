abstract class IntSet:
    def contains(x: Int): Boolean
    def incl(x: Int): IntSet
    def union(other: IntSet): IntSet
end IntSet

class Empty() extends IntSet:
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())
    def union(other: IntSet) = other
end Empty

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
    def contains(x: Int): Boolean = 
        if x < elem then left.contains(x)
        else if x > elem then right.contains(x)
        else true
    def incl(x: Int): IntSet = 
        if x < elem then NonEmpty(elem, left.incl(x), right)
        else if x > elem then NonEmpty(elem, left, right.incl(x))
        else this
    def union(other: IntSet) = 
        left.union(right).union(s).incl(elem)
        
end NonEmpty

object IntSet:
    def singleton(x: Int) = NonEmpty(x, Empty(), Empty())


IntSet.singleton(1)