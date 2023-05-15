package exercises

object FlightsNet extends App{

  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    network + (location -> Set())
  }

  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    network - location
  }

  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    network
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    network
  }

  def nFlights(network: Map[String, Set[String]], location: String) = {
    0
  }

  def mostFlights(network: Map[String, Set[String]]): String = {
    ""
  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): String = {
    ""
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
    false
  }


}
