package exercises

import scala.annotation.tailrec

object LinkedList extends App{

  abstract class LogList {
    def add(msg: String) : LogList
    def previous(): LogList
    def last(): String
    def isEmpty(): Boolean
    def all(): String
  }

  object Empty extends LogList {

    def add(msg: String): LogList = new Log(msg, Empty)

    def last(): String = throw new NoSuchElementException

    def previous(): LogList = throw new NoSuchElementException

    def all(): String = ""

    def isEmpty(): Boolean = true
  }

  class Log(head: String, tail: LogList) extends LogList {
    def last() : String = this.head
    def previous() : LogList = this.tail
    def isEmpty() : Boolean = false
    def all(): String = {
      @tailrec
      def loop(list: LogList, result: String) : String = {
        if (list == Empty) result
        else if (result == "") loop(list.previous(), s"${list.last}")
        else loop(list.previous(), s"$result ${list.last}")
      }
      loop(this, "")
    }
    def add(msg: String) : LogList = new Log(msg, this)
  }

  val list = new Log("m1", new Log("m2", new Log("m3", Empty)))

  list.all()
  println(s"list.last(): ${list.last()}")
  println(s"list.previous().last(): ${list.previous().last()}")


  //println(Empty.last())

  //println(Empty.previous())

}
