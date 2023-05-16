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
        .updated(pointA, network.getOrElse(pointA, Set.empty) + pointB)
        .updated(pointB, network.getOrElse(pointB, Set.empty) + pointA)
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {

    network
      .updated(pointA, network.getOrElse(pointA, Set.empty) - pointB)
      .updated(pointB, network.getOrElse(pointB, Set.empty) - pointA)
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

  var network : Map[String, Set[String]] = Map.empty
  network = connect(network, "A", "B")
  network = connect(network, "A", "C")
  println(network)

  network = disconnect(network, "B", "C")
  println(network)

  network = disconnect(network, "B", "A")
  println(network)

}
