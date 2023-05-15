package playground

object ScalaPlayground {

    import scala.io.StdIn.readLine

    object main extends App {

        object Person {

            def apply(name: String, surName : String) = s"$name $surName"

            def unapply(personName: String): Option[String] = {
                val stringArray: Array[String] = personName.split(" ")
                if (stringArray.tail.nonEmpty) Some(s"${stringArray.head(0)}. ${stringArray.tail(0)(0)}.") else None
            }

        }

        val input_string = readLine()

        if (input_string == null || input_string.nonEmpty == false) {
            println("Oops, something is wrong")
        } else {
            val p1 = Person(input_string.split(' ')(0), input_string.split(' ')(1))
            p1 match {
                case Person(in) => println(in)
                case _ => println("Oops, something is wrong")
            }
        }
    }

}
