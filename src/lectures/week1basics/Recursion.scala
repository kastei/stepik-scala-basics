package lectures.week1basics

object Recursion  extends App{

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n, для которого считаем факториал ${n-1}")
      var res = n * factorial(n-1)
      println(s"Вычислили факториал $n")

      res
    }
  }

  //factorial(3)

  import scala.annotation.tailrec

  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n)
  }


  def powerOfTwo(pow: Int): BigInt = {
    @tailrec
    def loop(n: Int, accumulator: BigInt = 1): BigInt = {
      if (n == 0) accumulator
      else loop(n-1, 2*accumulator)
    }
    loop(pow)
  }

  print(powerOfTwo(4))
}
