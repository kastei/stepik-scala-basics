package playground

object PartialFunction extends App{

  val chatbot1: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }

  val chatbot = chatbot1.lift

  println(chatbot("fri")) // Some(Party Time)

}
