package lectures.week1basics

object TypesValuesVariables extends App {

  //val aString: String = "Hello"
  //println(aString)

  val aLong = 11L
  println(aLong.getClass)

  var anInt = 1
  anInt += 1

  var aString = "abc"
  aString += "defg"

  println(aString)

  val someFloatVal = 53.249
  println(someFloatVal.getClass)

}
