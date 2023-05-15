package exercises

object LogSystem extends App{

  class Logger(val NumMsg: Int = 0) {

    def info(): Logger = {
      println("INFO New Message")
      new Logger(NumMsg+1)
    }

    def info(msgCount: Int): Logger = {
      if (msgCount <= 0) this
      else info.info(msgCount-1)
    }

    def print(): Unit = println(NumMsg)
  }

  val logger = new Logger
  logger.info.print
  logger.info(3).print
  logger.info.info.info.print
}
