package exercises

object FlightsNet extends App{

  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    network.updated(location, Set.empty[String])
  }

  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    (network - location).map(kv => kv._1 -> (kv._2 - location))
  }

  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {

    network
      .updated(pointA, network.getOrElse(pointA, Set.empty[String]) + pointB)
      .updated(pointB, network.getOrElse(pointB, Set.empty[String]) + pointA)
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {

    if (network.contains(pointA) && network.contains(pointB)) {
      network
        .updated(pointA, network.getOrElse(pointA, Set.empty[String]) - pointB)
        .updated(pointB, network.getOrElse(pointB, Set.empty[String]) - pointA)
    } else if (network.contains(pointA)) {
      network
        .updated(pointA, network.getOrElse(pointA, Set.empty[String]) - pointB)
    } else if (network.contains(pointB)) {
      network
        .updated(pointB, network.getOrElse(pointB, Set.empty[String]) - pointA)
    } else network
  }

  def nFlights(network: Map[String, Set[String]], location: String) = {
    network.getOrElse(location, Set.empty[String]).size
  }

  def mostFlights(network: Map[String, Set[String]]): String = {
    network.maxBy(_._2.size)._1
  }

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = {
    network.filter(_._2.isEmpty).size
  }

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {

    import scala.annotation.tailrec

    @tailrec
    def loop(query: List[String], marked: Set[String]): Boolean = {

      if (query.isEmpty) false
      else if (network(query.head).contains(pointB)) true
      else loop(query.tail ++ network(query.head).filterNot(a => (query.toSet ++ marked).contains(a)).toList,
                marked + query.head)
    }

    loop(List(pointA), Set.empty[String])

  }

  var network : Map[String, Set[String]] = Map.empty

  network = connect(network, "A", "B")
  network = connect(network, "B", "C")

  println(network)
  print("nLocationsWithNoFlights: ")
  println(nLocationsWithNoFlights(network))

  network = add(network, "D")

  println(network)

  network = disconnect(network, "B", "B")
  println(network)

  network = disconnect(network, "D", "A")
  println(network)

  print("mostFlights: ")
  println(mostFlights(network))

  println(network)
  print("nLocationsWithNoFlights: ")
  println(nLocationsWithNoFlights(network))

  network = add(network, "E")
  println(network)
  print("nLocationsWithNoFlights: ")
  println(nLocationsWithNoFlights(network))

  print("isConnected A-B: ")
  println(isConnected(network, "A", "B"))
  print("isConnected A-C: ")
  println(isConnected(network, "A", "C"))
  print("isConnected A-E: ")
  println(isConnected(network, "A", "E"))

  network = remove(network, "A")
  println(network)


}
