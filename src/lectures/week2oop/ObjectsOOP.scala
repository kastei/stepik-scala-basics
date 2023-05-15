package lectures.week2oop

object ObjectsOOP extends App{

  class MyString(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  class Button(val label: String) {
    def this() = this("test")

    def click() {
      s"button $this.label has been clicked"
    }
  }

  class RoundedButton(override val label: String) extends Button {
    override def click() {
      s"rounded button $this.label has been clicked"
    }
  }

  println(MyString.apply("hello", "world").getString)
  println(MyString.apply("welcome").getString)
}
