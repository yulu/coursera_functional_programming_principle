trait Expr
case class Number(n: Int) extends Expr
case class Var(x: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)

var expr = Sum(Number(1), Prod(Number(2), Number(3)))
eval(expr)

def show(e: Expr): String = e match
    case Number(n) => s"$n"
    case Var(x) => x
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1, e2) => s"${help(e1)} * ${help(e2)}"

def help(e: Expr): String = e match
    case e: Sum => s"(${show(e)})"
    case _ => show(e)

var s = show(Sum(Number(1), Prod(Sum(Number(4), Number(5)), Number(3))))
print(s)
