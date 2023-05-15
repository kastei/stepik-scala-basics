package exercises

import scala.annotation.tailrec

object GenericList extends App{

  abstract class LogList[+A]{

    def add[B >: A](msg: B): LogList[B]

    def previous(): LogList[A]

    def last(): A

    def isEmpty(): Boolean

    def all(): String
  }

  object Empty extends LogList[Nothing] {

    override def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, Empty)

    override def previous(): LogList[Nothing] = throw new NoSuchElementException

    override def last(): Nothing = throw new NoSuchElementException

    override def isEmpty(): Boolean = true

    override def all(): String = ""
  }

  class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {

    override def add[B >: A](msg: B): LogList[B] = new Log(msg, this)

    override def previous(): LogList[A] = this.tail

    override def last(): A = this.head

    override def isEmpty(): Boolean = false

    override def all(): String = {
      @tailrec
      def loop(list: LogList[A], result: String): String = {
        if (list == Empty) result
        else if (result == "") loop(list.previous(), s"${list.last}")
        else loop(list.previous(), s"$result ${list.last}")
      }

      loop(this, "")
    }

  }

  val list1 = new Log("m1", new Log("m2", new Log("m3", Empty)))
  val list2 = new Log(1, new Log(2, new Log(3, Empty)))

  list1.add("m4")
  list2.add(4)

  println(list1.all())
  println(list2.all())


  val list3 = new Log(list1, Empty)

  println(list3.all())
}

