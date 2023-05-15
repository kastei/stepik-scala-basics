package lectures.week1basics

object Expressions extends App{

  val aVal = 1 + 2 * 3

  val aCondition = true

  val ifExpressionValue = if (aCondition) "True Condition" else "False Condition"
  println(ifExpressionValue) // выведет True Condition

  val someVal: Unit = print("I just want to print")
  println(someVal)
}
