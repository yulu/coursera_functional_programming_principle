def max(x: Int, y: Int): Int = 
	if (x > y) x
	else y

def display(game: Option[String]) = game match {
	case Some(s) => s
	case None => "unknown"
}


@main def hello() = 
	val a = (1, 2.3, "hello", List(1,2,3))
	println(a._1)
	println(a._2)
	println(a._3)
	println(a._4)

	val list = List(1,2,3,4,5)
	list.foreach(println)

	println(display(Some("Heroes 3")))
	println(display(None))
