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

    if (network.contains(pointA) && network.contains(pointB)) {
      network
        .updated(pointA, network.getOrElse(pointA, Set.empty) - pointB)
        .updated(pointB, network.getOrElse(pointB, Set.empty) - pointA)
    } else if (network.contains(pointA)) {
      network
        .updated(pointA, network.getOrElse(pointA, Set.empty) - pointB)
    } else if (network.contains(pointB)) {
      network
        .updated(pointB, network.getOrElse(pointB, Set.empty) - pointA)
    } else network
  }

  def nFlights(network: Map[String, Set[String]], location: String) = {
    network.getOrElse(location, Set.empty).size
  }

  def mostFlights(network: Map[String, Set[String]]): String = {
    network.maxByOption(_._2.size).get._1
  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): String = {
    ""
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
    false
  }

  var network : Map[String, Set[String]] = Map.empty
  network = connect(network, "A", "B")
  network = connect(network, "B", "C")
  println(network)

  network = disconnect(network, "B", "B")
  println(network)

  network = disconnect(network, "D", "A")
  println(network)

  println(mostFlights(network))

}
